package net.valhelsia.valhelsia_furniture.datagen.tags

import net.minecraft.core.HolderLookup
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.tag.DataForgeItemTagsProvider
import net.valhelsia.valhelsia_furniture.core.registry.ModTags

class ModItemTagsProvider(context: DataProviderContext) : DataForgeItemTagsProvider(context) {
    override fun addTags(provider: HolderLookup.Provider) {
        copy(ModTags.Blocks.OAK_DESKS, ModTags.Items.OAK_DESKS)
        copy(ModTags.Blocks.SPRUCE_DESKS, ModTags.Items.SPRUCE_DESKS)
        copy(ModTags.Blocks.BIRCH_DESKS, ModTags.Items.BIRCH_DESKS)
        copy(ModTags.Blocks.JUNGLE_DESKS, ModTags.Items.JUNGLE_DESKS)
        copy(ModTags.Blocks.ACACIA_DESKS, ModTags.Items.ACACIA_DESKS)
        copy(ModTags.Blocks.CHERRY_DESKS, ModTags.Items.CHERRY_DESKS)
        copy(ModTags.Blocks.DARK_OAK_DESKS, ModTags.Items.DARK_OAK_DESKS)
        copy(ModTags.Blocks.MANGROVE_DESKS, ModTags.Items.MANGROVE_DESKS)
        copy(ModTags.Blocks.CRIMSON_DESKS, ModTags.Items.CRIMSON_DESKS)
        copy(ModTags.Blocks.WARPED_DESKS, ModTags.Items.WARPED_DESKS)
        copy(ModTags.Blocks.DESKS, ModTags.Items.DESKS)
        copy(ModTags.Blocks.FABRIC_DESK_LAMPS, ModTags.Items.FABRIC_DESK_LAMPS)
    }
}