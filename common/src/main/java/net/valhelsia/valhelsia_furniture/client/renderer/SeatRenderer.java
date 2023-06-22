package net.valhelsia.valhelsia_furniture.client.renderer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Seat Renderer <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.client.renderer.SeatRenderer
 *
 * @author Valhelsia Team
 * @since 2022-01-22
 */
public class SeatRenderer extends EntityRenderer<SeatEntity> {

    public SeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull SeatEntity entity) {
        return null;
    }
}
