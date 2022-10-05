package net.valhelsia.valhelsia_furniture.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.data.loot.ModLootTableProvider;
import net.valhelsia.valhelsia_furniture.data.models.ModBlockStateProvider;
import net.valhelsia.valhelsia_furniture.data.models.ModItemModelProvider;
import net.valhelsia.valhelsia_furniture.data.recipes.ModRecipeProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModBlockTagsProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModItemTagsProvider;

/**
 * @author Valhelsia Team
 * @since 2021-01-05
 */
@Mod.EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, existingFileHelper));

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(generator, blockTagsProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));

        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
    }
}
