package net.valhelsia.valhelsia_furniture.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.data.models.ModBlockStateProvider;
import net.valhelsia.valhelsia_furniture.data.models.ModItemModelProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModBlockTagsProvider;
import net.valhelsia.valhelsia_furniture.data.tags.ModItemTagsProvider;

/**
 * Data Generators <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.data.DataGenerators
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2021-01-05
 */
@Mod.EventBusSubscriber(modid = ValhelsiaFurniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        }

        if (event.includeServer()) {
            ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, existingFileHelper);
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new ModItemTagsProvider(generator, blockTagsProvider, existingFileHelper));
//
//            generator.addProvider(new ModLootTableProvider(generator));
//            generator.addProvider(new ModRecipeProvider(generator));
//            generator.addProvider(new ModLootModifierProvider(generator));
        }
    }
}
