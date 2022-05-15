package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Desk Drawer Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.DeskDrawerBlock
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-13
 */
public class DeskDrawerBlock extends DeskBlock {

    private static final VoxelShape DRAWER_SHAPE = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private static final Map<Direction, VoxelShape> LEFT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(0.0D, 4.0D, 2.0D, 1.0D, 12.0D, 3.0D));
    private static final Map<Direction, VoxelShape> RIGHT_CONNECT_SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Block.box(15.0D, 4.0D, 2.0D, 16.0D, 12.0D, 3.0D));

    private final Map<BlockState, VoxelShape> shapesCache;

    public DeskDrawerBlock(TagKey<Block> tag, Properties properties) {
        super(tag, properties);
        this.shapesCache = this.getShapeForEachState(this::calculateShape);
    }

    private VoxelShape calculateShape(BlockState state) {
        Direction facing = state.getValue(FACING);
        boolean left = state.getValue(LEFT);
        boolean right = state.getValue(RIGHT);

        VoxelShape shape = Shapes.or(SHAPE, DRAWER_SHAPE);

        if (left && right) {
            shape = Shapes.or(shape, LEFT_CONNECT_SHAPES.get(facing.getOpposite()), RIGHT_CONNECT_SHAPES.get(facing.getOpposite()));
        } else if (left) {
            shape = Shapes.or(shape, LEFT_CONNECT_SHAPES.get(facing.getOpposite()));
        } else if (right) {
            shape = Shapes.or(shape, RIGHT_CONNECT_SHAPES.get(facing.getOpposite()));
        }

        return shape;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return this.shapesCache.get(state);
    }
}
