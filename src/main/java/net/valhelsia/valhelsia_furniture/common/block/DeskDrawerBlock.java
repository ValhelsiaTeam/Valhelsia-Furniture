package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.entity.DeskDrawerBlockEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-05-13
 */
public class DeskDrawerBlock extends DeskBlock implements EntityBlock {

    private static final VoxelShape DRAWER_SHAPE = Block.box(1.0D, 4.0D, 1.0D, 15.0D, 12.0D, 15.0D);
    private static final Map<Direction, VoxelShape> LEFT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 4.0D, 1.0D, 1.0D, 12.0D, 4.0D));
    private static final Map<Direction, VoxelShape> RIGHT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(15.0D, 4.0D, 1.0D, 16.0D, 12.0D, 4.0D));

    private final Map<BlockState, VoxelShape> shapesCache;

    public DeskDrawerBlock(TagKey<Block> tag, Properties properties) {
        super(tag, properties);
        this.shapesCache = this.getShapeForEachState(this::calculateShape);
    }

    private VoxelShape calculateShape(BlockState state) {
        Direction facing = state.getValue(FACING);
        boolean left = state.getValue(LEFT);
        boolean right = state.getValue(RIGHT);

        VoxelShape shape = Shapes.or(SHAPE, DRAWER_SHAPE);

        if (left && right) {
            shape = Shapes.or(shape, LEFT_CONNECT_SHAPES.get(facing.getOpposite()), RIGHT_CONNECT_SHAPES.get(facing.getOpposite()));
        } else if (left) {
            shape = Shapes.or(shape, LEFT_CONNECT_SHAPES.get(facing.getOpposite()));
        } else if (right) {
            shape = Shapes.or(shape, RIGHT_CONNECT_SHAPES.get(facing.getOpposite()));
        }

        return shape;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new DeskDrawerBlockEntity(pos, state);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        if (level.getBlockEntity(pos) instanceof DeskDrawerBlockEntity blockEntity) {
            player.openMenu(blockEntity);
            player.awardStat(Stats.OPEN_BARREL);
            PiglinAi.angerNearbyPiglins(player, true);
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof Container container) {
                Containers.dropContents(level, pos, container);
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
}
