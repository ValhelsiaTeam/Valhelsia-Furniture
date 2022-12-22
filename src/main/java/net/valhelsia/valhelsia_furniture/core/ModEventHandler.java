package net.valhelsia.valhelsia_furniture.core;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.valhelsia.valhelsia_core.core.ValhelsiaMod;
import net.valhelsia.valhelsia_furniture.client.event.EntityRendererEvents;
import net.valhelsia.valhelsia_furniture.common.event.CreativeModeTabEvents;

/**
 * @author Valhelsia Team
 * @since 2022-12-22
 */
public class ModEventHandler extends ValhelsiaMod.EventHandler {

    @Override
    public void registerModEvents(IEventBus eventBus) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            eventBus.register(new EntityRendererEvents());
        }
        eventBus.register(new CreativeModeTabEvents());
    }

    @Override
    public void registerForgeEvents(IEventBus eventBus) {

    }
}
