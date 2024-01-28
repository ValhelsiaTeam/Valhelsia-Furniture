package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

/**
 * @author Valhelsia Team
 * @since 2022-11-08
 */
public interface SeatableBlock {

    SeatEntity.EjectType getEjectType();

    default double getRidingOffset() {
        return 0.6D;
    }

    default boolean isSeatOccupied(EntityGetter entityGetter, BlockPos pos) {
        return !entityGetter.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).isEmpty();
    }

    default void sitOnBlock(Level level, BlockPos pos, LivingEntity entity) {
        if (!this.isSeatOccupied(level, pos)) {
            SeatEntity chair = new SeatEntity(pos, this.getRidingOffset(), level, this.getEjectType());

            level.addFreshEntity(chair);
            entity.startRiding(chair);

            level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
        }
    }

    default void trySitEntityOnBlock(Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof Player || level.hasNeighborSignal(pos)) {
                return;
            }

            this.sitOnBlock(level, pos, livingEntity);
        }
    }
}
