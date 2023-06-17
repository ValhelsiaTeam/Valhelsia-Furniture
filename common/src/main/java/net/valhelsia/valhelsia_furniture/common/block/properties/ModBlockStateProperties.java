package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * @author Valhelsia Team
 * @since 2022-01-02
 */
public class ModBlockStateProperties {

    //public static final EnumProperty<OpenCurtainPart> OPEN_CURTAIN_PART = EnumProperty.create("part", OpenCurtainPart.class);
    //public static final EnumProperty<ClosedCurtainPart> CLOSED_CURTAIN_PART = EnumProperty.create("part", ClosedCurtainPart.class);

    public static final BooleanProperty ROTATED = BooleanProperty.create("rotated");
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty SWITCHED_ON = BooleanProperty.create("switched_on");

}
