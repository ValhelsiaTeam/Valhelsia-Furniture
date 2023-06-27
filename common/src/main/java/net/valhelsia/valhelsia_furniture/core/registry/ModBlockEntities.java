package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.valhelsia.valhelsia_core.api.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.api.registry.helper.DefaultRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.entity.DeskDrawerBlockEntity;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-25
 */
public class ModBlockEntities implements RegistryClass {

    public static final DefaultRegistryHelper<BlockEntityType<?>> HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(Registries.BLOCK_ENTITY_TYPE);

    public static final RegistryEntry<BlockEntityType<DeskDrawerBlockEntity>> DESK_DRAWER = HELPER.register("desk_drawer", () -> BlockEntityType.Builder.of(DeskDrawerBlockEntity::new, ModBlocks.OAK_DESK_DRAWER.get(), ModBlocks.BIRCH_DESK_DRAWER.get(), ModBlocks.SPRUCE_DESK_DRAWER.get(), ModBlocks.JUNGLE_DESK_DRAWER.get(), ModBlocks.ACACIA_DESK_DRAWER.get(), ModBlocks.DARK_OAK_DESK_DRAWER.get(), ModBlocks.MANGROVE_DESK_DRAWER.get(), ModBlocks.CRIMSON_DESK_DRAWER.get(), ModBlocks.WARPED_DESK_DRAWER.get()).build(null));

}
