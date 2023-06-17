package net.valhelsia.valhelsia_furniture.datagen.model;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

import java.util.Optional;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-12
 */
public class ModModelTemplates {

    public static final ModelTemplate TABLE = create("template_table", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_N = create("template_table_n", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_E = create("template_table_e", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_S = create("template_table_s", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_W = create("template_table_w", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NE = create("template_table_ne", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NES = create("template_table_nes", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NESW = create("template_table_nesw", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NEW = create("template_table_new", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NS = create("template_table_ns", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NSW = create("template_table_nsw", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_NW = create("template_table_nw", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_SW = create("template_table_sw", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_ES = create("template_table_es", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_ESW = create("template_table_esw", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);
    public static final ModelTemplate TABLE_EW = create("template_table_ew", ModTextureSlots.TABLE, ModTextureSlots.CONNECTED_TABLE);

    public static ModelTemplate create(String name, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/" + name)), Optional.empty(), textureSlots);
    }
}
