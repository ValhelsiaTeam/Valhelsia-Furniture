package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.common.helper.VoxelShapeHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Upholstered Chair Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.UpholsteredChairBlock
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-02-04
 */
public class UpholsteredChairBlock extends ChairBlock {

    private static final Map<Direction, VoxelShape> SHAPES = VoxelShapeHelper.getHorizontalRotatedShapes(Shapes.or(
            Block.box(3.0D, 0.0D, 4.0D, 5.0D, 7.0D, 6.0D),
            Block.box(11.0D, 0.0D, 4.0D, 13.0D, 7.0D, 6.0D),
            Block.box(3.0D, 0.0D, 12.0D, 5.0D, 7.0D, 14.0D),
            Block.box(11.0D, 0.0D, 12.0D, 13.0D, 7.0D, 14.0D),
            Block.box(2.0D, 9.0D, 13.0D, 14.0D, 20.0D, 15.0D),
            Block.box(2.0D, 6.0D, 3.0D, 14.0D, 9.0D, 15.0D)
    ));

    public UpholsteredChairBlock(String baseName, Properties properties) {
        super(baseName, properties);
    }

    public UpholsteredChairBlock(String baseName, @Nullable DyeColor color, Properties properties) {
        super(baseName, color, properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nonnull
    @Override
    public String getDescriptionId() {
        return "block.valhelsia_furniture.upholstered_" + this.getBaseName() + "_chair";
    }
}
