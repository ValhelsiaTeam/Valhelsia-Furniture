package net.valhelsia.valhelsia_furniture.datagen.loot

import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.data.loot.LootTableSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block
import net.valhelsia.valhelsia_furniture.common.block.OpenCurtainBlock
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks

class ModBlockLoot(
    context: LootTableSubProvider.Context,
    val blocks: List<() -> Block>
) : BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), context) {
    override fun generate() {
        blocks.map { it() }
            .filterNot { it is OpenCurtainBlock }
            .forEach { dropSelf(it) }

        ModBlocks.OPEN_CURTAINS.forEach { color, entry ->
            add(entry.value(), createSingleItemTable(ModBlocks.CLOSED_CURTAINS[color]!!.value()))
        }
    }

    override fun getKnownBlocks() = blocks.map { it() }
}