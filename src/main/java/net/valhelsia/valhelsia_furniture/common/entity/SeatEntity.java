package net.valhelsia.valhelsia_furniture.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.valhelsia.valhelsia_furniture.common.block.SeatableBlock;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author Valhelsia Team
 * @since 2022-01-21
 */
public class SeatEntity extends Entity {

    private EjectType ejectType = EjectType.NORTH;

    public SeatEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public SeatEntity(BlockPos pos, double yOffset, Level level) {
        super(ModEntities.SEAT.get(), level);
        this.setPos(pos.getX() + 0.5D, pos.getY() + yOffset, pos.getZ() + 0.5D);

        this.getSeatableBlock(level, pos).ifPresent(seatableBlock -> {
            this.ejectType = seatableBlock.getEjectType();
        });
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide()) {
            BlockPos pos = this.blockPosition();

            if (this.getPassengers().isEmpty() || this.level.isEmptyBlock(pos)) {
                this.discard();

                this.level.updateNeighbourForOutputSignal(pos, this.level.getBlockState(pos).getBlock());
            }
        }
    }

    @Override
    public void remove(@Nonnull RemovalReason reason) {
        if (reason == RemovalReason.DISCARDED) {
            this.getPassengers().forEach(Entity::stopRiding);
        }
        super.remove(reason);
    }

    @Nonnull
    @Override
    public Vec3 getDismountLocationForPassenger(@Nonnull LivingEntity livingEntity) {
        BlockPos pos = this.blockPosition();

        if (this.getSeatableBlock(this.level, pos).isEmpty()) {
            return super.getDismountLocationForPassenger(livingEntity);
        }

        int[][] offsets = DismountHelper.offsetsForDirection(this.ejectType.getPreferredDirection(this.level.getBlockState(pos), livingEntity).getCounterClockWise());
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (Pose pose : livingEntity.getDismountPoses()) {
            AABB aabb = livingEntity.getLocalBoundsForPose(pose);

            for (int[] offset : offsets) {
                mutableBlockPos.set(pos.getX() + offset[0], pos.getY(), pos.getZ() + offset[1]);
                double floorHeight = this.level.getBlockFloorHeight(mutableBlockPos);

                if (DismountHelper.isBlockFloorValid(floorHeight)) {
                    Vec3 vec3 = Vec3.upFromBottomCenterOf(mutableBlockPos, floorHeight);

                    if (DismountHelper.canDismountTo(this.level, livingEntity, aabb.move(vec3))) {
                        livingEntity.setPose(pose);

                        return vec3;
                    }
                }
            }
        }
        return super.getDismountLocationForPassenger(livingEntity);
    }

    private Optional<SeatableBlock> getSeatableBlock(Level level, BlockPos pos) {
        return level.getBlockState(pos).getBlock() instanceof SeatableBlock seatableBlock ? Optional.of(seatableBlock) : Optional.empty();
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(@Nonnull CompoundTag tag) {
        this.ejectType = EjectType.fromName(tag.getString("EjectType"));
    }

    @Override
    protected void addAdditionalSaveData(@Nonnull CompoundTag tag) {
        tag.putString("EjectType", this.ejectType.name);
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0D;
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public enum EjectType {
        NORTH("north", (state, livingEntity) -> Direction.NORTH),
        BLOCK_HORIZONTAL_FACING("block_horizontal_facing", (state, livingEntity) -> state.getValue(BlockStateProperties.HORIZONTAL_FACING)),
        ENTITY_HEAD_ROTATION("entity_head_rotation", (state, livingEntity) -> Direction.fromYRot(livingEntity.yHeadRot));

        private final String name;
        private final BiFunction<BlockState, LivingEntity, Direction> preferredDirection;

        EjectType(String name, BiFunction<BlockState, LivingEntity, Direction> preferredDirection) {
            this.name = name;
            this.preferredDirection = preferredDirection;
        }

        public String getName() {
            return this.name;
        }

        public Direction getPreferredDirection(BlockState state, LivingEntity livingEntity) {
            return this.preferredDirection.apply(state, livingEntity);
        }

        public static EjectType fromName(String name) {
            return Arrays.stream(EjectType.values()).filter(ejectType -> ejectType.getName().equals(name)).findFirst().orElse(EjectType.NORTH);
        }
    }
}
