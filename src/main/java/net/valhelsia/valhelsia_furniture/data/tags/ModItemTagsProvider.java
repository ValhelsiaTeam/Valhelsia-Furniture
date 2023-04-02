package net.valhelsia.valhelsia_furniture.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

/**
 * Mod Item Tags Provider <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.data.tags.ModItemTagsProvider
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-15
 */
public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, ValhelsiaFurniture.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(ModTags.Blocks.OAK_DESKS, ModTags.Items.OAK_DESKS);
        this.copy(ModTags.Blocks.SPRUCE_DESKS, ModTags.Items.SPRUCE_DESKS);
        this.copy(ModTags.Blocks.BIRCH_DESKS, ModTags.Items.BIRCH_DESKS);
        this.copy(ModTags.Blocks.JUNGLE_DESKS, ModTags.Items.JUNGLE_DESKS);
        this.copy(ModTags.Blocks.ACACIA_DESKS, ModTags.Items.ACACIA_DESKS );
        this.copy(ModTags.Blocks.DARK_OAK_DESKS, ModTags.Items.DARK_OAK_DESKS);
        this.copy(ModTags.Blocks.MANGROVE_DESKS, ModTags.Items.MANGROVE_DESKS);
        this.copy(ModTags.Blocks.CRIMSON_DESKS, ModTags.Items.CRIMSON_DESKS);
        this.copy(ModTags.Blocks.WARPED_DESKS, ModTags.Items.WARPED_DESKS);
        this.copy(ModTags.Blocks.DESKS, ModTags.Items.DESKS);
        this.copy(ModTags.Blocks.FABRIC_DESK_LAMPS, ModTags.Items.FABRIC_DESK_LAMPS);
    }
}
