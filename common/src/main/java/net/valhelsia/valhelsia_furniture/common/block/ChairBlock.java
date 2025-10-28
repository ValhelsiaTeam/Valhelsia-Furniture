package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.api.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Chair Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.ChairBlock
 *
 * @author Valhelsia Team
 * @since 2022-01-07
 */
public class ChairBlock extends Block implements SimpleWaterloggedBlock, SeatableBlock {

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            Block.box(2.0D, 0.0D, 2.0D, 5.0D, 7.0D, 5.0D),
            Block.box(11.0D, 0.0D, 2.0D, 14.0D, 7.0D, 5.0D),
            Block.box(2.0D, 0.0D, 12.0D, 14.0D, 20.0D, 15.0D),
            Block.box(2.0D, 6.0D, 1.0D, 14.0D, 9.0D, 12.0D)
    ));

    private final WoodType woodType;
    @Nullable
    private final DyeColor color;

    public ChairBlock(WoodType woodType, Properties properties) {
        this(woodType, null, properties);
    }

    public ChairBlock(WoodType woodType, @Nullable DyeColor color, Properties properties) {
        this(woodType, color, properties, Util.makeDescriptionId("block", ValhelsiaFurniture.location(woodType.name() + "_chair")));
    }

    public ChairBlock(WoodType woodType, @Nullable DyeColor color, Properties properties, String descriptionId) {
        super(properties.overrideDescription(descriptionId));
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
        this.woodType = woodType;
        this.color = color;
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, flag);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource randomSource) {
        if (state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, tickAccess, pos, direction, neighborPos, neighborState, randomSource);
    }

    public WoodType getWoodType() {
        return this.woodType;
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @NotNull
    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide() && !player.isShiftKeyDown()) {
            this.sitOnBlock(level, pos, player);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean intersects) {
        this.trySitEntityOnBlock(level, pos, entity);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean isMoving) {
        if (level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above())) {
            if (this.isSeatOccupied(level, pos)) {
                level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).getFirst().discard();

                level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
            }
        }
    }

    //TODO
//    @Override
//    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
//        if (this.color != null) {
//            list.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_wool_seat").withStyle(ChatFormatting.GRAY));
//        } else if (!Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(this)).getPath().equals(this.woodType.name() + "_chair")) {
//            list.add(Component.translatable("tooltip.valhelsia_furniture.hay_seat").withStyle(ChatFormatting.GRAY));
//        }
//    }

    @Override
    public boolean hasAnalogOutputSignal(@NotNull BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return this.isSeatOccupied(level, pos) ? 15 : 0;
    }

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

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
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
        return SeatEntity.EjectType.BLOCK_HORIZONTAL_FACING;
    }
}
