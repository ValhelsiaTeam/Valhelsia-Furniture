package net.valhelsia.valhelsia_furniture.datagen.models;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-15
 */
public class ModTextureMapping {

    public static ResourceLocation getBlockTexture(Block block, String folder) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        return resourceLocation.withPrefix("block/" + folder + "/");
    }

    public static ResourceLocation getBlockTexture(Block block, String folder, String suffix) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        return resourceLocation.withPath(s -> "block/" + folder + "/" + s + suffix);
    }

    public static ResourceLocation getBlockTexture(String folder, String texture) {
        return new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/" + folder + "/" + texture);
    }
}
