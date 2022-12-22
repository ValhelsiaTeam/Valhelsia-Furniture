package net.valhelsia.valhelsia_furniture.data.loot;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockLootTables;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.OpenCurtainBlock;

import java.util.Set;

/**
 * @author Valhelsia Team
 * @since 2022-10-05
 */
public class ModBlockLootTables extends ValhelsiaBlockLootTables {

    public ModBlockLootTables(Set<Item> explosionResistant, FeatureFlagSet flagSet) {
        super(explosionResistant, flagSet, ValhelsiaFurniture.REGISTRY_MANAGER);
    }

    @Override
    protected void generate() {
        this.getRemainingBlocks().removeIf(blockRegistryObject -> {
            return blockRegistryObject instanceof OpenCurtainBlock;
        });

        forEach(this::registerDropSelfLootTable);
    }
}
