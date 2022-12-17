package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaItemModelProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

/**
 * Mod Item Model Provider <br>
 * Valhelsia Structures - net.valhelsia.valhelsia_furniture.data.DataGenerators.models.ModItemModelProvider
 *
 * @author Valhelsia Team
 * @since 2021-01-05
 */
public class ModItemModelProvider extends ValhelsiaItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ValhelsiaFurniture.REGISTRY_MANAGER, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModBlocks.FABRIC_DESK_LAMPS.values().forEach(registryObject -> {
            takeBlockItem(this::simpleModel, registryObject);
        });

        ModBlocks.CURTAINS.forEach((color, pair) -> {
            takeBlockItem(item -> this.withParent(item, color.getName() + "_curtain_single"), pair.getFirst());
        });

        forEachBlockItem(this::withParent);

        forEachItem(this::simpleModel);
    }
}
