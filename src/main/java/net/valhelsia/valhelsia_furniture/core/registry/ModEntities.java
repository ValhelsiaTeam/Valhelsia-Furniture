package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.RegistryClass;
import net.valhelsia.valhelsia_core.core.registry.helper.EntityRegistryHelper;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

/**
 * Mod Entities <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModEntities
 *
 * @author Valhelsia Team
 * @since 2022-01-21
 */
public class ModEntities implements RegistryClass {

    public static final EntityRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getMappedHelper(ForgeRegistries.Keys.ENTITY_TYPES);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = HELPER.register("seat", EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));
}
