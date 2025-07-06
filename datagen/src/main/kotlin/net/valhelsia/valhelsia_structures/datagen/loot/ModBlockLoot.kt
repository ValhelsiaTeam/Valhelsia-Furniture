package net.valhelsia.valhelsia_structures.datagen.loot

import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.valhelsia.valhelsia_furniture.common.block.OpenCurtainBlock
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks

class ModBlockLoot(
    lookupProvider: HolderLookup.Provider, val blocks: List<() -> Block>
) : BlockLootSubProvider(setOf<Item>(), FeatureFlags.REGISTRY.allFlags(), lookupProvider) {
    override fun generate() {
        blocks.map { it() }
            .filterNot { it is OpenCurtainBlock }
            .forEach { dropSelf(it) }

        ModBlocks.OPEN_CURTAINS.forEach {
            add(it.value.get(), createSingleItemTable(ModBlocks.CLOSED_CURTAINS[it.key]!!.value()))
        }
    }

    override fun getKnownBlocks() = blocks.map { it() }
}