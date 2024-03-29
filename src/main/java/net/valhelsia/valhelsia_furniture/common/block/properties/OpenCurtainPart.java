package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

import static net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart.ModelType.*;

/**
 * @author Valhelsia Team
 * @since 2022-05-18
 */
public enum OpenCurtainPart implements StringRepresentable, CurtainPart {
    SINGLE("single", CURTAIN, "curtain_open",  "curtain_open"),
    SINGLE_TOP("single_top", CURTAIN, "top_middle_open", "top_middle_open"),
    SINGLE_BOTTOM("single_bottom", CURTAIN_FULL, "down_middle_open", "down_middle_open"),
    SINGLE_MIDDLE("single_middle", CURTAIN_FULL, "middle_open", "middle_open"),
    TOP("top", CURTAIN_BRACKET, "middle", "middle"),
    MIDDLE("middle", CURTAIN_FULL, "middle", "middle"),
    LEFT("left", CURTAIN, "down_side_open", "down_side_open"),
    RIGHT("right", CURTAIN_MIRRORED, "down_side_open", "down_side_open"),
    LEFT_SIDE_TOP("left_side_top", CURTAIN, "top_side_open",  "top_side_open"),
    LEFT_SIDE_MIDDLE("left_side_middle", CURTAIN_FULL, "middle_side_open",  "middle_side_open"),
    LEFT_SIDE_BOTTOM("left_side_bottom", CURTAIN_FULL, "down_side_open", "down_side_open"),
    RIGHT_SIDE_TOP("right_side_top", CURTAIN_MIRRORED, "top_side_open", "top_side_open"),
    RIGHT_SIDE_MIDDLE("right_side_middle", CURTAIN_FULL_MIRRORED, "middle_side_open", "middle_side_open"),
    RIGHT_SIDE_BOTTOM("right_side_bottom", CURTAIN_FULL_MIRRORED, "down_side_open", "down_side_open");

    private final String name;
    private final ModelType modelType;

    private final String topTexture;
    private final String bottomTexture;
    OpenCurtainPart(String name, ModelType modelType, String topTexture, String bottomTexture) {
        this.name = name;
        this.modelType = modelType;
        this.topTexture = topTexture;
        this.bottomTexture = bottomTexture;
    }

    @Override
    public String getName() {
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

    @Override
    public String getTopTexture() {
        return this.topTexture;
    }

    @Override
    public String getBottomTexture() {
        return this.bottomTexture;
    }

    @Override
    public ModelType getModelType() {
        return this.modelType;
    }

    @Override
    public boolean isSingleRow() {
        return this.name.contains("single");
    }

    @Override
    public boolean isTopOrSingle() {
        return this.name.contains("top") || this == OpenCurtainPart.SINGLE;
    }

    public boolean isMiddle() {
        return this.name.contains("middle");
    }

    @Override
    public boolean isSingle() {
        return this == SINGLE;
    }

    public boolean isBottomOrSingle() {
        return this.name.contains("bottom") || this == OpenCurtainPart.SINGLE;
    }

    public static OpenCurtainPart getTypeForConnections(boolean connectUp, boolean connectDown) {
        if (connectUp && connectDown) {
            return OpenCurtainPart.SINGLE_MIDDLE;
        } else if (connectUp) {
            return OpenCurtainPart.SINGLE_BOTTOM;
        } else if (connectDown) {
            return OpenCurtainPart.SINGLE_TOP;
        }

        return OpenCurtainPart.SINGLE;
    }
}
