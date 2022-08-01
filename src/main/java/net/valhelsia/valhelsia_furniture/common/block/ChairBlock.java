package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Chair Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.ChairBlock
 *
 * @author Valhelsia Team
 * @version 1.19 - 0.1.0
 * @since 2022-01-07
 */
public class ChairBlock extends Block implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            Block.box(2.0D, 0.0D, 2.0D, 5.0D, 7.0D, 5.0D),
            Block.box(11.0D, 0.0D, 2.0D, 14.0D, 7.0D, 5.0D),
            Block.box(2.0D, 0.0D, 12.0D, 14.0D, 20.0D, 15.0D),
            Block.box(2.0D, 6.0D, 1.0D, 14.0D, 9.0D, 12.0D)
    ));

    private final String baseName;
    @Nullable
    private final DyeColor color;

    public ChairBlock(String baseName, Properties properties) {
        this(baseName, null, properties);
    }

    public ChairBlock(String baseName, @Nullable DyeColor color, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
        this.baseName = baseName;
        this.color = color;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, flag);
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
        return "block.valhelsia_furniture." + this.baseName + "_chair";
    }

    public String getBaseName() {
        return this.baseName;
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
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

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable BlockGetter level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        if (this.color != null) {
            tooltip.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_wool_seat").withStyle(ChatFormatting.GRAY));
        } else if (!Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(this)).getPath().equals(this.baseName + "_chair")) {
            tooltip.add(Component.translatable("tooltip.valhelsia_furniture.hay_seat").withStyle(ChatFormatting.GRAY));
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

    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
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
}
