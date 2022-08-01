package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.core.registry.helper.RegistryHelper;
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

    public static final RegistryHelper<EntityType<?>> HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(ForgeRegistries.Keys.ENTITY_TYPES);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = register("seat", EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));

    public static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return HELPER.register(name, () -> builder.build(name));
    }
}
