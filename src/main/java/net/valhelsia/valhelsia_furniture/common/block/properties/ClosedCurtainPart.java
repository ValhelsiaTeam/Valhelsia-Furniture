package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

import static net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart.ModelType.*;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public enum ClosedCurtainPart implements StringRepresentable, CurtainPart {
    SINGLE("single", CURTAIN, "curtain", "curtain"),
    TOP("top", CURTAIN, "curtain", "middle"),
    MIDDLE("middle", CURTAIN_FULL, "middle", "middle"),
    BOTTOM("bottom", CURTAIN_FULL, "middle", "curtain");

    private final String name;
    private final ModelType modelType;

    private final String topTexture;
    private final String bottomTexture;

    ClosedCurtainPart(String name, ModelType modelType, String topTexture, String bottomTexture) {
        this.name = name;
        this.modelType = modelType;
        this.topTexture = topTexture;
        this.bottomTexture = bottomTexture;
    }

    @Nonnull
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

    @Override
    public ModelType getModelType() {
        return this.modelType;
    }
}
