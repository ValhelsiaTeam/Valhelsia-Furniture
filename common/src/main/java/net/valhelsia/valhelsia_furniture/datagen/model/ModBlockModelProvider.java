package net.valhelsia.valhelsia_furniture.datagen.model;

import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.valhelsia.valhelsia_core.api.datagen.ValhelsiaModelProvider;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-12
 */
public class ModBlockModelProvider extends ValhelsiaModelProvider {

    public ModBlockModelProvider(PackOutput arg) {
        super(arg);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generators) {
        ModBlockModels.create(generators);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
