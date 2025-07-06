package net.valhelsia.valhelsia_furniture.datagen.model

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture

object ModTextureMapping {
    fun getBlockTexture(block: Block, folder: String): ResourceLocation {
        val resourceLocation = BuiltInRegistries.BLOCK.getKey(block)
        return resourceLocation.withPrefix("block/$folder/")
    }

    fun getBlockTexture(block: Block, folder: String, suffix: String): ResourceLocation {
        val resourceLocation = BuiltInRegistries.BLOCK.getKey(block)
        return resourceLocation.withPath { "block/$folder/$it$suffix" }
    }

    fun getBlockTexture(folder: String, texture: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ValhelsiaFurniture.MOD_ID, "block/$folder/$texture")
    }
}
