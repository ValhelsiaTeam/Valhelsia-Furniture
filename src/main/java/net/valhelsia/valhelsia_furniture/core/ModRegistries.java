package net.valhelsia.valhelsia_furniture.core;

import net.minecraft.core.registries.Registries;
import net.valhelsia.valhelsia_core.core.registry.RegistryCollector;
import net.valhelsia.valhelsia_core.core.registry.helper.EntityRegistryHelper;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlockEntities;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;

/**
 * @author Valhelsia Team
 * @since 2022-12-18
 */
public class ModRegistries extends RegistryCollector {

    public ModRegistries(String modId) {
        super(modId);
    }

    @Override
    protected void collect() {
        this.addBlockHelper(ModBlocks::new);
        this.addItemHelper();
        this.addMappedHelper(Registries.ENTITY_TYPE, EntityRegistryHelper::new, ModEntities::new);
        this.addMappedHelper(Registries.BLOCK_ENTITY_TYPE, ModBlockEntities::new);
    }
}
