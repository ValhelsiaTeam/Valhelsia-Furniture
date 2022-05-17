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
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Fabric Desk Lamp Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.FabricDeskLampBlock
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-15
 */
public class FabricDeskLampBlock extends Block implements SimpleWaterloggedBlock {

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D),
            Block.box(7.0D, 3.0D, 7.0D, 9.0D, 7.0D, 9.0D),
            Block.box(4.0D, 7.0D, 4.0D, 12.0D, 14.0D, 12.0D)
    );

    public static final BooleanProperty SWITCHED_ON = ModBlockStateProperties.SWITCHED_ON;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public FabricDeskLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(SWITCHED_ON, false)
                .setValue(WATERLOGGED, false));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return this.defaultBlockState().setValue(WATERLOGGED, flag);
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        level.setBlockAndUpdate(pos, state.setValue(SWITCHED_ON, !state.getValue(SWITCHED_ON)));

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SWITCHED_ON, WATERLOGGED);
    }

    @Nonnull
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
