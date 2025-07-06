package net.valhelsia.valhelsia_structures.datagen

import net.valhelsia.dataforge.DataCollector
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.DataTarget
import net.valhelsia.valhelsia_structures.datagen.tags.ModBlockTagsProvider
import net.valhelsia.valhelsia_structures.datagen.tags.ModItemTagsProvider

class ProviderCollector : DataCollector() {

    override fun collectProviders(context: DataProviderContext) {
        with(DataTarget.SERVER) {
            addProvider(this, ModBlockTagsProvider(context))
            addProvider(this, ModItemTagsProvider(context))
        }
    }

    override fun collectRegistryProviders() {
    }
}