package net.valhelsia.valhelsia_furniture.client.renderer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

import javax.annotation.Nonnull;

/**
 * Seat Renderer <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.client.renderer.SeatRenderer
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-22
 */
public class SeatRenderer extends EntityRenderer<SeatEntity> {

    public SeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull SeatEntity entity) {
        return null;
    }
}
