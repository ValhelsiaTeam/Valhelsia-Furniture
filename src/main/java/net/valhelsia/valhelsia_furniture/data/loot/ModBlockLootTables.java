package net.valhelsia.valhelsia_furniture.data.loot;

import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockLootTables;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

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
        forEach(this::registerDropSelfLootTable);
    }
}
