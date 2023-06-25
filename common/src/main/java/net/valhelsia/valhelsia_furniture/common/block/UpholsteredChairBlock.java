package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valhelsia.valhelsia_core.api.helper.VoxelShapeHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Upholstered Chair Block <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.UpholsteredChairBlock
 *
 * @author Valhelsia Team
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

    private final String descriptionId;

    public UpholsteredChairBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
        this.descriptionId = "block.valhelsia_furniture.upholstered_" + this.getWoodType().name() + "_chair";
    }

    public UpholsteredChairBlock(WoodType woodType, @Nullable DyeColor color, Properties properties) {
        super(woodType, color, properties);
        this.descriptionId = "block.valhelsia_furniture.upholstered_" + this.getWoodType().name() + "_chair";
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @NotNull
    @Override
    public String getDescriptionId() {
        return this.descriptionId;
    }
}
