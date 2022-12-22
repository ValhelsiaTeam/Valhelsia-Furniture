package net.valhelsia.valhelsia_furniture.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_core.core.data.DataProviderInfo;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.data.loot.ModBlockLootTables;
import net.valhelsia.valhelsia_furniture.data.models.ModBlockStateProvider;
import net.valhelsia.valhelsia_furniture.data.models.ModItemModelProvider;
import net.valhelsia.valhelsia_furniture.data.recipes.ModRecipeProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModBlockTagsProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModItemTagsProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @author Valhelsia Team
 * @since 2021-01-05
 */
@Mod.EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        DataProviderInfo info = new DataProviderInfo(output, existingFileHelper, ValhelsiaFurniture.REGISTRY_MANAGER);

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTagsProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModRecipeProvider(info));

        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(() -> new ModBlockLootTables(Set.of(), FeatureFlags.DEFAULT_FLAGS), LootContextParamSets.BLOCK))));
    }
}
