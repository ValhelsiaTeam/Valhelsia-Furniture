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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Stool Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.StoolBlock
 *
 * @author Valhelsia Team
 * @version 1.19 - 0.1.0
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

    private final String baseName;
    @Nullable
    private final DyeColor color;

    public StoolBlock(String baseName, Properties properties) {
        this(baseName, null, properties);
    }

    public StoolBlock(String baseName, @Nullable DyeColor color, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROTATED, false).setValue(WATERLOGGED, false));
        this.baseName = baseName;
        this.color = color;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return this.getColor() != null? UPHOLSTERED_SHAPE : SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(ROTATED, (Mth.floor((double) ((180.0F + context.getRotation()) * 8.0F / 360.0F) + 0.5D) & 7) % 2 != 0);
    }

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Nonnull
    @Override
    public String getDescriptionId() {
        return "block.valhelsia_furniture." + this.baseName + "_stool";
    }

    public String getBaseName() {
        return this.baseName;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        if (!level.isClientSide() && !player.isShiftKeyDown()) {
            this.sitDown(level, pos, player);
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        if (!(entity instanceof Player)) {
            this.sitDown(level, pos, entity);
        }
    }

    private void sitDown(Level level, BlockPos pos, Entity entity) {
        if (!this.isEntitySitting(level, pos)) {
            SeatEntity chair = new SeatEntity(pos, 0.3D, level);

            level.addFreshEntity(chair);
            entity.startRiding(chair);

            level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
        }
    }

    @Override
    public void neighborChanged(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull Block block, @Nonnull BlockPos fromPos, boolean isMoving) {
       if (level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above())) {
           if (this.isEntitySitting(level, pos)) {
               level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).get(0).discard();

               level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
           }
        }
    }

    private boolean isEntitySitting(Level level, BlockPos pos) {
        return !level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).isEmpty();
    }

    @Override
    public boolean hasAnalogOutputSignal(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos) {
        return this.isEntitySitting(level, pos) ? 15 : 0;
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable BlockGetter level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        if (this.color != null) {
            tooltip.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_wool_seat").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, ROTATED);
    }

    @Nonnull
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean useShapeForLightOcclusion(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public SeatEntity.EjectType getEjectType() {
        return SeatEntity.EjectType.ENTITY_HEAD_ROTATION;
    }
}
