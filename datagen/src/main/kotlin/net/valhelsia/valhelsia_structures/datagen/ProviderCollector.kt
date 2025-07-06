package net.valhelsia.valhelsia_structures.datagen

import net.valhelsia.dataforge.DataCollector
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.DataTarget
import net.valhelsia.dataforge.model.DataForgeModelProvider
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture
import net.valhelsia.valhelsia_structures.datagen.lang.ModLanguageProvider
import net.valhelsia.valhelsia_structures.datagen.model.ModBlockModels
import net.valhelsia.valhelsia_structures.datagen.tags.ModBlockTagsProvider
import net.valhelsia.valhelsia_structures.datagen.tags.ModItemTagsProvider

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
        }
    }

    override fun collectRegistryProviders() {
    }
}