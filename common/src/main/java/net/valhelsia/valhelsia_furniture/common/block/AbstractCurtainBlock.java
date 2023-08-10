package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.api.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.OpenCurtainPart;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public abstract class AbstractCurtainBlock<T extends CurtainPart> extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    private static final VoxelShape BRACKET_SHAPE = Block.box(0.0D, 14.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);

    public static final Map<Direction, VoxelShape> TOP_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(SHAPE, BRACKET_SHAPE));
    public static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(SHAPE);
    public static final Map<Direction, VoxelShape> BRACKET_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(BRACKET_SHAPE);

    private final DyeColor color;

    public AbstractCurtainBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
    }

    @NotNull
    @Override
    public VoxelShape getBlockSupportShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos) {
        return Shapes.empty();
    }

    public DyeColor getColor() {
        return this.color;
    }

    @NotNull
    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.CONSUME;
        }

        this.updateOpen(state, level, pos);

        return InteractionResult.SUCCESS;
    }

    protected abstract void updateOpen(BlockState state, Level level, BlockPos pos);

    protected abstract T getPart(BlockState state);

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        boolean powered = level.hasNeighborSignal(pos);

        if (state.getValue(POWERED) != level.hasNeighborSignal(pos)) {
            level.setBlockAndUpdate(pos, state.setValue(POWERED, powered));

            if (powered) {
                this.updateOpen(state, level, pos);
            }
        }
    }

    protected BlockPos getTopBlock(LevelAccessor level, BlockPos currentPos) {
        BlockPos.MutableBlockPos pos = currentPos.mutable();
        BlockState state = level.getBlockState(pos.above());

        while (state.is(this) && !this.getPart(state).isBottomOrSingle()) {
            pos.move(Direction.UP);

            state = level.getBlockState(pos.above());
        }

        return pos.immutable();
    }

    protected void openRows(Level level, BlockState state, BlockPos.MutableBlockPos topPos, Direction direction, Direction baseDirection, int length) {
        boolean leftDirection = baseDirection.getClockWise() == direction;

        while (true) {
            topPos.move(direction);

            if (!this.isConnected(level, state, topPos, length)) {
                break;
            }

            boolean leftConnected = !leftDirection || this.isConnected(level, state, topPos, baseDirection.getClockWise(), length);
            boolean rightConnected = leftDirection || this.isConnected(level, state, topPos, baseDirection.getCounterClockWise(), length);

            this.openRow(level, topPos, length, leftConnected, rightConnected);
        }
    }

    protected abstract void openRow(Level level, BlockPos topPos, int length, boolean leftConnected, boolean rightConnected);

    protected boolean isConnected(LevelAccessor level, BlockState state, BlockPos pos, Direction direction, int length) {
        return this.isConnected(level, state, pos.relative(direction), length);
    }

    private boolean isConnected(LevelAccessor level, BlockState state, BlockPos neighborPos, int length) {
        BlockState neighborState = level.getBlockState(neighborPos);

        if (!this.shouldUpdateTogether(level, state, neighborPos, length)) {
            return false;
        }

        CurtainPart part = this.getPart(neighborState);

        return part.isTopOrSingle() || this.bothSingle(state, neighborState) || part == OpenCurtainPart.LEFT || part == OpenCurtainPart.RIGHT;
    }

    private boolean shouldUpdateTogether(LevelAccessor level, BlockState state, BlockPos neighborPos, int length) {
        BlockState neighborState = level.getBlockState(neighborPos);

        if (!this.belongTogether(state, neighborState)) {
            return false;
        }

        if (this.isOpen() && (this.getPart(state).isSingleRow() || this.getPart(neighborState).isSingleRow())) {
            return false;
        }

        return this.getCurtainLength(level, neighborPos) == length;
    }

    protected abstract boolean isOpen();

    private boolean belongTogether(BlockState state, BlockState neighborState) {
        return neighborState.is(this) && this.hasSameFacing(state, neighborState);
    }

    private boolean bothSingle(BlockState state, BlockState neighborState) {
        return this.getPart(state).isSingle() && this.getPart(neighborState).isSingle();
    }

    private boolean hasSameFacing(BlockState state, BlockState neighborState) {
        return state.getValue(FACING) == neighborState.getValue(FACING);
    }

    protected int getCurtainLength(LevelAccessor level, BlockPos topPos) {
        BlockPos.MutableBlockPos pos = topPos.mutable().move(Direction.DOWN);
        BlockState state = level.getBlockState(pos);

        int length = 1;

        while (state.is(this) && !this.getPart(state).isTopOrSingle()) {
            state = level.getBlockState(pos.move(Direction.DOWN));

            length++;
        }

        return length;
    }

    protected abstract T connect(BlockState aState, BlockState bState, Direction facing);

    @NotNull
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @NotNull
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
