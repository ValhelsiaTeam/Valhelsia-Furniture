package net.valhelsia.valhelsia_furniture.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

import javax.annotation.Nullable;

/**
 * Mod Block Tags Provider <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.data.tags.ModBlockTagsProvider
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-15
 */
public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, ValhelsiaFurniture.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(ModTags.Blocks.OAK_DESKS).add(ModBlocks.OAK_DESK.get(), ModBlocks.OAK_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.SPRUCE_DESKS).add(ModBlocks.SPRUCE_DESK.get(), ModBlocks.SPRUCE_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.BIRCH_DESKS).add(ModBlocks.BIRCH_DESK.get(), ModBlocks.BIRCH_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.JUNGLE_DESKS).add(ModBlocks.JUNGLE_DESK.get(), ModBlocks.JUNGLE_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.ACACIA_DESKS).add(ModBlocks.ACACIA_DESK.get(), ModBlocks.ACACIA_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.DARK_OAK_DESKS).add(ModBlocks.DARK_OAK_DESK.get(), ModBlocks.DARK_OAK_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.CRIMSON_DESKS).add(ModBlocks.CRIMSON_DESK.get(), ModBlocks.CRIMSON_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.WARPED_DESKS).add(ModBlocks.WARPED_DESK.get(), ModBlocks.WARPED_DESK_DRAWER.get());
        this.tag(ModTags.Blocks.DESKS).addTag(ModTags.Blocks.OAK_DESKS).addTag(ModTags.Blocks.SPRUCE_DESKS).addTag(ModTags.Blocks.BIRCH_DESKS).addTag(ModTags.Blocks.JUNGLE_DESKS).addTag(ModTags.Blocks.ACACIA_DESKS).addTag(ModTags.Blocks.DARK_OAK_DESKS).addTag(ModTags.Blocks.CRIMSON_DESKS).addTag(ModTags.Blocks.WARPED_DESKS);
        ModBlocks.FABRIC_DESK_LAMPS.values().forEach(registryObject -> this.tag(ModTags.Blocks.FABRIC_DESK_LAMPS).add(registryObject.get()));
    }
}
