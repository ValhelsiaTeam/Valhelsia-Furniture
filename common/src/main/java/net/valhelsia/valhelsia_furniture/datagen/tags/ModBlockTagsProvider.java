package net.valhelsia.valhelsia_furniture.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.valhelsia.valhelsia_core.api.datagen.tags.ValhelsiaBlockTagsProvider;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-07-19
 */
public class ModBlockTagsProvider extends ValhelsiaBlockTagsProvider {

    public ModBlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.blockTag(ModTags.Blocks.OAK_TABLES).addEntrySet(ModBlocks.COLORED_OAK_TABLES).add(ModBlocks.OAK_TABLE);
        this.blockTag(ModTags.Blocks.SPRUCE_TABLES).addEntrySet(ModBlocks.COLORED_SPRUCE_TABLES).add(ModBlocks.SPRUCE_TABLE);
        this.blockTag(ModTags.Blocks.BIRCH_TABLES).addEntrySet(ModBlocks.COLORED_BIRCH_TABLES).add(ModBlocks.BIRCH_TABLE);
        this.blockTag(ModTags.Blocks.JUNGLE_TABLES).addEntrySet(ModBlocks.COLORED_JUNGLE_TABLES).add(ModBlocks.JUNGLE_TABLE);
        this.blockTag(ModTags.Blocks.ACACIA_TABLES).addEntrySet(ModBlocks.COLORED_ACACIA_TABLES).add(ModBlocks.ACACIA_TABLE);
        this.blockTag(ModTags.Blocks.CHERRY_TABLES).addEntrySet(ModBlocks.COLORED_CHERRY_TABLES).add(ModBlocks.CHERRY_TABLE);
        this.blockTag(ModTags.Blocks.DARK_OAK_TABLES).addEntrySet(ModBlocks.COLORED_DARK_OAK_TABLES).add(ModBlocks.DARK_OAK_TABLE);
        this.blockTag(ModTags.Blocks.MANGROVE_TABLES).addEntrySet(ModBlocks.COLORED_MANGROVE_TABLES).add(ModBlocks.MANGROVE_TABLE);
        this.blockTag(ModTags.Blocks.CRIMSON_TABLES).addEntrySet(ModBlocks.COLORED_CRIMSON_TABLES).add(ModBlocks.CRIMSON_TABLE);
        this.blockTag(ModTags.Blocks.WARPED_TABLES).addEntrySet(ModBlocks.COLORED_WARPED_TABLES).add(ModBlocks.WARPED_TABLE);
        this.blockTag(ModTags.Blocks.TABLES).addTags(ModTags.Blocks.OAK_TABLES, ModTags.Blocks.SPRUCE_TABLES, ModTags.Blocks.BIRCH_TABLES, ModTags.Blocks.JUNGLE_TABLES, ModTags.Blocks.ACACIA_TABLES, ModTags.Blocks.DARK_OAK_TABLES, ModTags.Blocks.MANGROVE_TABLES, ModTags.Blocks.CRIMSON_TABLES, ModTags.Blocks.WARPED_TABLES);

        this.blockTag(ModTags.Blocks.OAK_CHAIRS).addEntrySet(ModBlocks.WOOL_OAK_CHAIRS).add(ModBlocks.OAK_CHAIR, ModBlocks.HAY_OAK_CHAIR);
        this.blockTag(ModTags.Blocks.SPRUCE_CHAIRS).addEntrySet(ModBlocks.WOOL_SPRUCE_CHAIRS).add(ModBlocks.SPRUCE_CHAIR, ModBlocks.HAY_SPRUCE_CHAIR);
        this.blockTag(ModTags.Blocks.BIRCH_CHAIRS).addEntrySet(ModBlocks.WOOL_BIRCH_CHAIRS).add(ModBlocks.BIRCH_CHAIR, ModBlocks.HAY_BIRCH_CHAIR);
        this.blockTag(ModTags.Blocks.JUNGLE_CHAIRS).addEntrySet(ModBlocks.WOOL_JUNGLE_CHAIRS).add(ModBlocks.JUNGLE_CHAIR, ModBlocks.HAY_JUNGLE_CHAIR);
        this.blockTag(ModTags.Blocks.ACACIA_CHAIRS).addEntrySet(ModBlocks.WOOL_ACACIA_CHAIRS).add(ModBlocks.ACACIA_CHAIR, ModBlocks.HAY_ACACIA_CHAIR);
        this.blockTag(ModTags.Blocks.CHERRY_CHAIRS).addEntrySet(ModBlocks.WOOL_CHERRY_CHAIRS).add(ModBlocks.CHERRY_CHAIR, ModBlocks.HAY_CHERRY_CHAIR);

