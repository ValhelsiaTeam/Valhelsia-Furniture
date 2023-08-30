package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.registries.Registries;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryCollector;
import net.valhelsia.valhelsia_core.api.common.registry.helper.EntityRegistryHelper;

/**
 * @author Valhelsia Team
 * @since 2023-06-11
 */
public class ModRegistryCollector extends RegistryCollector {

    public ModRegistryCollector(String modId) {
        super(modId);
    }

    @Override
    protected void collectHelpers() {
        this.addBlockHelper(ModBlocks.class);
        this.addItemHelper();
        this.addMappedHelper(Registries.CREATIVE_MODE_TAB, ModCreativeModeTabs.class);
        this.addMappedHelper(Registries.ENTITY_TYPE, EntityRegistryHelper::new, ModEntities.class);
        this.addMappedHelper(Registries.BLOCK_ENTITY_TYPE, ModBlockEntities.class);
    }
}
