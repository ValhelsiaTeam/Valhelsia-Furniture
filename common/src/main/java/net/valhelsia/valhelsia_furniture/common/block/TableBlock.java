package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-01-02
 */
public class TableBlock extends Block implements SimpleWaterloggedBlock, FurnitureBlock {

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final BooleanProperty ROTATED = ModBlockStateProperties.ROTATED;

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final EnumMap<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH, NORTH);
        map.put(Direction.EAST, EAST);
        map.put(Direction.SOUTH, SOUTH);
        map.put(Direction.WEST, WEST);
    });

    private static final VoxelShape TOP_SHAPE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    private static final Map<Direction, VoxelShape> TWO_LEGS_SHAPES = Shapes.rotateHorizontal(Shapes.or(
            TOP_SHAPE,
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D)
    ));

    private static final Map<Direction, VoxelShape> ONE_LEG_SHAPES = Shapes.rotateHorizontal(Shapes.or(
            TOP_SHAPE,
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D)
    ));

    private static final VoxelShape SHAPE = Shapes.or(TOP_SHAPE,
            Block.box(1.0D, 0.0D, 1.0D, 4.0D, 12.0D, 4.0D),
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D),
            Block.box(12.0D, 0.0D, 1.0D, 15.0D, 12.0D, 4.0D)
    );

    private final WoodType woodType;

    public TableBlock(WoodType woodType, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(ROTATED, false)
                .setValue(WATERLOGGED, false)
        );
        this.woodType = woodType;
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        List<Direction> connectedDirections = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                continue;
            }

            if (state.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                connectedDirections.add(direction);
            }
        }

        if (connectedDirections.size() >= 3 || (connectedDirections.size() == 2 && connectedDirections.getFirst() == connectedDirections.get(1).getOpposite())) {
            return TOP_SHAPE;
        } else if (connectedDirections.size() == 1) {
            return TWO_LEGS_SHAPES.get(connectedDirections.getFirst());
        } else if (connectedDirections.size() == 2) {
            boolean flag = connectedDirections.getFirst().getClockWise() == connectedDirections.get(1);

            return flag ? ONE_LEG_SHAPES.get(connectedDirections.getFirst()) : ONE_LEG_SHAPES.get(connectedDirections.get(1));
        }

        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        boolean waterlogged = level.getFluidState(pos).getType() == Fluids.WATER;
        boolean rotated = context.getHorizontalDirection().getAxis() == Direction.Axis.X;

        BlockState state = this.defaultBlockState()
                .setValue(ROTATED, rotated)
                .setValue(WATERLOGGED, waterlogged);

        level.scheduleTick(pos, this, 1);

        return state;
    }

    private int getTableLength(Level level, BlockPos pos, Direction direction) {
        return this.getTableLengthInDirection(level, pos, direction) + this.getTableLengthInDirection(level, pos, direction.getOpposite());
    }

    private int getTableLengthInDirection(Level level, BlockPos pos, Direction direction) {
        int i = 1;
        while (true) {
            BlockState state = level.getBlockState(pos.relative(direction, i));

            if (state.getBlock() instanceof TableBlock && state.getValue(PROPERTY_BY_DIRECTION.get(direction.getOpposite()))) {
                i++;
            } else {
                break;
            }
        }

        return i;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        List<Direction> directions = Direction.Plane.HORIZONTAL.stream()
                .filter(direction -> !state.getValue(PROPERTY_BY_DIRECTION.get(direction)))
                .toList();

        for (Direction direction : directions) {
            BlockPos offsetPos = pos.relative(direction);
            BlockState offsetState = level.getBlockState(offsetPos);

            if (offsetState.getBlock() instanceof TableBlock) {
                int tableLengthCurrent = this.getTableLength(level, pos, direction.getClockWise());
                int tableLengthNeighbor = this.getTableLength(level, offsetPos, direction.getClockWise());

                if (tableLengthCurrent == tableLengthNeighbor) {
                    level.setBlockAndUpdate(pos, state.setValue(PROPERTY_BY_DIRECTION.get(direction), true));

                    level.scheduleTick(pos, this, 1);
                    break;
                }
            }
        }
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource randomSource) {
        if (state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction.getAxis() == Direction.Axis.Y) {
            return state;
        }

        BooleanProperty property = PROPERTY_BY_DIRECTION.get(direction);
        BooleanProperty oppositeProperty = PROPERTY_BY_DIRECTION.get(direction.getOpposite());

        boolean isAlreadyConnected = state.getValue(property);
        boolean isNeighborTable = neighborState.getBlock() instanceof TableBlock;
        boolean isNeighborConnected = isNeighborTable && neighborState.getValue(oppositeProperty);

        state = state.setValue(property, isNeighborConnected);

        if (isAlreadyConnected && isNeighborConnected) {
            state = state
                    .setValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise()), neighborState.getValue(PROPERTY_BY_DIRECTION.get(direction.getClockWise())))
                    .setValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise()), neighborState.getValue(PROPERTY_BY_DIRECTION.get(direction.getCounterClockWise())));
        }
        return state;
    }

    public WoodType getWoodType() {
        return this.woodType;
    }

    @NotNull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
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

    @NotNull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
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
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, ROTATED, WATERLOGGED);
    }

    @NotNull
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public Type getType() {
        return Type.TABLE;
    }
}
