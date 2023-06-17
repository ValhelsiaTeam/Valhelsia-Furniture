package net.valhelsia.valhelsia_furniture.datagen.model;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

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
}
