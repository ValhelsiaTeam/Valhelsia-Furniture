package net.valhelsia.valhelsia_furniture.datagen

import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.valhelsia.dataforge.DataCollector
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.model.DataForgeModelProvider
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture
import net.valhelsia.valhelsia_furniture.datagen.lang.ModLanguageProvider
import net.valhelsia.valhelsia_furniture.datagen.loot.ModBlockLoot
import net.valhelsia.valhelsia_furniture.datagen.model.ModBlockModels
import net.valhelsia.valhelsia_furniture.datagen.recipe.ModRecipeProvider
import net.valhelsia.valhelsia_furniture.datagen.tags.ModBlockTagsProvider
import net.valhelsia.valhelsia_furniture.datagen.tags.ModItemTagsProvider

class ProviderCollector : DataCollector() {

    override fun collectClientProviders(context: DataProviderContext.Client) {
        print("Generating assets for %s".format(ValhelsiaFurniture.MOD_ID))
        addClientProvider(ModLanguageProvider(context.packOutput, "en_us"))
        addClientProvider(DataForgeModelProvider(context, { ModBlockModels(it) }, null))
    }

    override fun collectServerProviders(context: DataProviderContext.Server) {
        addServerProvider(ModBlockTagsProvider(context))
        addServerProvider(ModItemTagsProvider(context))
    }

    override fun collectRegistryProviders() {
        val blocks = ValhelsiaFurniture.REGISTRY_MANAGER.blockHelper.registryEntries.map { { it.value() } }

        addRecipeProvider(::ModRecipeProvider)

        addLootTableProvider(
            LootTableProvider.SubProviderEntry({ ModBlockLoot(it, blocks) }, LootContextParamSets.BLOCK)
        )
    }
}