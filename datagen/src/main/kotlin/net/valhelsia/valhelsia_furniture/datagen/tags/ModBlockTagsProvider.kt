package net.valhelsia.valhelsia_furniture.datagen.tags

import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.valhelsia.dataforge.DataProviderContext
import net.valhelsia.dataforge.tag.DataForgeBlockTagsProvider
import net.valhelsia.valhelsia_core.api.common.registry.helper.block.BlockEntrySet
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
import net.valhelsia.valhelsia_furniture.core.registry.ModTags

class ModBlockTagsProvider(context: DataProviderContext.Server) : DataForgeBlockTagsProvider(context) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ModTags.Blocks.OAK_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_OAK_TABLES.key())
        tag(ModTags.Blocks.SPRUCE_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_SPRUCE_TABLES.key())
        tag(ModTags.Blocks.BIRCH_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_BIRCH_TABLES.key())
        tag(ModTags.Blocks.JUNGLE_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_JUNGLE_TABLES.key())
        tag(ModTags.Blocks.ACACIA_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_ACACIA_TABLES.key())
        tag(ModTags.Blocks.CHERRY_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_CHERRY_TABLES.key())
        tag(ModTags.Blocks.DARK_OAK_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_DARK_OAK_TABLES.key())
        tag(ModTags.Blocks.MANGROVE_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_MANGROVE_TABLES.key())
        tag(ModTags.Blocks.CRIMSON_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_CRIMSON_TABLES.key())
        tag(ModTags.Blocks.WARPED_TABLES).add(ModBlocks.OAK_TABLE.key()).add(*ModBlocks.COLORED_WARPED_TABLES.key())
        tag(ModTags.Blocks.TABLES).addTags(
            ModTags.Blocks.OAK_TABLES,
            ModTags.Blocks.SPRUCE_TABLES,
            ModTags.Blocks.BIRCH_TABLES,
            ModTags.Blocks.JUNGLE_TABLES,
            ModTags.Blocks.ACACIA_TABLES,
            ModTags.Blocks.CHERRY_TABLES,
            ModTags.Blocks.DARK_OAK_TABLES,
            ModTags.Blocks.MANGROVE_TABLES,
            ModTags.Blocks.CRIMSON_TABLES,
            ModTags.Blocks.WARPED_TABLES
        )

        tag(ModTags.Blocks.OAK_CHAIRS)
            .add(*ModBlocks.WOOL_OAK_CHAIRS.key())
            .add(ModBlocks.OAK_CHAIR.key(), ModBlocks.HAY_OAK_CHAIR.key())
        tag(ModTags.Blocks.SPRUCE_CHAIRS)
            .add(*ModBlocks.WOOL_SPRUCE_CHAIRS.key())
            .add(ModBlocks.SPRUCE_CHAIR.key(), ModBlocks.HAY_SPRUCE_CHAIR.key())
        tag(ModTags.Blocks.BIRCH_CHAIRS)
            .add(*ModBlocks.WOOL_BIRCH_CHAIRS.key())
            .add(ModBlocks.BIRCH_CHAIR.key(), ModBlocks.HAY_BIRCH_CHAIR.key())
        tag(ModTags.Blocks.JUNGLE_CHAIRS)
            .add(*ModBlocks.WOOL_JUNGLE_CHAIRS.key())
            .add(ModBlocks.JUNGLE_CHAIR.key(), ModBlocks.HAY_JUNGLE_CHAIR.key())
        tag(ModTags.Blocks.ACACIA_CHAIRS)
            .add(*ModBlocks.WOOL_ACACIA_CHAIRS.key())
            .add(ModBlocks.ACACIA_CHAIR.key(), ModBlocks.HAY_ACACIA_CHAIR.key())
        tag(ModTags.Blocks.CHERRY_CHAIRS)
            .add(*ModBlocks.WOOL_CHERRY_CHAIRS.key())
            .add(ModBlocks.CHERRY_CHAIR.key(), ModBlocks.HAY_CHERRY_CHAIR.key())
        tag(ModTags.Blocks.DARK_OAK_CHAIRS)
            .add(*ModBlocks.WOOL_DARK_OAK_CHAIRS.key())
            .add(ModBlocks.DARK_OAK_CHAIR.key(), ModBlocks.HAY_DARK_OAK_CHAIR.key())
        tag(ModTags.Blocks.MANGROVE_CHAIRS)
            .add(*ModBlocks.WOOL_MANGROVE_CHAIRS.key())
            .add(ModBlocks.MANGROVE_CHAIR.key(), ModBlocks.HAY_MANGROVE_CHAIR.key())
        tag(ModTags.Blocks.CRIMSON_CHAIRS)
            .add(*ModBlocks.WOOL_CRIMSON_CHAIRS.key())
            .add(ModBlocks.CRIMSON_CHAIR.key(), ModBlocks.HAY_CRIMSON_CHAIR.key())
        tag(ModTags.Blocks.WARPED_CHAIRS)
            .add(*ModBlocks.WOOL_WARPED_CHAIRS.key())
            .add(ModBlocks.WARPED_CHAIR.key(), ModBlocks.HAY_WARPED_CHAIR.key())
        tag(ModTags.Blocks.CHAIRS).addTags(
            ModTags.Blocks.OAK_CHAIRS,
            ModTags.Blocks.SPRUCE_CHAIRS,
            ModTags.Blocks.BIRCH_CHAIRS,
            ModTags.Blocks.JUNGLE_CHAIRS,
            ModTags.Blocks.ACACIA_CHAIRS,
            ModTags.Blocks.CHERRY_CHAIRS,
            ModTags.Blocks.DARK_OAK_CHAIRS,
            ModTags.Blocks.MANGROVE_CHAIRS,
            ModTags.Blocks.CRIMSON_CHAIRS,
            ModTags.Blocks.WARPED_CHAIRS
        )

        tag(ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_MANGROVE_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS).add(*ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS.key())
        tag(ModTags.Blocks.UPHOLSTERED_CHAIRS).addTags(
            ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_MANGROVE_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS,
            ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS
        )

        tag(ModTags.Blocks.STOOLS).add(
            ModBlocks.OAK_STOOL.key(),
            ModBlocks.SPRUCE_STOOL.key(),
            ModBlocks.BIRCH_STOOL.key(),
            ModBlocks.JUNGLE_STOOL.key(),
            ModBlocks.ACACIA_STOOL.key(),
            ModBlocks.CHERRY_STOOL.key(),
            ModBlocks.DARK_OAK_STOOL.key(),
            ModBlocks.MANGROVE_STOOL.key(),
            ModBlocks.CRIMSON_STOOL.key(),
            ModBlocks.WARPED_STOOL.key()
        )

        tag(ModTags.Blocks.UPHOLSTERED_OAK_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_CHERRY_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_CHERRY_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_MANGROVE_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS).add(*ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS.key())
        tag(ModTags.Blocks.UPHOLSTERED_STOOLS).addTags(
            ModTags.Blocks.UPHOLSTERED_OAK_STOOLS,
            ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS,
            ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS,
            ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS,
            ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS,
            ModTags.Blocks.UPHOLSTERED_CHERRY_STOOLS,
            ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS,
            ModTags.Blocks.UPHOLSTERED_MANGROVE_STOOLS,
            ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS,
            ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS
        )

        tag(ModTags.Blocks.OAK_DESKS).add(ModBlocks.OAK_DESK.key(), ModBlocks.OAK_DESK_DRAWER.key())
        tag(ModTags.Blocks.SPRUCE_DESKS).add(ModBlocks.SPRUCE_DESK.key(), ModBlocks.SPRUCE_DESK_DRAWER.key())
        tag(ModTags.Blocks.BIRCH_DESKS).add(ModBlocks.BIRCH_DESK.key(), ModBlocks.BIRCH_DESK_DRAWER.key())
        tag(ModTags.Blocks.JUNGLE_DESKS).add(ModBlocks.JUNGLE_DESK.key(), ModBlocks.JUNGLE_DESK_DRAWER.key())
        tag(ModTags.Blocks.ACACIA_DESKS).add(ModBlocks.ACACIA_DESK.key(), ModBlocks.ACACIA_DESK_DRAWER.key())
        tag(ModTags.Blocks.CHERRY_DESKS).add(ModBlocks.CHERRY_DESK.key(), ModBlocks.CHERRY_DESK_DRAWER.key())
        tag(ModTags.Blocks.DARK_OAK_DESKS).add(ModBlocks.DARK_OAK_DESK.key(), ModBlocks.DARK_OAK_DESK_DRAWER.key())
        tag(ModTags.Blocks.MANGROVE_DESKS).add(ModBlocks.MANGROVE_DESK.key(), ModBlocks.MANGROVE_DESK_DRAWER.key())
        tag(ModTags.Blocks.CRIMSON_DESKS).add(ModBlocks.CRIMSON_DESK.key(), ModBlocks.CRIMSON_DESK_DRAWER.key())
        tag(ModTags.Blocks.WARPED_DESKS).add(ModBlocks.WARPED_DESK.key(), ModBlocks.WARPED_DESK_DRAWER.key())
        tag(ModTags.Blocks.DESKS).addTags(
            ModTags.Blocks.OAK_DESKS,
            ModTags.Blocks.SPRUCE_DESKS,
            ModTags.Blocks.BIRCH_DESKS, ModTags.Blocks.JUNGLE_DESKS, ModTags.Blocks.ACACIA_DESKS,
            ModTags.Blocks.CHERRY_DESKS,
            ModTags.Blocks.DARK_OAK_DESKS,
            ModTags.Blocks.MANGROVE_DESKS,
            ModTags.Blocks.CRIMSON_DESKS,
            ModTags.Blocks.WARPED_DESKS
        )
        tag(ModTags.Blocks.FABRIC_DESK_LAMPS).add(*ModBlocks.FABRIC_DESK_LAMPS.key())
        tag(ModTags.Blocks.CURTAINS).add(*ModBlocks.CLOSED_CURTAINS.key()).add(*ModBlocks.OPEN_CURTAINS.key())

        tag(BlockTags.MINEABLE_WITH_AXE).addTags(
            ModTags.Blocks.TABLES,
            ModTags.Blocks.CHAIRS,
            ModTags.Blocks.UPHOLSTERED_CHAIRS,
            ModTags.Blocks.STOOLS,
            ModTags.Blocks.UPHOLSTERED_STOOLS,
            ModTags.Blocks.DESKS,
            ModTags.Blocks.FABRIC_DESK_LAMPS
        )
    }

    fun BlockEntrySet<*, *>.key() = this.getEntries().map { it.key() }.toTypedArray()
}
