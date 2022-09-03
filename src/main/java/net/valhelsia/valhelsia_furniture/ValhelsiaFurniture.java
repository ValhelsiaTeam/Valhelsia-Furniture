package net.valhelsia.valhelsia_furniture;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.valhelsia.valhelsia_core.core.registry.RegistryManager;
import net.valhelsia.valhelsia_core.core.registry.helper.RegistryHelper;
import net.valhelsia.valhelsia_core.core.registry.helper.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.client.ClientSetup;
import net.valhelsia.valhelsia_furniture.common.item.FurnitureCreativeModeTab;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlockEntities;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurniture {

    public static final String MOD_ID = "valhelsia_furniture";

    private static final Logger LOGGER = LogManager.getLogger();

    public static final FurnitureCreativeModeTab CREATIVE_MODE_TAB = new FurnitureCreativeModeTab();

    public static final RegistryManager REGISTRY_MANAGER = RegistryManager.builder(MOD_ID)
            .addHelper(ForgeRegistries.Keys.BLOCKS, new BlockRegistryHelper(CREATIVE_MODE_TAB, ModBlocks::new))
            .addHelper(ForgeRegistries.Keys.ITEMS, new RegistryHelper<>())
            .addHelper(ForgeRegistries.Keys.ENTITY_TYPES, new RegistryHelper<>(ModEntities::new))
            .addHelper(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, new RegistryHelper<>(ModBlockEntities::new))
            .create();

    public ValhelsiaFurniture() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSetup::new);

        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_MANAGER.register(eventBus);
    }
}
