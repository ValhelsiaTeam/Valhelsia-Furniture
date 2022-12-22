package net.valhelsia.valhelsia_furniture.client.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.valhelsia.valhelsia_furniture.client.renderer.SeatRenderer;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;

/**
 * Entity Renderer Events <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.client.event.EntityRendererEvents
 *
 * @author Valhelsia Team
 * @since 2022-01-22
 */
public class EntityRendererEvents {

    @SubscribeEvent
    public void onRegisterRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SEAT.get(), SeatRenderer::new);
    }
}
