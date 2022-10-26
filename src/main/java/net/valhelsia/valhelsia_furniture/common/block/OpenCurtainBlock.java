package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ClosedCurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.block.properties.OpenCurtainPart;

import javax.annotation.Nonnull;

/**
 * @author Valhelsia Team
 * @since 2022-05-17
 */
public class OpenCurtainBlock extends AbstractCurtainBlock<OpenCurtainPart> {

    public static EnumProperty<OpenCurtainPart> PART = ModBlockStateProperties.OPEN_CURTAIN_PART;

    public OpenCurtainBlock(DyeColor color, Properties properties) {
        super(color, properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(PART, OpenCurtainPart.SINGLE)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        Direction facing = state.getValue(FACING);
        OpenCurtainPart part = state.getValue(PART);

        if (part == OpenCurtainPart.MIDDLE) {
            return Shapes.empty();
        } else if (part == OpenCurtainPart.TOP) {
            return BRACKET_SHAPES.get(facing);
        }

        return part.isTopOrSingle() ? TOP_SHAPES.get(facing) : SHAPES.get(facing);
    }

    @Nonnull
    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return state.getValue(PART).isTopOrSingle() ? BRACKET_SHAPES.get(state.getValue(FACING)) : Shapes.empty();
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return state.getValue(PART) == OpenCurtainPart.MIDDLE ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(this.getClosedBlock());
    }

    @Override
    protected void updateOpen(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos) {
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
    protected OpenCurtainPart getPart(BlockState state) {
        return state.getValue(PART);
    }

    @Override
    protected void openRow(Level level, BlockPos topPos, int length, boolean leftConnected, boolean rightConnected) {
        ClosedCurtainBlock block = this.getClosedBlock();

        for (int i = 0; i < length; i++) {
            BlockState state = level.getBlockState(topPos.below(i));
            OpenCurtainPart part = state.getValue(PART);

            ClosedCurtainPart newPart = ClosedCurtainPart.SINGLE;

            if (length != 1) {
                if (part.isTopOrSingle()) {
                    newPart = ClosedCurtainPart.TOP;
                } else if (part.isMiddle()) {
                    newPart = i + 1 >= length ? ClosedCurtainPart.BOTTOM : ClosedCurtainPart.MIDDLE;
                } else if (part.isBottomOrSingle()) {
                    newPart = ClosedCurtainPart.BOTTOM;
                }
            }

            level.setBlockAndUpdate(topPos.below(i), block.defaultBlockState().setValue(ClosedCurtainBlock.PART, newPart).setValue(FACING, state.getValue(FACING)));
        }
    }

    @Override
    protected boolean isOpen() {
        return true;
    }

    @Override
    protected OpenCurtainPart connect(BlockState aState, BlockState bState, Direction facing) {
        return OpenCurtainPart.getTypeForConnections(
                aState.getBlock() instanceof OpenCurtainBlock && aState.getValue(FACING) == facing,
                bState.getBlock() instanceof OpenCurtainBlock && bState.getValue(FACING) == facing);
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
    public void onRemove(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (!(newState.getBlock() instanceof AbstractCurtainBlock) && state.getValue(PART) != OpenCurtainPart.SINGLE) {
            level.setBlockAndUpdate(pos, state);

            this.updateOpen(state, level, pos);

            level.removeBlock(pos, false);
        }


        if (!(newState.getBlock() instanceof AbstractCurtainBlock)) {
            this.updateAboveAndBelow(level, newState, pos.above(), pos.below(), state.getValue(FACING));
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, FACING);
    }
}
