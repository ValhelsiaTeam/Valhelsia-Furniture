package net.valhelsia.valhelsia_furniture.forge.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.datagen.ValhelsiaBlockLootTables;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.OpenCurtainBlock;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-07-22
 */
public class ModBlockLootTables extends ValhelsiaBlockLootTables {

    public ModBlockLootTables(Set<Item> explosionResistant, FeatureFlagSet flagSet, HolderLookup.Provider lookupProvider) {
        super(explosionResistant, flagSet, lookupProvider, ValhelsiaFurniture.REGISTRY_MANAGER);
    }

    @Override
    protected void generate() {
        ModBlocks.HELPER.getRegistryEntries().forEach(registryEntry -> {
            if (!(registryEntry.get() instanceof OpenCurtainBlock)) {
                this.registerDropSelfLootTable(registryEntry.get());
            }
        });
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        this.generate();
        HashSet<ResourceKey<LootTable>> set = new HashSet<>();
        for (RegistryEntry<Block, ? extends Block> entry : ModBlocks.HELPER.getRegistryEntries()) {
            ResourceKey<LootTable> resourceKey;
            if (!entry.get().isEnabled(this.enabledFeatures) || (resourceKey = entry.get().getLootTable()) == BuiltInLootTables.EMPTY || !set.add(resourceKey)) continue;
            LootTable.Builder builder = this.map.remove(resourceKey);
            if (builder == null) {
                throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourceKey, BuiltInRegistries.BLOCK.getKey(entry.get())));
            }
            biConsumer.accept(resourceKey, builder);
        }
        if (!this.map.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }
}
