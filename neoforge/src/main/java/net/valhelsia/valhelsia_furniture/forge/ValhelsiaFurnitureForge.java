package net.valhelsia.valhelsia_furniture.forge;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.valhelsia.valhelsia_core.api.datagen.DataProviderContext;
import net.valhelsia.valhelsia_core.api.datagen.recipes.ValhelsiaRecipeProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.datagen.ModBlockLootTables;
import net.valhelsia.valhelsia_furniture.datagen.ModRecipeProvider;
import net.valhelsia.valhelsia_furniture.datagen.models.ModBlockModelProvider;
import net.valhelsia.valhelsia_furniture.datagen.tags.ModBlockTagsProvider;
import net.valhelsia.valhelsia_furniture.datagen.tags.ModItemTagsProvider;
import net.valhelsia.valhelsia_furniture.forge.data.ModLanguageProvider;

import java.util.List;
import java.util.Set;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurnitureForge {
    public ValhelsiaFurnitureForge() {
        ValhelsiaFurniture.init();
    }

    @Mod.EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class TestEvents {

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataProviderContext context = new DataProviderContext(event.getGenerator().getPackOutput(), event.getLookupProvider(), ValhelsiaFurniture.REGISTRY_MANAGER);

            event.getGenerator().addProvider(true, new ModLanguageProvider(event.getGenerator().getPackOutput(), "en_us"));
            event.getGenerator().addProvider(true, new ModBlockModelProvider(event.getGenerator().getPackOutput()));
            event.getGenerator().addProvider(true, new ValhelsiaRecipeProvider(context, ModRecipeProvider::new));

            TagsProvider<Block> blockTagsProvider = new ModBlockTagsProvider(event.getGenerator().getPackOutput(), event.getLookupProvider());

            event.getGenerator().addProvider(true, blockTagsProvider);
            event.getGenerator().addProvider(true, new ModItemTagsProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), blockTagsProvider.contentsGetter()));

            event.getGenerator().addProvider(true, new LootTableProvider(event.getGenerator().getPackOutput(), Set.of(), List.of(new LootTableProvider.SubProviderEntry(() -> new ModBlockLootTables(Set.of(), FeatureFlags.DEFAULT_FLAGS), LootContextParamSets.BLOCK))));
        }
    }
}