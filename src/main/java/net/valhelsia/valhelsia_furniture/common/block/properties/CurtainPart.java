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
    SINGLE("single", "", CurtainPart.CURTAIN, "curtain", "curtain_open", "curtain", "curtain_open"),
    SINGLE_TOP("single_top", "top", CurtainPart.CURTAIN, "curtain", "top_middle_open", "middle", "top_middle_open"),
    SINGLE_BOTTOM("single_bottom", "bottom", CurtainPart.CURTAIN_FULL, "middle", "down_middle_open", "curtain", "down_middle_open");

    public static final String CURTAIN = "block/template_curtain";
    public static final String CURTAIN_FULL = "block/template_curtain_full";

    private final String name;
    private final String modelName;
    private final ResourceLocation parentModel;

    private final String[] textures;

    CurtainPart(String name, String modelName, String parentModel, String topTexture, String openTopTexture, String bottomTexture, String openBottomTexture) {
        this.name = name;
        this.modelName = modelName;
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
        return this.modelName.equals("") ? "" : "_" + this.modelName;
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
}
