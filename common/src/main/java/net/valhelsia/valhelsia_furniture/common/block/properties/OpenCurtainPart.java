package net.valhelsia.valhelsia_furniture.common.block.properties;

import org.jetbrains.annotations.NotNull;

/**
 * @author Valhelsia Team
 * @since 2022-05-18
 */
public enum OpenCurtainPart implements CurtainPart {
    SINGLE("single", "curtain_open",  "curtain_open"),
    SINGLE_TOP("single_top", "top_middle_open", "top_middle_open"),
    SINGLE_BOTTOM("single_bottom", "down_middle_open", "down_middle_open"),
    SINGLE_MIDDLE("single_middle", "middle_open", "middle_open"),
    TOP("top", "middle", "middle"),
    MIDDLE("middle", "middle", "middle"),
    LEFT("left", "down_side_open", "down_side_open"),
    RIGHT("right", "down_side_open", "down_side_open"),
    LEFT_SIDE_TOP("left_side_top", "top_side_open",  "top_side_open"),
    LEFT_SIDE_MIDDLE("left_side_middle", "middle_side_open",  "middle_side_open"),
    LEFT_SIDE_BOTTOM("left_side_bottom", "down_side_open", "down_side_open"),
    RIGHT_SIDE_TOP("right_side_top", "top_side_open", "top_side_open"),
    RIGHT_SIDE_MIDDLE("right_side_middle", "middle_side_open", "middle_side_open"),
    RIGHT_SIDE_BOTTOM("right_side_bottom", "down_side_open", "down_side_open");

    private final String name;

    private final String topTexture;
    private final String bottomTexture;
    OpenCurtainPart(String name, String topTexture, String bottomTexture) {
        this.name = name;
        this.topTexture = topTexture;
        this.bottomTexture = bottomTexture;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @NotNull
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
