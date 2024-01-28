package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Stool Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.StoolBlock
 *
 * @author Valhelsia Team
 * @since 2022-02-05
 */
public class StoolBlock extends Block implements SimpleWaterloggedBlock, SeatableBlock {

    public static final BooleanProperty ROTATED = ModBlockStateProperties.ROTATED;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D),
            Block.box(3.0D, 7.0D, 3.0D, 13.0D, 9.0D, 13.0D)
    );

    private static final VoxelShape UPHOLSTERED_SHAPE = Shapes.or(
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D),
            Block.box(3.0D, 7.0D, 3.0D, 13.0D, 10.0D, 13.0D)
    );

    private final WoodType woodType;
    @Nullable
    private final DyeColor color;

    public StoolBlock(WoodType woodType, Properties properties) {
        this(woodType, null, properties);
    }

    public StoolBlock(WoodType woodType, @Nullable DyeColor color, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROTATED, false).setValue(WATERLOGGED, false));
        this.woodType = woodType;
        this.color = color;
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getColor() != null? UPHOLSTERED_SHAPE : SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(ROTATED, (Mth.floor((double) ((180.0F + context.getRotation()) * 8.0F / 360.0F) + 0.5D) & 7) % 2 != 0);
    }

    @NotNull
    @Override
    public BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @NotNull
    @Override
    public String getDescriptionId() {
        return "block.valhelsia_furniture." + this.woodType.name() + "_stool";
    }

    public WoodType getWoodType() {
        return this.woodType;
    }

    @NotNull
    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide() && !player.isShiftKeyDown()) {
            this.sitOnBlock(level, pos, player);
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        this.trySitEntityOnBlock(level, pos, entity);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
       if (level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above())) {
           if (this.isSeatOccupied(level, pos)) {
               level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).get(0).discard();

               level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
           }
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(@NotNull BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        return this.isSeatOccupied(level, pos) ? 15 : 0;
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (this.color != null) {
            tooltip.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_wool_seat").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, ROTATED);
    }

    @NotNull
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }

    @Override
    public SeatEntity.EjectType getEjectType() {
        return SeatEntity.EjectType.ENTITY_HEAD_ROTATION;
    }
}
