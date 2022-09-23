package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Table Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.TableBlock
 *
 * @author Valhelsia Team
 * @version 1.19 - 0.1.0
 * @since 2022-01-02
 */
public class TableBlock extends Block implements SimpleWaterloggedBlock {

    private static final int MAX_LENGTH = 5;

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final BooleanProperty ROTATED = ModBlockStateProperties.ROTATED;

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final EnumMap<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = Util.make(new EnumMap<>(Direction.class), (map) -> {
        map.put(Direction.NORTH, NORTH);
        map.put(Direction.EAST, EAST);
        map.put(Direction.SOUTH, SOUTH);
        map.put(Direction.WEST, WEST);
    });

    private static final VoxelShape TOP_SHAPE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    private static final Map<Direction, VoxelShape> TWO_LEGS_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            TOP_SHAPE,
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D)
    ));

    private static final Map<Direction, VoxelShape> ONE_LEG_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            TOP_SHAPE,
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D)
    ));

    private static final VoxelShape SHAPE = Shapes.or(TOP_SHAPE,
            Block.box(1.0D, 0.0D, 1.0D, 4.0D, 12.0D, 4.0D),
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D),
            Block.box(12.0D, 0.0D, 1.0D, 15.0D, 12.0D, 4.0D)
    );

    private final String baseName;
    @Nullable
    private final DyeColor color;

    public TableBlock(String baseName, Properties properties) {
        this(baseName, null, properties);
    }

    public TableBlock(String baseName, @Nullable DyeColor color, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(ROTATED, false)
                .setValue(WATERLOGGED, false)
        );
        this.baseName = baseName;
        this.color = color;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        List<Direction> connectedDirections = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                continue;
            }

            if (state.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                connectedDirections.add(direction);
            }
        }

        if (connectedDirections.size() >= 3 || (connectedDirections.size() == 2 && connectedDirections.get(0) == connectedDirections.get(1).getOpposite())) {
            return TOP_SHAPE;
        } else if (connectedDirections.size() == 1) {
            return TWO_LEGS_SHAPES.get(connectedDirections.get(0));
        } else if (connectedDirections.size() == 2) {
            boolean flag = connectedDirections.get(0).getClockWise() == connectedDirections.get(1);

            return flag ? ONE_LEG_SHAPES.get(connectedDirections.get(0)) : ONE_LEG_SHAPES.get(connectedDirections.get(1));
        }

        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        boolean rotated = context.getHorizontalDirection().getAxis() == Direction.Axis.X;

        return this.defaultBlockState().setValue(ROTATED, rotated).setValue(WATERLOGGED, flag);
    }

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction.getAxis() == Direction.Axis.Y) {
            return state;
        }

        BooleanProperty property = PROPERTY_BY_DIRECTION.get(direction);
        BooleanProperty oppositeProperty = PROPERTY_BY_DIRECTION.get(direction.getOpposite());

        if (neighborState.getBlock() instanceof TableBlock) {
            if (neighborState.getValue(oppositeProperty) && !state.getValue(property)) {
                return state.setValue(property, true);
            } else if (!neighborState.getValue(oppositeProperty) && state.getValue(property)) {

                return state.setValue(property, false);
            }
        } else if (state.getValue(property)) {
            return state.setValue(property, false);
        }

        if (this.isValidTable(neighborState) && !state.getValue(property)) {
            this.tryConnect(direction, currentPos, level);
        }

        return state;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        for (Direction direction : Direction.values()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                continue;
            }

            if (state.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                this.trySplit(direction, pos, level);
                break;
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private void tryConnect(Direction direction, BlockPos pos, LevelAccessor level) {
        List<BlockPos> list = new ArrayList<>();
        int i = 0;

        int tableLength = 1;

        // Get table length
        while (tableLength < MAX_LENGTH) {
            BlockState state = level.getBlockState(pos.relative(direction.getOpposite(), tableLength));

            if (state.getBlock() instanceof TableBlock && state.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                tableLength++;
            } else {
                break;
            }
        }

        int otherTableLength = 1;

        // Get other table length
        for (int j = 2; j < MAX_LENGTH; j++) {
            BlockState state = level.getBlockState(pos.relative(direction, j));

            if (state.getBlock() instanceof TableBlock && state.getValue(PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) {
                otherTableLength++;
            } else {
                break;
            }
        }

        if (tableLength + otherTableLength > 5) {
            return;
        }

        boolean flag = false;

        BlockPos offsetPos = pos.relative(direction);

        if (this.isSameRotation(level.getBlockState(pos), level.getBlockState(offsetPos))) {
            list.add(offsetPos);
        } else {
            return;
        }

        if (level.getBlockState(offsetPos).getBlock() instanceof TableBlock) {
            flag = level.getBlockState(offsetPos).getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise()));
        }

        for (int j = 1; j < MAX_LENGTH; j++) {
            BlockPos.MutableBlockPos mutable = pos.mutable().move(direction.getClockWise(), j);
            BlockState state = level.getBlockState(mutable);
            BlockState offsetState = level.getBlockState(mutable.move(direction));

            if (!this.isValidTable(state) || (this.isValidTable(state) && !state.getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise())) || !this.isSameRotation(level.getBlockState(pos), state))) {
                if (this.isValidTable(offsetState) && flag) {
                    return;
                }

                break;
            }

            if (!this.isValidTable(offsetState) || (this.isValidTable(offsetState) && !offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise())) || !this.isSameRotation(level.getBlockState(pos), offsetState))) {
                return;
            }

            if (this.isValidTable(offsetState)) {
                flag = offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise()));
            } else {
                flag = false;
            }

            list.add(mutable);
            i++;
        }

        if (level.getBlockState(offsetPos).getBlock() instanceof TableBlock) {
            flag = level.getBlockState(offsetPos).getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise()));
        } else {
            flag = false;
        }

        for (int j = 1; j < MAX_LENGTH; j++) {
            BlockPos.MutableBlockPos mutable = pos.mutable().move(direction.getCounterClockWise(), j);
            BlockState state = level.getBlockState(mutable);
            BlockState offsetState = level.getBlockState(mutable.move(direction));

            if (!this.isValidTable(state) || (this.isValidTable(state) && !state.getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise()))) || !this.isSameRotation(level.getBlockState(pos), state)) {
                if (this.isValidTable(offsetState) && flag) {
                    return;
                }
                break;
            }

            if (!this.isValidTable(offsetState) || this.isValidTable(offsetState) && !offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise())) || !this.isSameRotation(level.getBlockState(pos), offsetState)) {
                return;
            }

            if (this.isValidTable(offsetState)) {
                flag = offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise()));
            } else {
                flag = false;
            }

            list.add(mutable);
            i++;
        }

        if (i >= MAX_LENGTH) {
            return;
        }

        list.forEach(tablePos -> {
            level.setBlock(tablePos, level.getBlockState(tablePos).setValue(PROPERTY_BY_DIRECTION.get(direction.getOpposite()), true), 3);
        });
    }

    private void trySplit(Direction direction, BlockPos pos, LevelAccessor level) {
        List<BlockPos> list = new ArrayList<>();

        for (int j = 1; j < MAX_LENGTH; j++) {
            BlockPos.MutableBlockPos mutable = pos.mutable().move(direction.getClockWise(), j);
            BlockState offsetState = level.getBlockState(mutable);

            if (this.isValidTable(offsetState) && offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise()))) {
                if (offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                    list.add(mutable.immutable());
                }
            } else {
                break;
            }
        }

        for (int j = 1; j < MAX_LENGTH; j++) {
            BlockPos.MutableBlockPos mutable = pos.mutable().move(direction.getCounterClockWise(), j);
            BlockState offsetState = level.getBlockState(mutable);

            if (this.isValidTable(offsetState) && offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise()))) {
                if (offsetState.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                    list.add(mutable.immutable());
                }
            } else {
                break;
            }
        }

        list.forEach(tablePos -> {
            BlockState state = level.getBlockState(tablePos);
            boolean rotated = state.getValue(ROTATED);

            level.setBlock(tablePos, Blocks.AIR.defaultBlockState(), 3);

            level.setBlock(tablePos, state.getBlock().defaultBlockState().setValue(ROTATED, rotated), 3);
        });
    }

    public boolean isValidTable(BlockState state) {
        return state.getBlock() instanceof TableBlock table && table.getBaseName().equals(this.getBaseName());
    }

    public boolean isSameRotation(BlockState state1, BlockState state2) {
        if (!this.isValidTable(state1) || !this.isValidTable(state2)) {
            return false;
        }
        return state1.getValue(ROTATED) == state2.getValue(ROTATED);
    }

    @Nonnull
    @Override
    public String getDescriptionId() {
        return "block.valhelsia_furniture." + this.baseName;
    }

    public String getBaseName() {
        return this.baseName;
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable BlockGetter level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        if (this.color != null) {
            tooltip.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_tablecloth").withStyle(ChatFormatting.GRAY));
        }
    }

    @Nonnull
    @Override
    public BlockState rotate(@Nonnull BlockState state, @Nonnull Rotation rotation) {
        List<Direction> directions = new ArrayList<>();

        for (Map.Entry<Direction, BooleanProperty> entry : PROPERTY_BY_DIRECTION.entrySet()) {
            if (state.getValue(entry.getValue())) {
                directions.add(rotation.rotate(entry.getKey()));
            }

            state = state.setValue(entry.getValue(), false);
        }

        for (Direction direction : directions) {
            state = state.setValue(PROPERTY_BY_DIRECTION.get(direction), true);
        }
        return state;
    }

    @Nonnull
    @Override
    public BlockState mirror(@Nonnull BlockState state, @Nonnull Mirror mirror) {
        List<Direction> directions = new ArrayList<>();

        for (Map.Entry<Direction, BooleanProperty> entry : PROPERTY_BY_DIRECTION.entrySet()) {
            if (state.getValue(entry.getValue())) {
                directions.add(mirror.mirror(entry.getKey()));
            }

            state = state.setValue(entry.getValue(), false);
        }

        for (Direction direction : directions) {
            state = state.setValue(PROPERTY_BY_DIRECTION.get(direction), true);
        }
        return state;
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, ROTATED, WATERLOGGED);
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
