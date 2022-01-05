package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Table Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.TableBlock
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-02
 */
public class TableBlock extends Block {

    private static final BooleanProperty ROTATED = ModBlockStateProperties.ROTATED;

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 4.0D, 12.0D, 4.0D),
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D),
            Block.box(12.0D, 0.0D, 1.0D, 15.0D, 12.0D, 4.0D)
    );

    public TableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROTATED, false).setValue(WATERLOGGED, false));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        boolean rotated = context.getHorizontalDirection().getAxis() == Direction.Axis.X;
        boolean flag = level.getFluidState(pos).getType() == Fluids.WATER;

        BlockState state = tryConnect(level, this.defaultBlockState(), pos, flag);

        if (state.getBlock() instanceof TableBlock) {
            state = state.setValue(ROTATED, rotated);
        }

        return state;
    }

    public static BlockState tryConnect(LevelAccessor level, BlockState state, BlockPos pos, boolean waterlogged) {
        BlockState connected = ModBlocks.CONNECTED_BLUE_OAK_TABLE.get().defaultBlockState();

        for (Direction direction : Direction.values()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                continue;
            }

            BlockState offsetState = level.getBlockState(pos.relative(direction));

            if (offsetState.getBlock() instanceof TableBlock) {
                return connected.setValue(ConnectedTableBlock.PROPERTY_BY_DIRECTION.get(direction), true).setValue(WATERLOGGED, waterlogged);
            }
        }

        return state;
    }

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction.getAxis() == Direction.Axis.Y) {
            return state;
        }

        if (neighborState.getBlock() instanceof ConnectedTableBlock && neighborState.getValue(ConnectedTableBlock.PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) {
            return ModBlocks.CONNECTED_BLUE_OAK_TABLE.get().defaultBlockState().setValue(ConnectedTableBlock.PROPERTY_BY_DIRECTION.get(direction), true);
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTATED, WATERLOGGED);
    }
}
