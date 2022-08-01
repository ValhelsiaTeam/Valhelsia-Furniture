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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Curtain Block <br>
 * Valhelsia Core - net.valhelsia.valhelsia_furniture.common.block.CurtainBlock
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-17
 */
public class CurtainBlock extends Block {

    public static BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static EnumProperty<CurtainPart> PART = ModBlockStateProperties.CURTAIN_PART;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D));

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
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        if (state.getValue(PART) == CurtainPart.SINGLE || state.getValue(PART) == CurtainPart.SINGLE_TOP) {
            level.setBlockAndUpdate(pos, state.setValue(OPEN, !state.getValue(OPEN)));
        } else {
            BlockState above = level.getBlockState(pos.above());
            level.setBlockAndUpdate(pos.above(), above.setValue(OPEN, !above.getValue(OPEN)));
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        BlockState above = context.getLevel().getBlockState(context.getClickedPos().above());

        CurtainPart part = above.is(this) && above.getValue(PART) == CurtainPart.SINGLE ? CurtainPart.SINGLE_BOTTOM : CurtainPart.SINGLE;

        return this.defaultBlockState()
                .setValue(PART, part)
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
        if (direction.getAxis() != Direction.Axis.Y) {
            return state;
        }

        if (direction == Direction.DOWN) {
            if (state.getValue(PART) == CurtainPart.SINGLE_TOP && !neighborState.is(this)) {
                return state.setValue(PART, CurtainPart.SINGLE);
            }

            if (neighborState.is(this) && neighborState.getValue(PART) == CurtainPart.SINGLE_BOTTOM) {
                return state.setValue(PART, CurtainPart.SINGLE_TOP);
            }
        }

        if (direction == Direction.UP && neighborState.is(this)) {
            if (neighborState.getValue(OPEN) != state.getValue(OPEN)) {
                state = state.setValue(OPEN, neighborState.getValue(OPEN));
            }
            if (state.getValue(PART) == CurtainPart.SINGLE) {
                return state.setValue(PART, CurtainPart.SINGLE_BOTTOM);
            }
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OPEN, PART, FACING);
    }
}
