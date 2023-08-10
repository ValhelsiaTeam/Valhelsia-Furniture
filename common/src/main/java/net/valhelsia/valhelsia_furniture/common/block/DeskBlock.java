package net.valhelsia.valhelsia_furniture.common.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.api.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.datagen.models.ModTextureSlots;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-05-13
 */
public class DeskBlock extends Block implements SimpleWaterloggedBlock {

    private static final String TEXTURE_PATH = "block/desk/";

    public static final Map<String, List<TextureSlot>> VARIANT_TEXTURES = ImmutableMap.<String, List<TextureSlot>>builder()
            .put("single", ImmutableList.of(
                    ModTextureSlots.TOP,
                    ModTextureSlots.TOP_MIDDLE,
                    ModTextureSlots.FRONT,
                    ModTextureSlots.SIDE
            ))
            .put("center", ImmutableList.of(
                    ModTextureSlots.TOP_SIDE,
                    ModTextureSlots.TOP_MIDDLE,
                    ModTextureSlots.FRONT,
                    ModTextureSlots.SIDE,
                    ModTextureSlots.MIDDLE
            ))
            .put("left_or_right", ImmutableList.of(
                    ModTextureSlots.TOP,
                    ModTextureSlots.TOP_SIDE,
                    ModTextureSlots.TOP_MIDDLE,
                    ModTextureSlots.FRONT,
                    ModTextureSlots.SIDE,
                    ModTextureSlots.MIDDLE
            ))
            .build();

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LEFT = ModBlockStateProperties.LEFT;
    public static final BooleanProperty RIGHT = ModBlockStateProperties.RIGHT;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final Map<BlockState, VoxelShape> shapesCache;

    private static final VoxelShape TOP_SHAPE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    private static final Map<Direction, VoxelShape> TWO_LEGS_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            TOP_SHAPE,
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D)
    ));

    protected static final VoxelShape SHAPE = Shapes.or(TOP_SHAPE,
            Block.box(1.0D, 0.0D, 1.0D, 4.0D, 12.0D, 4.0D),
            Block.box(12.0D, 0.0D, 12.0D, 15.0D, 12.0D, 15.0D),
            Block.box(1.0D, 0.0D, 12.0D, 4.0D, 12.0D, 15.0D),
            Block.box(12.0D, 0.0D, 1.0D, 15.0D, 12.0D, 4.0D)
    );

    private static final Map<Direction, VoxelShape> CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(4.0D, 4.0D, 1.0D, 12.0D, 12.0D, 4.0D));
    private static final Map<Direction, VoxelShape> FULL_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 4.0D, 1.0D, 16.0D, 12.0D, 4.0D));
    private static final Map<Direction, VoxelShape> LEFT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 4.0D, 1.0D, 12.0D, 12.0D, 4.0D));
    private static final Map<Direction, VoxelShape> RIGHT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(4.0D, 4.0D, 1.0D, 16.0D, 12.0D, 4.0D));

    private final WoodType woodType;
    private final TagKey<Block> tag;

    public DeskBlock(WoodType woodType, TagKey<Block> tag, Properties properties) {
        super(properties);
        this.woodType = woodType;
        this.tag = tag;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LEFT, false)
                .setValue(RIGHT, false)
                .setValue(WATERLOGGED, false));
        this.shapesCache = this.getShapeForEachState(this::calculateShape);
    }

    private VoxelShape calculateShape(BlockState state) {
        Direction facing = state.getValue(FACING);
        boolean left = state.getValue(LEFT);
        boolean right = state.getValue(RIGHT);

        if (left && right) {
            return Shapes.or(TOP_SHAPE, FULL_CONNECT_SHAPES.get(facing.getOpposite()));
        } else if (left) {
            return Shapes.or(TWO_LEGS_SHAPES.get(facing.getClockWise()), LEFT_CONNECT_SHAPES.get(facing.getOpposite()), CONNECT_SHAPES.get(facing.getClockWise().getOpposite()));
        } else if (right) {
            return Shapes.or(TWO_LEGS_SHAPES.get(facing.getClockWise().getOpposite()), RIGHT_CONNECT_SHAPES.get(facing.getOpposite()), CONNECT_SHAPES.get(facing.getClockWise()));
        }

        return Shapes.or(SHAPE, CONNECT_SHAPES.get(facing.getOpposite()), CONNECT_SHAPES.get(facing.getClockWise().getOpposite()), CONNECT_SHAPES.get(facing.getClockWise()));
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getHorizontalDirection().getOpposite();

        boolean flag = level.getFluidState(pos).getType() == Fluids.WATER;

        BlockState leftState = level.getBlockState(pos.relative(facing.getClockWise()));
        BlockState secondLefState = level.getBlockState(pos.relative(facing.getClockWise(), 2));

        BlockState rightState = level.getBlockState(pos.relative(facing.getCounterClockWise()));
        BlockState secondRightState = level.getBlockState(pos.relative(facing.getCounterClockWise(), 2));

        boolean left = this.hasSameFacing(leftState, facing) && (!secondLefState.is(this.tag) || secondLefState.getValue(FACING) != facing || !this.isCenterPart(secondLefState));
        boolean right = this.hasSameFacing(rightState, facing) && (!secondRightState.is(this.tag) || secondRightState.getValue(FACING) != facing || !this.isCenterPart(secondRightState));

        if (left && right) {
            if (this.hasSameFacing(secondRightState, facing) && secondRightState.getValue(LEFT)) {
                right = false;
            } else if (this.hasSameFacing(secondLefState, facing) && secondLefState.getValue(RIGHT)) {
                left = false;
            }
        }

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(LEFT, left)
                .setValue(RIGHT, right)
                .setValue(WATERLOGGED, flag);
    }

    public boolean isCenterPart(BlockState state) {
        return state.is(this.tag) && state.getValue(LEFT) && state.getValue(RIGHT);
    }

    public boolean hasSameFacing(BlockState state, Direction facing) {
        return state.is(this.tag) && state.getValue(FACING) == facing;
    }

    @NotNull
    @Override
    public BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        Direction facing = state.getValue(FACING);
        boolean flag = this.hasSameFacing(neighborState, facing);

        if (direction == facing.getClockWise()) {
            return state.setValue(LEFT, flag && neighborState.getValue(RIGHT));
        } else if (direction == facing.getCounterClockWise()) {
            return state.setValue(RIGHT, flag && neighborState.getValue(LEFT));
        }


        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    public WoodType getWoodType() {
        return this.woodType;
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
        builder.add(FACING, LEFT, RIGHT, WATERLOGGED);
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
}