        this.blockTag(ModTags.Blocks.DARK_OAK_CHAIRS).addEntrySet(ModBlocks.WOOL_DARK_OAK_CHAIRS).add(ModBlocks.DARK_OAK_CHAIR, ModBlocks.HAY_DARK_OAK_CHAIR);
        this.blockTag(ModTags.Blocks.MANGROVE_CHAIRS).addEntrySet(ModBlocks.WOOL_MANGROVE_CHAIRS).add(ModBlocks.MANGROVE_CHAIR, ModBlocks.HAY_MANGROVE_CHAIR);
        this.blockTag(ModTags.Blocks.CRIMSON_CHAIRS).addEntrySet(ModBlocks.WOOL_CRIMSON_CHAIRS).add(ModBlocks.CRIMSON_CHAIR, ModBlocks.HAY_CRIMSON_CHAIR);
        this.blockTag(ModTags.Blocks.WARPED_CHAIRS).addEntrySet(ModBlocks.WOOL_WARPED_CHAIRS).add(ModBlocks.WARPED_CHAIR, ModBlocks.HAY_WARPED_CHAIR);
        this.blockTag(ModTags.Blocks.CHAIRS).addTags(ModTags.Blocks.OAK_CHAIRS, ModTags.Blocks.SPRUCE_CHAIRS, ModTags.Blocks.BIRCH_CHAIRS, ModTags.Blocks.JUNGLE_CHAIRS, ModTags.Blocks.ACACIA_CHAIRS, ModTags.Blocks.DARK_OAK_CHAIRS, ModTags.Blocks.MANGROVE_CHAIRS, ModTags.Blocks.CRIMSON_CHAIRS, ModTags.Blocks.WARPED_CHAIRS);

        this.blockTag(ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_MANGROVE_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_CHAIRS).addTags(ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS, ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS, ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS, ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS, ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS, ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS, ModTags.Blocks.UPHOLSTERED_MANGROVE_CHAIRS, ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS, ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS);

        this.blockTag(ModTags.Blocks.STOOLS).add(ModBlocks.OAK_STOOL, ModBlocks.SPRUCE_STOOL, ModBlocks.BIRCH_STOOL, ModBlocks.JUNGLE_STOOL, ModBlocks.ACACIA_STOOL, ModBlocks.CHERRY_STOOL, ModBlocks.DARK_OAK_STOOL, ModBlocks.MANGROVE_STOOL, ModBlocks.CRIMSON_STOOL, ModBlocks.WARPED_STOOL);

        this.blockTag(ModTags.Blocks.UPHOLSTERED_OAK_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_CHERRY_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_CHERRY_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_MANGROVE_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS).addEntrySet(ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS);
        this.blockTag(ModTags.Blocks.UPHOLSTERED_STOOLS).addTags(ModTags.Blocks.UPHOLSTERED_OAK_STOOLS, ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS, ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS, ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS, ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS, ModTags.Blocks.UPHOLSTERED_CHERRY_STOOLS, ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS, ModTags.Blocks.UPHOLSTERED_MANGROVE_STOOLS, ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS, ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS);

        this.blockTag(ModTags.Blocks.OAK_DESKS).add(ModBlocks.OAK_DESK, ModBlocks.OAK_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.SPRUCE_DESKS).add(ModBlocks.SPRUCE_DESK, ModBlocks.SPRUCE_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.BIRCH_DESKS).add(ModBlocks.BIRCH_DESK, ModBlocks.BIRCH_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.JUNGLE_DESKS).add(ModBlocks.JUNGLE_DESK, ModBlocks.JUNGLE_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.ACACIA_DESKS).add(ModBlocks.ACACIA_DESK, ModBlocks.ACACIA_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.CHERRY_DESKS).add(ModBlocks.CHERRY_DESK, ModBlocks.CHERRY_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.DARK_OAK_DESKS).add(ModBlocks.DARK_OAK_DESK, ModBlocks.DARK_OAK_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.MANGROVE_DESKS).add(ModBlocks.MANGROVE_DESK, ModBlocks.MANGROVE_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.CRIMSON_DESKS).add(ModBlocks.CRIMSON_DESK, ModBlocks.CRIMSON_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.WARPED_DESKS).add(ModBlocks.WARPED_DESK, ModBlocks.WARPED_DESK_DRAWER);
        this.blockTag(ModTags.Blocks.DESKS).addTag(ModTags.Blocks.OAK_DESKS).addTag(ModTags.Blocks.SPRUCE_DESKS).addTag(ModTags.Blocks.BIRCH_DESKS).addTag(ModTags.Blocks.JUNGLE_DESKS).addTag(ModTags.Blocks.ACACIA_DESKS).addTag(ModTags.Blocks.CHERRY_DESKS).addTag(ModTags.Blocks.DARK_OAK_DESKS).addTag(ModTags.Blocks.MANGROVE_DESKS).addTag(ModTags.Blocks.CRIMSON_DESKS).addTag(ModTags.Blocks.WARPED_DESKS);
        ModBlocks.FABRIC_DESK_LAMPS.values().forEach(registryObject -> this.blockTag(ModTags.Blocks.FABRIC_DESK_LAMPS).add(registryObject));
        this.blockTag(ModTags.Blocks.CURTAINS).addEntrySet(ModBlocks.CLOSED_CURTAINS).addEntrySet(ModBlocks.OPEN_CURTAINS);

        this.blockTag(BlockTags.MINEABLE_WITH_AXE)
                .addTags(ModTags.Blocks.TABLES, ModTags.Blocks.CHAIRS, ModTags.Blocks.UPHOLSTERED_CHAIRS, ModTags.Blocks.STOOLS, ModTags.Blocks.UPHOLSTERED_STOOLS, ModTags.Blocks.DESKS, ModTags.Blocks.FABRIC_DESK_LAMPS);
    }
}
