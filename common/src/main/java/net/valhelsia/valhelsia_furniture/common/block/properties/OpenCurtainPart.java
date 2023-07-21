package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.util.StringRepresentable;
import net.valhelsia.valhelsia_furniture.datagen.models.ModModelTemplates;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Valhelsia Team
 * @since 2022-05-18
 */
public enum OpenCurtainPart implements StringRepresentable, CurtainPart {
    SINGLE("single", ModModelTemplates.CURTAIN_BOTTOM, "curtain_open",  "curtain_open"),
    SINGLE_TOP("single_top", ModModelTemplates.CURTAIN, "top_middle_open", "top_middle_open"),
    SINGLE_BOTTOM("single_bottom", ModModelTemplates.CURTAIN_FULL_BOTTOM, "down_middle_open", "down_middle_open"),
    SINGLE_MIDDLE("single_middle", ModModelTemplates.CURTAIN_FULL_BOTTOM, "middle_open", "middle_open"),
    TOP("top", null, "middle", "middle"),
    MIDDLE("middle", ModModelTemplates.CURTAIN_FULL, "middle", "middle"),
    LEFT("left", ModModelTemplates.CURTAIN_BOTTOM, "down_side_open", "down_side_open"),
    RIGHT("right", ModModelTemplates.CURTAIN_MIRRORED_BOTTOM, "down_side_open", "down_side_open"),
    LEFT_SIDE_TOP("left_side_top", ModModelTemplates.CURTAIN, "top_side_open",  "top_side_open"),
    LEFT_SIDE_MIDDLE("left_side_middle", ModModelTemplates.CURTAIN_FULL, "middle_side_open",  "middle_side_open"),
    LEFT_SIDE_BOTTOM("left_side_bottom", ModModelTemplates.CURTAIN_FULL_BOTTOM, "down_side_open", "down_side_open"),
    RIGHT_SIDE_TOP("right_side_top", ModModelTemplates.CURTAIN_MIRRORED, "top_side_open", "top_side_open"),
    RIGHT_SIDE_MIDDLE("right_side_middle", ModModelTemplates.CURTAIN_FULL_MIRRORED, "middle_side_open", "middle_side_open"),
    RIGHT_SIDE_BOTTOM("right_side_bottom", ModModelTemplates.CURTAIN_FULL_MIRRORED_BOTTOM, "down_side_open", "down_side_open");

    private final String name;
    private final @Nullable ModelTemplate modelTemplate;

    private final String topTexture;
    private final String bottomTexture;
    OpenCurtainPart(String name, @Nullable ModelTemplate modelTemplate, String topTexture, String bottomTexture) {
        this.name = name;
        this.modelTemplate = modelTemplate;
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
    public @Nullable ModelTemplate getModelTemplate() {
        return this.modelTemplate;
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
