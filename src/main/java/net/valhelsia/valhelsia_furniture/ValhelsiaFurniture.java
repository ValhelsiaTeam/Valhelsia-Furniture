package net.valhelsia.valhelsia_furniture;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valhelsia.valhelsia_core.core.ValhelsiaMod;
import net.valhelsia.valhelsia_core.core.registry.RegistryManager;
import net.valhelsia.valhelsia_furniture.client.ClientSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ValhelsiaFurniture.MOD_ID)
public class ValhelsiaFurniture extends ValhelsiaMod {

    public static final String MOD_ID = "valhelsia_furniture";

    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryManager REGISTRY_MANAGER = new RegistryManager(new ModRegistries(ValhelsiaFurniture.MOD_ID), null);

    public ValhelsiaFurniture() {
        super(ValhelsiaFurniture.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus(), ValhelsiaFurniture.REGISTRY_MANAGER);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSetup::new);
    }
}
