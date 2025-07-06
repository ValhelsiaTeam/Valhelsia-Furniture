package net.valhelsia.valhelsia_structures.datagen

import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.data.event.GatherDataEvent
import net.valhelsia.dataforge.DataForge
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture

@Mod(ValhelsiaFurniture.MOD_ID)
class DataGenerators(eventBus: IEventBus) {

    init {
        DataForge.setup(ProviderCollector(), eventBus)
    }

    fun gatherData(event: GatherDataEvent?) {

    }
}