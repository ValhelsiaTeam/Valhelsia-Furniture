package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.api.common.registry.helper.EntityRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-18
 */
public class ModEntities implements RegistryClass {

    public static final EntityRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(Registries.ENTITY_TYPE);

    public static final RegistryEntry<EntityType<SeatEntity>> SEAT = HELPER.register("seat", EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));
}
