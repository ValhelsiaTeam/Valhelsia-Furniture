package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Valhelsia Team
 * @since 2022-05-15
 */
public class FabricDeskLampBlock extends Block implements SimpleWaterloggedBlock {

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D),
            Block.box(7.0D, 3.0D, 7.0D, 9.0D, 7.0D, 9.0D),
            Block.box(4.0D, 7.0D, 4.0D, 12.0D, 14.0D, 12.0D)
    );

    public static final BooleanProperty SWITCHED_ON = ModBlockStateProperties.SWITCHED_ON;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public FabricDeskLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(SWITCHED_ON, false)
                .setValue(POWERED, false)
                .setValue(WATERLOGGED, false)
        );
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        boolean flag = level.getFluidState(pos).getType() == Fluids.WATER;
        boolean powered = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());

        return this.defaultBlockState().setValue(POWERED, powered).setValue(WATERLOGGED, flag);
    }

    @NotNull
    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        level.setBlockAndUpdate(pos, state.setValue(SWITCHED_ON, !state.getValue(SWITCHED_ON)));

        return InteractionResult.SUCCESS;
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource randomSource) {
        if (state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, tickAccess, pos, direction, neighborPos, neighborState, randomSource);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean isMoving) {
        boolean powered = level.hasNeighborSignal(pos);

        if (state.getValue(POWERED) != level.hasNeighborSignal(pos)) {
            level.setBlockAndUpdate(pos, state.setValue(POWERED, powered).setValue(SWITCHED_ON, powered != state.getValue(SWITCHED_ON)));
        }
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SWITCHED_ON, POWERED, WATERLOGGED);
    }

    @NotNull
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
