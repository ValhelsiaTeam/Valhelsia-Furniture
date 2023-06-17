package net.valhelsia.valhelsia_furniture.fabric;

import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.fabricmc.api.ModInitializer;

public class ValhelsiaFurnitureFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ValhelsiaFurniture.init();
    }
}