package net.valhelsia.valhelsia_furniture.forge;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.valhelsia.valhelsia_core.datagen.DataProviderContext;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurnitureForge {

    public ValhelsiaFurnitureForge() {
        ValhelsiaFurniture.init();
    }

    @EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class TestEvents {

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataProviderContext context = new DataProviderContext(event.getGenerator().getPackOutput(), event.getLookupProvider(), ValhelsiaFurniture.REGISTRY_MANAGER, event.getExistingFileHelper());
            //            event.getGenerator().addProvider(true, new ValhelsiaRecipeProvider(context, ModRecipeProvider::new));
        }
    }
}