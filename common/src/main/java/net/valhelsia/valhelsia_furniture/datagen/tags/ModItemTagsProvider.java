package net.valhelsia.valhelsia_furniture.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.valhelsia.valhelsia_core.api.datagen.tags.ValhelsiaItemTagsProvider;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-07-21
 */
public class ModItemTagsProvider extends ValhelsiaItemTagsProvider {

    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagLookup) {
        super(packOutput, lookupProvider, blockTagLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(ModTags.Blocks.OAK_DESKS, ModTags.Items.OAK_DESKS);
        this.copy(ModTags.Blocks.SPRUCE_DESKS, ModTags.Items.SPRUCE_DESKS);
        this.copy(ModTags.Blocks.BIRCH_DESKS, ModTags.Items.BIRCH_DESKS);
        this.copy(ModTags.Blocks.JUNGLE_DESKS, ModTags.Items.JUNGLE_DESKS);
        this.copy(ModTags.Blocks.ACACIA_DESKS, ModTags.Items.ACACIA_DESKS );
        this.copy(ModTags.Blocks.CHERRY_DESKS, ModTags.Items.CHERRY_DESKS );
        this.copy(ModTags.Blocks.DARK_OAK_DESKS, ModTags.Items.DARK_OAK_DESKS);
        this.copy(ModTags.Blocks.MANGROVE_DESKS, ModTags.Items.MANGROVE_DESKS);
        this.copy(ModTags.Blocks.CRIMSON_DESKS, ModTags.Items.CRIMSON_DESKS);
        this.copy(ModTags.Blocks.WARPED_DESKS, ModTags.Items.WARPED_DESKS);
        this.copy(ModTags.Blocks.DESKS, ModTags.Items.DESKS);
        this.copy(ModTags.Blocks.FABRIC_DESK_LAMPS, ModTags.Items.FABRIC_DESK_LAMPS);
    }
}
