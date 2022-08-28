package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import org.apache.commons.lang3.function.TriFunction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-05-17
 */
public class CurtainBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D));
    public static BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static EnumProperty<CurtainPart> PART = ModBlockStateProperties.CURTAIN_PART;


    private static final TriFunction<BlockState, BlockState, Direction, CurtainPart> CONNECT_FUNCTION = (aState, bState, facing) -> CurtainPart.getTypeForConnections(
            aState.getBlock() instanceof CurtainBlock && aState.getValue(FACING) == facing && !aState.getValue(OPEN),
            bState.getBlock() instanceof CurtainBlock && bState.getValue(FACING) == facing  && !bState.getValue(OPEN));

    public CurtainBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(OPEN, false)
                .setValue(PART, CurtainPart.SINGLE)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nonnull
    @Override
    public VoxelShape getBlockSupportShape(@Nonnull BlockState state, @Nonnull BlockGetter blockGetter, @Nonnull BlockPos pos) {
        return Shapes.empty();
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return state.getValue(PART) == CurtainPart.MIDDLE && state.getValue(OPEN) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.CONSUME;
        }

        this.updateOpen(state, level, pos);

        return InteractionResult.SUCCESS;
    }

    private void updateOpen(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos) {
        Direction base = state.getValue(FACING);
        Direction left = base.getClockWise();
        Direction right = base.getCounterClockWise();
        boolean open = state.getValue(OPEN);

        BlockPos topPos = this.getTopBlock(level, pos, open);
        int length = this.getCurtainLength(level, topPos, open);

        boolean leftConnected = this.isConnected(level, state, topPos, left, length, open);
        boolean rightConnected = this.isConnected(level, state, topPos, right, length, open);

        this.openRow(level, topPos, length, leftConnected, rightConnected, open);

        if (leftConnected) {
            this.openRows(level, state, topPos.mutable(), left, base, length, open);
        }

        if (rightConnected) {
            this.openRows(level, state, topPos.mutable(), right, base, length, open);
        }
    }

    private void openRows(Level level, BlockState state, BlockPos.MutableBlockPos topPos, Direction direction, Direction baseDirection, int length, boolean open) {
        boolean leftDirection = baseDirection.getClockWise() == direction;

        while (true) {
            topPos.move(direction);

            if (!this.isConnected(level, state, topPos, length, open)) {
                break;
            }

            boolean leftConnected = !leftDirection || this.isConnected(level, state, topPos, baseDirection.getClockWise(), length, open);
            boolean rightConnected = leftDirection || this.isConnected(level, state, topPos, baseDirection.getCounterClockWise(), length, open);

            this.openRow(level, topPos, length, leftConnected, rightConnected, open);
        }
    }

    private boolean isConnected(LevelAccessor level, BlockState state, BlockPos pos, Direction direction, int length, boolean open) {
        return this.isConnected(level, state, pos.relative(direction), length, open);
    }

    private boolean isConnected(LevelAccessor level, BlockState state, BlockPos neighborPos, int length, boolean open) {
        BlockState neighborState = level.getBlockState(neighborPos);

        if (!this.shouldUpdateTogether(level, state, neighborPos, length, open)) {
            return false;
        }

        CurtainPart part = neighborState.getValue(PART);

        return part.isTopOrSingle() || this.bothSingle(state, neighborState) || part == CurtainPart.LEFT || part == CurtainPart.RIGHT;
    }

    private boolean shouldUpdateTogether(LevelAccessor level, BlockState state, BlockPos neighborPos, int length, boolean open) {
        BlockState neighborState = level.getBlockState(neighborPos);

        if (!this.belongTogether(state, neighborState)) {
            return false;
        }

        if (open && (state.getValue(PART).isSingleRow() || neighborState.getValue(PART).isSingleRow())) {
            return false;
        }

        return this.getCurtainLength(level, neighborPos, open) == length;
    }

    private boolean belongTogether(BlockState state, BlockState neighborState) {
        return neighborState.is(state.getBlock()) && this.hasSameFacing(state, neighborState) && this.isOpen(state) == this.isOpen(neighborState);
    }

    private boolean bothSingle(BlockState state, BlockState neighborState) {
        return state.getValue(PART) == CurtainPart.SINGLE && neighborState.getValue(PART) == CurtainPart.SINGLE;
    }

    private boolean hasSameFacing(BlockState state, BlockState neighborState) {
        return this.getFacing(state) == this.getFacing(neighborState);
    }

    private void openRow(Level level, BlockPos topPos, int length, boolean leftConnected, boolean rightConnected, boolean open) {
        for (int i = 0; i < length; i++) {
            BlockState state = level.getBlockState(topPos.below(i));
            CurtainPart part = state.getValue(PART);

            CurtainPart newPart = part;

            if (length == 1) {
                if (leftConnected && rightConnected) {
                    newPart = open ? CurtainPart.SINGLE : CurtainPart.TOP;
                }

                if (leftConnected && !rightConnected) {
                    newPart = open ? CurtainPart.SINGLE : CurtainPart.RIGHT;
                }

                if (rightConnected && !leftConnected) {
                    newPart = open ? CurtainPart.SINGLE : CurtainPart.LEFT;
                }
            } else {
                if (!open) {
                    if (leftConnected && rightConnected && (part == CurtainPart.SINGLE_MIDDLE || part == CurtainPart.SINGLE_BOTTOM)) {
                        newPart = CurtainPart.MIDDLE;
                    }

                    if (part == CurtainPart.SINGLE_TOP) {
                        if (leftConnected && rightConnected) {
                            newPart = CurtainPart.TOP;
                        } else if (leftConnected) {
                            newPart = CurtainPart.RIGHT_SIDE_TOP;
                        } else if (rightConnected) {
                            newPart = CurtainPart.LEFT_SIDE_TOP;
                        }
                    } else if (part == CurtainPart.SINGLE_MIDDLE) {
                        if (leftConnected && !rightConnected) {
                            newPart = CurtainPart.RIGHT_SIDE_MIDDLE;
                        } else if (!leftConnected && rightConnected) {
                            newPart = CurtainPart.LEFT_SIDE_MIDDLE;
                        }
                    } else if (part == CurtainPart.SINGLE_BOTTOM) {
                        if (leftConnected && !rightConnected) {
                            newPart = CurtainPart.RIGHT_SIDE_BOTTOM;
                        } else if (!leftConnected && rightConnected) {
                            newPart = CurtainPart.LEFT_SIDE_BOTTOM;
                        }
                    }

                } else {
                    if (part.isTopOrSingle()) {
                        newPart = CurtainPart.SINGLE_TOP;
                    } else if (part.isMiddle()) {
                        newPart = i + 1 >= length ? CurtainPart.SINGLE_BOTTOM : CurtainPart.SINGLE_MIDDLE;
                    } else if (part.isBottomOrSingle()) {
                        newPart = CurtainPart.SINGLE_BOTTOM;
                    }
                }
            }

            level.setBlockAndUpdate(topPos.below(i), state.setValue(OPEN, !open).setValue(PART, newPart));
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos above = context.getClickedPos().above();
        BlockPos below = context.getClickedPos().below();
        BlockState aboveState = level.getBlockState(above);
        BlockState belowState = level.getBlockState(below);

        Direction facing = context.getHorizontalDirection().getOpposite();


        BlockState state = this.defaultBlockState()
                .setValue(PART, CONNECT_FUNCTION.apply(aboveState, belowState, facing))
                .setValue(FACING, facing);


        this.updateAboveAndBelow(level, state, above, below, facing);

        return state;
    }

    private void updateAboveAndBelow(Level level, BlockState state, BlockPos above, BlockPos below, Direction facing) {
        BlockState aboveState = level.getBlockState(above);
        BlockState belowState = level.getBlockState(below);

        if (aboveState.is(this) && !aboveState.getValue(OPEN)) {
            level.setBlockAndUpdate(above, aboveState.setValue(PART, CONNECT_FUNCTION.apply(level.getBlockState(above.above()), state, facing)));
        }

        if (belowState.is(this) && !belowState.getValue(OPEN)) {
            level.setBlockAndUpdate(below, belowState.setValue(PART, CONNECT_FUNCTION.apply(state, level.getBlockState(below.below()), facing)));
        }
    }

    protected BlockPos getTopBlock(LevelAccessor level, BlockPos currentPos, boolean open) {
        BlockPos.MutableBlockPos pos = currentPos.mutable();
        BlockState state = level.getBlockState(pos.above());

        while (state.is(this) && !state.getValue(PART).isBottomOrSingle() && this.isOpen(state) == open) {
            pos.move(Direction.UP);

            state = level.getBlockState(pos.above());
        }

        return pos.immutable();
    }

    private int getCurtainLength(LevelAccessor level, BlockPos topPos, boolean open) {
        BlockPos.MutableBlockPos pos = topPos.mutable().move(Direction.DOWN);
        BlockState state = level.getBlockState(pos);

        int length = 1;

        while (state.is(this) && !state.getValue(PART).isTopOrSingle() && this.isOpen(state) == open) {
            state = level.getBlockState(pos.move(Direction.DOWN));

            length++;
        }

        return length;
    }

    @Override
    public void onRemove(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock()) && this.isOpen(state) && state.getValue(PART) != CurtainPart.SINGLE) {
            level.setBlockAndUpdate(pos, state);

            this.updateOpen(state, level, pos);

            level.removeBlock(pos, false);
        }

        if (!state.is(newState.getBlock())) {
            this.updateAboveAndBelow(level, newState, pos.above(), pos.below(), state.getValue(FACING));
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    private boolean isOpen(BlockState state) {
        return state.getValue(OPEN);
    }

    private Direction getFacing(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OPEN, PART, FACING);
    }
}
