package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.util.StringRepresentable;
import net.valhelsia.valhelsia_furniture.datagen.model.ModModelTemplates;
import org.jetbrains.annotations.NotNull;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public enum ClosedCurtainPart implements StringRepresentable, CurtainPart {
    SINGLE("single", ModModelTemplates.CURTAIN_BOTTOM, "curtain", "curtain"),
    TOP("top", ModModelTemplates.CURTAIN, "curtain", "middle"),
    MIDDLE("middle", ModModelTemplates.CURTAIN_FULL, "middle", "middle"),
    BOTTOM("bottom", ModModelTemplates.CURTAIN_FULL_BOTTOM, "middle", "curtain");

    private final String name;
    private final ModelTemplate modelTemplate;

    private final String topTexture;
    private final String bottomTexture;

    ClosedCurtainPart(String name, ModelTemplate modelTemplate, String topTexture, String bottomTexture) {
        this.name = name;
        this.modelTemplate = modelTemplate;
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

    @Override
    public ModelTemplate getModelTemplate() {
        return this.modelTemplate;
    }
}
