package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.EntityRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

/**
 * Mod Entities <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModEntities
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-21
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final EntityRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getEntityHelper();

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = HELPER.register("seat", EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));

}
