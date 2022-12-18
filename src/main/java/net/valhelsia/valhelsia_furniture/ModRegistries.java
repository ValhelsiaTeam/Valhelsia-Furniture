package net.valhelsia.valhelsia_furniture;

import net.minecraft.core.registries.Registries;
import net.valhelsia.valhelsia_core.core.registry.RegistryCollector;
import net.valhelsia.valhelsia_core.core.registry.helper.block.BlockRegistryHelper;
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
        this.add(Registries.BLOCK, BlockRegistryHelper::new, ModBlocks::new);
        this.add(Registries.ITEM);
        this.add(Registries.ENTITY_TYPE, ModEntities::new);
        this.add(Registries.BLOCK_ENTITY_TYPE, ModBlockEntities::new);
    }
}
