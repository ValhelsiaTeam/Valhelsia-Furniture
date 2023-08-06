package net.valhelsia.valhelsia_furniture.client;

import net.valhelsia.valhelsia_core.api.client.ClientSetupHelper;
import net.valhelsia.valhelsia_furniture.client.renderer.SeatRenderer;
import net.valhelsia.valhelsia_furniture.core.registry.ModEntities;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-21
 */
public class ClientSetup {

    public ClientSetup(ClientSetupHelper helper) {
        helper.registerEntityRenderer(ModEntities.SEAT, SeatRenderer::new);
    }
}
