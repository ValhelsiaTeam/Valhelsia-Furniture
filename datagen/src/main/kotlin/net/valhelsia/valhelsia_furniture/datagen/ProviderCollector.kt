package net.valhelsia.valhelsia_furniture.datagen

import net.minecraft.data.loot.LootTableProvider
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.valhelsia.dataforge.DataCollector
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.DataTarget
import net.valhelsia.dataforge.model.DataForgeModelProvider
import net.valhelsia.dataforge.recipe.DataForgeRecipeRunner
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture
import net.valhelsia.valhelsia_furniture.datagen.lang.ModLanguageProvider
import net.valhelsia.valhelsia_furniture.datagen.loot.ModBlockLoot
import net.valhelsia.valhelsia_furniture.datagen.model.ModBlockModels
import net.valhelsia.valhelsia_furniture.datagen.recipe.ModRecipeProvider
import net.valhelsia.valhelsia_furniture.datagen.tags.ModBlockTagsProvider
import net.valhelsia.valhelsia_furniture.datagen.tags.ModItemTagsProvider

class ProviderCollector : DataCollector() {

    override fun collectProviders(context: DataProviderContext) {
        val blocks = ValhelsiaFurniture.REGISTRY_MANAGER.blockHelper.registryEntries.map { { it.value() } }

        with(DataTarget.CLIENT) {
            addProvider(this, ModLanguageProvider(context.packOutput, "en_us"))
            addProvider(this, DataForgeModelProvider(context, blocks, { ModBlockModels(it) }, null))
        }

        with(DataTarget.SERVER) {
            addProvider(this, ModBlockTagsProvider(context))
            addProvider(this, ModItemTagsProvider(context))
            addProvider(
                this,
                DataForgeRecipeRunner(context, { provider, output -> ModRecipeProvider(provider, output) })
            )
            addProvider(
                this, LootTableProvider(
                    context.packOutput, setOf<ResourceKey<LootTable>>(), listOf(
                        LootTableProvider.SubProviderEntry({ ModBlockLoot(it, blocks) }, LootContextParamSets.BLOCK)
                    ),
                    context.lookupProvider
                )
            )
        }
    }

    override fun collectRegistryProviders() {
    }
}