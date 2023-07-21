package net.valhelsia.valhelsia_furniture.datagen.models;

import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.valhelsia.valhelsia_core.api.datagen.ValhelsiaModelProvider;
import net.valhelsia.valhelsia_core.api.registry.RegistryEntry;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-12
 */
public class ModBlockModelProvider extends ValhelsiaModelProvider {

    public ModBlockModelProvider(PackOutput arg) {
        super(arg);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generators, Consumer<Item> skippedAutoItemModels) {
        ModBlockModels.create(generators, skippedAutoItemModels);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }

    @Override
    public Collection<RegistryEntry<? extends Block>> getBlocks() {
        return ModBlocks.HELPER.getRegistryEntries();
    }
}
