package net.valhelsia.valhelsia_furniture.common.block.properties;

import org.jetbrains.annotations.NotNull;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public enum ClosedCurtainPart implements CurtainPart {
    SINGLE("single", "curtain", "curtain"),
    TOP("top", "curtain", "middle"),
    MIDDLE("middle", "middle", "middle"),
    BOTTOM("bottom", "middle", "curtain");

    private final String name;

    private final String topTexture;
    private final String bottomTexture;

    ClosedCurtainPart(String name, String topTexture, String bottomTexture) {
        this.name = name;
        this.topTexture = topTexture;
        this.bottomTexture = bottomTexture;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    public static ClosedCurtainPart getTypeForConnections(boolean connectUp, boolean connectDown) {
        if (connectUp && connectDown) {
            return ClosedCurtainPart.MIDDLE;
        } else if (connectUp) {
            return ClosedCurtainPart.BOTTOM;
        } else if (connectDown) {
            return ClosedCurtainPart.TOP;
        }

        return ClosedCurtainPart.SINGLE;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isSingle() {
        return this == SINGLE;
    }

    @Override
    public boolean isBottomOrSingle() {
        return this == BOTTOM || this == SINGLE;
    }

    @Override
    public boolean isTopOrSingle() {
        return this == TOP || this == SINGLE;
    }

    @Override
    public boolean isSingleRow() {
        return true;
    }

    @Override
    public String getTopTexture() {
        return this.topTexture;
    }

    @Override
    public String getBottomTexture() {
        return this.bottomTexture;
    }
}
