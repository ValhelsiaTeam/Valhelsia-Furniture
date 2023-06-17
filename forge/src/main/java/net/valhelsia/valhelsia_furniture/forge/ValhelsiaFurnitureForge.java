package net.valhelsia.valhelsia_furniture.forge;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.forge.data.ModLanguageProvider;
import net.valhelsia.valhelsia_furniture.datagen.model.ModBlockModelProvider;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurnitureForge {
    public ValhelsiaFurnitureForge() {
        ValhelsiaFurniture.init();
    }

    @Mod.EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class TestEvents {

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            event.getGenerator().addProvider(true, new ModLanguageProvider(event.getGenerator().getPackOutput(), "en_us"));
            event.getGenerator().addProvider(true, new ModBlockModelProvider(event.getGenerator().getPackOutput()));

        }
    }
}