package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * Mod BlockState Properties <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-02
 */
public class ModBlockStateProperties {

    public static final EnumProperty<CurtainPart> CURTAIN_PART = EnumProperty.create("part", CurtainPart.class);

    public static final BooleanProperty ROTATED = BooleanProperty.create("rotated");
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty SWITCHED_ON = BooleanProperty.create("switched_on");

}
