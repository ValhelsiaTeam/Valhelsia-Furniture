package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.valhelsia.valhelsia_core.ValhelsiaCore;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.api.common.registry.helper.RegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-15
 */
public class ModCreativeModeTabs {

    public static final RegistryHelper<CreativeModeTab> HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getHelper(Registries.CREATIVE_MODE_TAB);

    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MAIN = HELPER.register("main", ValhelsiaCore.INSTANCE.createCreativeTab(builder -> {
                builder.icon(() -> new ItemStack(ModBlocks.HAY_OAK_CHAIR.get()))
                        .title(Component.translatable("itemGroup.valhelsia_furniture"))
                        .displayItems((_, output) -> {
                            ValhelsiaFurniture.REGISTRY_MANAGER.getItemHelper().getRegistryEntries().forEach(entry -> {
                                output.accept(entry.get());
                            });
                        });
            })
    );
}
