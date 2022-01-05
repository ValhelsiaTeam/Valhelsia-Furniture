package net.valhelsia.valhelsia_furniture;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valhelsia.valhelsia_core.core.registry.RegistryManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurniture {

    public static final String MOD_ID = "valhelsia_furniture";

    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryManager REGISTRY_MANAGER = new RegistryManager.Builder(MOD_ID).addDefaultHelpers().build();

    public ValhelsiaFurniture() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_MANAGER.getBlockHelper().setDefaultGroup(CreativeModeTab.TAB_BUILDING_BLOCKS);

        REGISTRY_MANAGER.register(eventBus);
    }
}
