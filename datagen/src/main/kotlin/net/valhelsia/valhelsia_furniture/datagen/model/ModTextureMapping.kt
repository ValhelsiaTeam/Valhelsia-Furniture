package net.valhelsia.valhelsia_furniture.datagen.model

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.Block
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture

object ModTextureMapping {
    fun getBlockTexture(block: Block, folder: String): Identifier {
        val resourceLocation = BuiltInRegistries.BLOCK.getKey(block)
        return resourceLocation.withPrefix("block/$folder/")
    }

    fun getBlockTexture(block: Block, folder: String, suffix: String): Identifier {
        val resourceLocation = BuiltInRegistries.BLOCK.getKey(block)
        return resourceLocation.withPath { "block/$folder/$it$suffix" }
    }

    fun getBlockTexture(folder: String, texture: String): Identifier {
        return Identifier.fromNamespaceAndPath(ValhelsiaFurniture.MOD_ID, "block/$folder/$texture")
    }
}
