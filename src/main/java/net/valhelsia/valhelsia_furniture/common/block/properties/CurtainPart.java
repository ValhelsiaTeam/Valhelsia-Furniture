package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

import javax.annotation.Nonnull;

/**
 * @author Valhelsia Team
 * @since 2022-05-18
 */
public enum CurtainPart implements StringRepresentable {
    SINGLE("single", CurtainPart.CURTAIN, "curtain", "curtain_open", "curtain", "curtain_open"),
    SINGLE_TOP("single_top", CurtainPart.CURTAIN, "curtain", "top_middle_open", "middle", "top_middle_open"),
    SINGLE_BOTTOM("single_bottom", CurtainPart.CURTAIN_FULL, "middle", "down_middle_open", "curtain", "down_middle_open"),
    SINGLE_MIDDLE("single_middle", CurtainPart.CURTAIN_FULL, "middle", "middle_open", "middle", "middle_open"),
    TOP("top", "curtain_bracket", "middle", "middle", "middle", "middle"),
    MIDDLE("middle", CurtainPart.CURTAIN_FULL, "middle", "middle", "middle", "middle"),
    LEFT("left", CurtainPart.CURTAIN, "down_side_open", "down_side_open", "down_side_open", "down_side_open"),
    RIGHT("right", CurtainPart.CURTAIN_MIRRORED, "down_side_open", "down_side_open", "down_side_open", "down_side_open"),
    LEFT_SIDE_TOP("left_side_top", CurtainPart.CURTAIN, "middle", "top_side_open", "middle", "top_side_open"),
    LEFT_SIDE_MIDDLE("left_side_middle", CurtainPart.CURTAIN_FULL, "middle_side_open", "middle_side_open", "middle_side_open", "middle_side_open"),
    LEFT_SIDE_BOTTOM("left_side_bottom", CurtainPart.CURTAIN_FULL, "down_side_open", "down_side_open", "down_side_open", "down_side_open"),
    RIGHT_SIDE_TOP("right_side_top", CurtainPart.CURTAIN_MIRRORED, "middle", "top_side_open", "middle", "top_side_open"),
    RIGHT_SIDE_MIDDLE("right_side_middle", CurtainPart.CURTAIN_FULL_MIRRORED, "middle_side_open", "middle_side_open", "middle_side_open", "middle_side_open"),
    RIGHT_SIDE_BOTTOM("right_side_bottom", CurtainPart.CURTAIN_FULL_MIRRORED, "down_side_open", "down_side_open", "down_side_open", "down_side_open")
    ;

    private static final String CURTAIN = "block/template_curtain";
    private static final String CURTAIN_MIRRORED = "block/template_curtain_mirrored";
    private static final String CURTAIN_FULL = "block/template_curtain_full";
    private static final String CURTAIN_FULL_MIRRORED = "block/template_curtain_full_mirrored";

    private final String name;
    private final ResourceLocation parentModel;

    private final String[] textures;

    CurtainPart(String name, String parentModel, String topTexture, String openTopTexture, String bottomTexture, String openBottomTexture) {
        this.name = name;
        this.parentModel = new ResourceLocation(ValhelsiaFurniture.MOD_ID, parentModel);
        this.textures = new String[]{topTexture, openTopTexture, bottomTexture, openBottomTexture};
    }

    public String toString() {
        return this.name;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    public String getModelName() {
        return "_" + this.name;
    }

    public ResourceLocation getParentModel() {
        return this.parentModel;
    }

    public String getTopTexture(boolean open) {
        return this.textures[open ? 1 : 0];
    }

    public String getBottomTexture(boolean open) {
        return this.textures[open ? 3 : 2];
    }

    public boolean isSingleRow() {
        return this.name.contains("single");
    }

    public boolean isLeftSide() {
        return this.name.contains("left");
    }

    public boolean isRightSide() {
        return this.name.contains("right");
    }

    public boolean isTopOrSingle() {
        return this.name.contains("top") || this == CurtainPart.SINGLE;
    }

    public boolean isMiddle() {
        return this.name.contains("middle");
    }

    public boolean isBottomOrSingle() {
        return this.name.contains("bottom") || this == CurtainPart.SINGLE;
    }

    public static CurtainPart getTypeForConnections(boolean connectUp, boolean connectDown) {
        if (connectUp && connectDown) {
            return CurtainPart.SINGLE_MIDDLE;
        } else if (connectUp) {
            return CurtainPart.SINGLE_BOTTOM;
        } else if (connectDown) {
            return CurtainPart.SINGLE_TOP;
        }

        return CurtainPart.SINGLE;
    }
}
