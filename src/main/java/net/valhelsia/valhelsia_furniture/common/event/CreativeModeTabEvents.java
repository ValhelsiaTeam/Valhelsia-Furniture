package net.valhelsia.valhelsia_furniture.common.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

/**
 * @author Valhelsia Team
 * @since 2022-12-22
 */
public class CreativeModeTabEvents {

    @SubscribeEvent
    public void registerTabs(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(ValhelsiaFurniture.MOD_ID, "main"), builder -> builder
                .icon(() -> new ItemStack(ModBlocks.HAY_OAK_CHAIR.get()))
                .title(Component.translatable("itemGroup.valhelsia_furniture"))
                .displayItems((parameters, output) -> {
                    ValhelsiaFurniture.REGISTRY_MANAGER.getItemHelper().getRegistryObjects().forEach(registryObject -> {
                        output.accept(registryObject.get());
                    });
                })
        );
    }
}
