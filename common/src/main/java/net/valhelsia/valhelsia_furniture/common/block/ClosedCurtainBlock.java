package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ClosedCurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.block.properties.OpenCurtainPart;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public class ClosedCurtainBlock extends AbstractCurtainBlock<ClosedCurtainPart> {

    public static EnumProperty<ClosedCurtainPart> PART = ModBlockStateProperties.CLOSED_CURTAIN_PART;

    public ClosedCurtainBlock(DyeColor color, Properties properties) {
        super(color, properties);

        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(PART, ClosedCurtainPart.SINGLE)
                .setValue(POWERED, false)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void updateOpen(BlockState state, Level level, BlockPos pos) {
        Direction base = state.getValue(FACING);
        Direction left = base.getClockWise();
        Direction right = base.getCounterClockWise();

        BlockPos topPos = this.getTopBlock(level, pos);
        int length = this.getCurtainLength(level, topPos);

        boolean leftConnected = this.isConnected(level, state, topPos, left, length);
        boolean rightConnected = this.isConnected(level, state, topPos, right, length);

        this.openRow(level, topPos, length, leftConnected, rightConnected);

        if (leftConnected) {
            this.openRows(level, state, topPos.mutable(), left, base, length);
        }

        if (rightConnected) {
            this.openRows(level, state, topPos.mutable(), right, base, length);
        }
    }

    @Override
    protected ClosedCurtainPart getPart(BlockState state) {
        return state.getValue(PART);
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction facing = state.getValue(FACING);
        ClosedCurtainPart part = state.getValue(PART);

        return part == ClosedCurtainPart.SINGLE || part == ClosedCurtainPart.TOP ? TOP_SHAPES.get(facing) : SHAPES.get(facing);
    }

    @NotNull
    @Override
    public VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        ClosedCurtainPart part = state.getValue(PART);

        return part == ClosedCurtainPart.SINGLE || part == ClosedCurtainPart.TOP ? BRACKET_SHAPES.get(state.getValue(FACING)) : Shapes.empty();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockPos above = pos.above();
        BlockPos below = pos.below();
        BlockState aboveState = level.getBlockState(above);
        BlockState belowState = level.getBlockState(below);

        Direction facing = context.getHorizontalDirection().getOpposite();
        boolean powered = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());

        BlockState state = powered ? this.getOpenBlock().defaultBlockState().setValue(POWERED, true) : this.defaultBlockState();

        state = state.setValue(PART, this.connect(aboveState, belowState, facing)).setValue(FACING, facing);

        if (!powered) {
            this.updateAboveAndBelow(level, state, above, below, facing);
        }

        return state;
    }

    @Override
    protected void openRow(Level level, BlockPos topPos, int length, boolean leftConnected, boolean rightConnected) {
        OpenCurtainBlock block = this.getOpenBlock();

        for (int i = 0; i < length; i++) {
            BlockState state = level.getBlockState(topPos.below(i));
            ClosedCurtainPart part = state.getValue(PART);

            OpenCurtainPart newPart = OpenCurtainPart.SINGLE;

            if (length == 1) {
                if (leftConnected && rightConnected) {
                    newPart =  OpenCurtainPart.TOP;
                }

                if (leftConnected && !rightConnected) {
                    newPart = OpenCurtainPart.RIGHT;
                }

                if (rightConnected && !leftConnected) {
                    newPart = OpenCurtainPart.LEFT;
                }
            } else {
                if (leftConnected && rightConnected && (part == ClosedCurtainPart.MIDDLE || part == ClosedCurtainPart.BOTTOM)) {
                    newPart = OpenCurtainPart.MIDDLE;
                }

                if (part == ClosedCurtainPart.TOP) {
                    if (leftConnected && rightConnected) {
                        newPart = OpenCurtainPart.TOP;
                    } else if (leftConnected) {
                        newPart = OpenCurtainPart.RIGHT_SIDE_TOP;
                    } else if (rightConnected) {
                        newPart = OpenCurtainPart.LEFT_SIDE_TOP;
                    } else {
                        newPart = OpenCurtainPart.SINGLE_TOP;
                    }
                } else if (part == ClosedCurtainPart.MIDDLE) {
                       if (leftConnected && !rightConnected) {
                           newPart = OpenCurtainPart.RIGHT_SIDE_MIDDLE;
                       } else if (!leftConnected && rightConnected) {
                           newPart = OpenCurtainPart.LEFT_SIDE_MIDDLE;
                       } else if (!leftConnected){
                           newPart = OpenCurtainPart.SINGLE_MIDDLE;
                       }
                } else if (part == ClosedCurtainPart.BOTTOM) {
                    if (leftConnected && !rightConnected) {
                        newPart = OpenCurtainPart.RIGHT_SIDE_BOTTOM;
                    } else if (!leftConnected && rightConnected) {
                        newPart = OpenCurtainPart.LEFT_SIDE_BOTTOM;
                    } else if (!leftConnected) {
                        newPart = OpenCurtainPart.SINGLE_BOTTOM;
                    }
                }
            }

            level.setBlockAndUpdate(topPos.below(i), block.defaultBlockState().setValue(OpenCurtainBlock.PART, newPart).setValue(FACING, state.getValue(FACING)).setValue(POWERED, state.getValue(POWERED)));
        }
    }

    @Override
    protected boolean isOpen() {
        return false;
    }

    @Override
    protected ClosedCurtainPart connect(BlockState aState, BlockState bState, Direction facing) {
        return ClosedCurtainPart.getTypeForConnections(
                aState.getBlock() instanceof ClosedCurtainBlock && aState.getValue(FACING) == facing,
                bState.getBlock() instanceof ClosedCurtainBlock && bState.getValue(FACING) == facing);
    }

    public OpenCurtainBlock getOpenBlock() {
        return ModBlocks.OPEN_CURTAINS.get(this.getColor()).get();
    }

    private void updateAboveAndBelow(Level level, BlockState state, BlockPos above, BlockPos below, Direction facing) {
        BlockState aboveState = level.getBlockState(above);
        BlockState belowState = level.getBlockState(below);

        if (aboveState.is(this)) {
            level.setBlockAndUpdate(above, aboveState.setValue(PART, this.connect(level.getBlockState(above.above()), state, facing)));
        }

        if (belowState.is(this)) {
            level.setBlockAndUpdate(below, belowState.setValue(PART, this.connect(state, level.getBlockState(below.below()), facing)));
        }
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!(newState.getBlock() instanceof AbstractCurtainBlock)) {
            this.updateAboveAndBelow(level, newState, pos.above(), pos.below(), state.getValue(FACING));
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, POWERED, FACING);
    }
}
