package net.valhelsia.valhelsia_furniture.common.util;

import net.minecraft.resources.ResourceLocation;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;

/**
 * @author Valhelsia Team
 * @since 2022-10-19
 */
public record TextureKey(String key, String path) {

    public static TextureKey of(String key, String path) {
        return new TextureKey(key, path);
    }

    public ResourceLocation apply(String type) {
        return new ResourceLocation(ValhelsiaFurniture.MOD_ID, this.path() + type + "/" + this.key());
    }
}
