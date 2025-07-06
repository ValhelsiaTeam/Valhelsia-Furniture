package net.valhelsia.valhelsia_furniture.forge;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.valhelsia.valhelsia_core.datagen.DataProviderContext;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.forge.data.ModBlockLootTables;
import net.valhelsia.valhelsia_furniture.forge.data.ModLanguageProvider;

import java.util.List;
import java.util.Set;

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

            event.getGenerator().addProvider(true, new ModLanguageProvider(event.getGenerator().getPackOutput(), "en_us"));
//            event.getGenerator().addProvider(true, new ValhelsiaModelProvider(context, ModBlockModels::new, null));
//            event.getGenerator().addProvider(true, new ValhelsiaRecipeProvider(context, ModRecipeProvider::new));

            event.getGenerator().addProvider(true, new LootTableProvider(event.getGenerator().getPackOutput(), Set.of(), List.of(new LootTableProvider.SubProviderEntry(provider -> new ModBlockLootTables(Set.of(), FeatureFlags.DEFAULT_FLAGS, provider), LootContextParamSets.BLOCK)), event.getLookupProvider()));
        }
    }
}