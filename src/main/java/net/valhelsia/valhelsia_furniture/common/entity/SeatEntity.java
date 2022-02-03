package net.valhelsia.valhelsia_furniture.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;

import javax.annotation.Nonnull;

/**
 * Seat Entity <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.entity.SeatEntity
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-21
 */
public class SeatEntity extends Entity {

    public SeatEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public SeatEntity(BlockPos pos, double yOffset, Level level) {
        super(ModEntities.SEAT.get(), level);
        this.setPos(pos.getX() + 0.5D, pos.getY() + yOffset, pos.getZ() + 0.5D);
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
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(@Nonnull CompoundTag tag) {

    }

    @Override
    protected void addAdditionalSaveData(@Nonnull CompoundTag tag) {

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
}
