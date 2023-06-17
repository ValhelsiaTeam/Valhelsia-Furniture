package net.valhelsia.valhelsia_furniture;

import net.valhelsia.valhelsia_core.ModDefinition;
import net.valhelsia.valhelsia_core.api.registry.RegistryManager;
import net.valhelsia.valhelsia_furniture.core.registry.ModRegistryCollector;

public class ValhelsiaFurniture {
	public static final String MOD_ID = "valhelsia_furniture";

	public static final RegistryManager REGISTRY_MANAGER = new RegistryManager(new ModRegistryCollector(ValhelsiaFurniture.MOD_ID));

	public static void init() {
		ModDefinition.of(ValhelsiaFurniture.MOD_ID).withRegistryManager(ValhelsiaFurniture.REGISTRY_MANAGER).create();
	}
}