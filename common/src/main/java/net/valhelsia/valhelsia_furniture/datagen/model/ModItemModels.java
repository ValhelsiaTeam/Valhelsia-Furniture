package net.valhelsia.valhelsia_furniture.datagen.model;

import com.google.gson.JsonElement;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-07-15
 */
public class ModItemModels {

    private final ItemModelGenerators generators;
    private final Set<Item> skippedAutoBlockModels;
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;


    public ModItemModels(ItemModelGenerators generators, Set<Item> skippedAutoBlockModels) {
        this.generators = generators;
        this.skippedAutoBlockModels = skippedAutoBlockModels;
        this.modelOutput = generators.output;
    }

    public static void create(ItemModelGenerators generators, Set<Item> skippedAutoBlockModels) {
        new ModItemModels(generators, skippedAutoBlockModels).createModels();
    }

    public void createModels() {

    }
}
