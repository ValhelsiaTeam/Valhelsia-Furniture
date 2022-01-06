package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaItemModelProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

/**
 * Mod Item Model Provider <br>
 * Valhelsia Structures - net.valhelsia.valhelsia_furniture.data.DataGenerators.models.ModItemModelProvider
 *
 * @author Valhelsia Team
 * @version 1.18.1-0.1.0
 * @since 2021-01-05
 */
public class ModItemModelProvider extends ValhelsiaItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ValhelsiaFurniture.REGISTRY_MANAGER, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        forEachBlockItem(this::withParent);

        forEachItem(this::simpleModel);
    }
}
