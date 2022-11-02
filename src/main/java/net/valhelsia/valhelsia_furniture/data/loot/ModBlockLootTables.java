package net.valhelsia.valhelsia_furniture.data.loot;

import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockLootTables;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.OpenCurtainBlock;

/**
 * @author Valhelsia Team
 * @since 2022-10-05
 */
public class ModBlockLootTables extends ValhelsiaBlockLootTables {

    public ModBlockLootTables() {
        super(ValhelsiaFurniture.REGISTRY_MANAGER);
    }

    @Override
    public void addTables() {
        this.getRemainingBlocks().removeIf(blockRegistryObject -> {
            return blockRegistryObject.get() instanceof OpenCurtainBlock;
        });

        forEach(this::registerDropSelfLootTable);
    }
}
