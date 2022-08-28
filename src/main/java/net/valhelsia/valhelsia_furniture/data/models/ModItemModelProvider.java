package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaItemModelProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

/**
 * Mod Item Model Provider <br>
 * Valhelsia Structures - net.valhelsia.valhelsia_furniture.data.DataGenerators.models.ModItemModelProvider
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2021-01-05
 */
public class ModItemModelProvider extends ValhelsiaItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ValhelsiaFurniture.REGISTRY_MANAGER, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModBlocks.FABRIC_DESK_LAMPS.values().forEach(registryObject -> {
            takeBlockItem(this::simpleModel, registryObject);
        });

        ModBlocks.CURTAINS.forEach((color, registryObject) -> {
            takeBlockItem(item -> this.withParent(item, color.getName() + "_curtain_single"), registryObject);
        });

        forEachBlockItem(this::withParent);

        forEachItem(this::simpleModel);
    }
}
