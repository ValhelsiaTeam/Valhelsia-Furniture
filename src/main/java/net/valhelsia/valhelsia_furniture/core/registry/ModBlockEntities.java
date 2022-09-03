package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.RegistryClass;
import net.valhelsia.valhelsia_core.core.registry.helper.RegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.entity.DeskDrawerBlockEntity;

/**
 * @author Valhelsia Team
 * @since 2022-09-03
 */
public class ModBlockEntities implements RegistryClass {

    public static final RegistryHelper<BlockEntityType<?>> HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES);

    public static final RegistryObject<BlockEntityType<DeskDrawerBlockEntity>> DESK_DRAWER = HELPER.register("desk_drawer", () -> BlockEntityType.Builder.of(DeskDrawerBlockEntity::new, ModBlocks.OAK_DESK_DRAWER.get(), ModBlocks.BIRCH_DESK_DRAWER.get(), ModBlocks.SPRUCE_DESK_DRAWER.get(), ModBlocks.JUNGLE_DESK_DRAWER.get(), ModBlocks.ACACIA_DESK_DRAWER.get(), ModBlocks.DARK_OAK_DESK_DRAWER.get(), ModBlocks.CRIMSON_DESK_DRAWER.get(), ModBlocks.WARPED_DESK_DRAWER.get()).build(null));
}
