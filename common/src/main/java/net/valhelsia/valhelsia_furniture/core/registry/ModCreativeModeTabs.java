package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.valhelsia.valhelsia_core.api.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.api.registry.helper.DefaultRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-15
 */
public class ModCreativeModeTabs implements RegistryClass {

    public static final DefaultRegistryHelper<CreativeModeTab> HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(Registries.CREATIVE_MODE_TAB);

    public static final RegistryEntry<CreativeModeTab> MAIN = HELPER.register("main", () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 1)
            .icon(() -> new ItemStack(ModBlocks.HAY_OAK_CHAIR.get()))
            .title(Component.translatable("itemGroup.valhelsia_furniture"))
            .displayItems((itemDisplayParameters, output) -> {
                ValhelsiaFurniture.REGISTRY_MANAGER.getItemHelper().getRegistryEntries().forEach(entry -> {
                    output.accept(entry.get());
                });
            })
            .build()
    );

}
