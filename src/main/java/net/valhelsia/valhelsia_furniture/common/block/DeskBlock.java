package net.valhelsia.valhelsia_furniture.common.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.util.TextureKey;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2022-05-13
 */
public class DeskBlock extends Block implements SimpleWaterloggedBlock {

    private static final String TEXTURE_PATH = "block/desk/";

    public static final Map<String, List<TextureKey>> VARIANT_TEXTURES = ImmutableMap.<String, List<TextureKey>>builder()
            .put("single", List.of(
                    TextureKey.of("top", TEXTURE_PATH),
                    TextureKey.of("top_middle", TEXTURE_PATH),
                    TextureKey.of("front", TEXTURE_PATH),
                    TextureKey.of("side", TEXTURE_PATH)
            ))
            .put("center", List.of(
                    TextureKey.of("top_side", TEXTURE_PATH),
                    TextureKey.of("top_middle", TEXTURE_PATH),
                    TextureKey.of("front", TEXTURE_PATH),
                    TextureKey.of("side", TEXTURE_PATH),
                    TextureKey.of("middle", TEXTURE_PATH)
            ))
            .put("left_or_right", List.of(
                    TextureKey.of("top", TEXTURE_PATH),
                    TextureKey.of("top_side", TEXTURE_PATH),
                    TextureKey.of("top_middle", TEXTURE_PATH),
                    TextureKey.of("front", TEXTURE_PATH),
                    TextureKey.of("side", TEXTURE_PATH),
                    TextureKey.of("middle", TEXTURE_PATH)
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

    private final TagKey<Block> tag;

    public DeskBlock(TagKey<Block> tag, Properties properties) {
        super(properties);
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

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
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

    @Nonnull
    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction direction, @Nonnull BlockState neighborState, @Nonnull LevelAccessor level, @Nonnull BlockPos currentPos, @Nonnull BlockPos neighborPos) {
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
        builder.add(FACING, LEFT, RIGHT, WATERLOGGED);
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
