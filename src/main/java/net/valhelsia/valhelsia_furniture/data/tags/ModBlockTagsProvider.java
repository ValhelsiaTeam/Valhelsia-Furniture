package net.valhelsia.valhelsia_furniture.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Mod Block Tags Provider <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.data.tags.ModBlockTagsProvider
 *
 * @author Valhelsia Team
 * @since 2022-05-15
 */
public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ValhelsiaFurniture.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.OAK_TABLES).add(ModBlocks.OAK_TABLE.get()).add(ModBlocks.OAK_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.SPRUCE_TABLES).add(ModBlocks.SPRUCE_TABLE.get()).add(ModBlocks.SPRUCE_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.BIRCH_TABLES).add(ModBlocks.BIRCH_TABLE.get()).add(ModBlocks.BIRCH_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.JUNGLE_TABLES).add(ModBlocks.JUNGLE_TABLE.get()).add(ModBlocks.JUNGLE_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.ACACIA_TABLES).add(ModBlocks.ACACIA_TABLE.get()).add(ModBlocks.ACACIA_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.DARK_OAK_TABLES).add(ModBlocks.DARK_OAK_TABLE.get()).add(ModBlocks.DARK_OAK_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.CRIMSON_TABLES).add(ModBlocks.CRIMSON_TABLE.get()).add(ModBlocks.CRIMSON_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.WARPED_TABLES).add(ModBlocks.WARPED_TABLE.get()).add(ModBlocks.WARPED_TABLES.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.TABLES).addTags(ModTags.Blocks.OAK_TABLES, ModTags.Blocks.SPRUCE_TABLES, ModTags.Blocks.BIRCH_TABLES, ModTags.Blocks.JUNGLE_TABLES, ModTags.Blocks.ACACIA_TABLES, ModTags.Blocks.DARK_OAK_TABLES, ModTags.Blocks.CRIMSON_TABLES, ModTags.Blocks.WARPED_TABLES);

        this.tag(ModTags.Blocks.OAK_CHAIRS).add(ModBlocks.OAK_CHAIR.get(), ModBlocks.HAY_OAK_CHAIR.get()).add(ModBlocks.WOOL_OAK_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.SPRUCE_CHAIRS).add(ModBlocks.SPRUCE_CHAIR.get(), ModBlocks.HAY_SPRUCE_CHAIR.get()).add(ModBlocks.WOOL_SPRUCE_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.BIRCH_CHAIRS).add(ModBlocks.BIRCH_CHAIR.get(), ModBlocks.HAY_BIRCH_CHAIR.get()).add(ModBlocks.WOOL_BIRCH_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.JUNGLE_CHAIRS).add(ModBlocks.JUNGLE_CHAIR.get(), ModBlocks.HAY_JUNGLE_CHAIR.get()).add(ModBlocks.WOOL_JUNGLE_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.ACACIA_CHAIRS).add(ModBlocks.ACACIA_CHAIR.get(), ModBlocks.HAY_ACACIA_CHAIR.get()).add(ModBlocks.WOOL_ACACIA_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.DARK_OAK_CHAIRS).add(ModBlocks.DARK_OAK_CHAIR.get(), ModBlocks.HAY_DARK_OAK_CHAIR.get()).add(ModBlocks.WOOL_DARK_OAK_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.CRIMSON_CHAIRS).add(ModBlocks.CRIMSON_CHAIR.get(), ModBlocks.HAY_CRIMSON_CHAIR.get()).add(ModBlocks.WOOL_CRIMSON_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.WARPED_CHAIRS).add(ModBlocks.WARPED_CHAIR.get(), ModBlocks.HAY_WARPED_CHAIR.get()).add(ModBlocks.WOOL_WARPED_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.CHAIRS).addTags(ModTags.Blocks.OAK_CHAIRS, ModTags.Blocks.SPRUCE_CHAIRS, ModTags.Blocks.BIRCH_CHAIRS, ModTags.Blocks.JUNGLE_CHAIRS, ModTags.Blocks.ACACIA_CHAIRS, ModTags.Blocks.DARK_OAK_CHAIRS, ModTags.Blocks.CRIMSON_CHAIRS, ModTags.Blocks.WARPED_CHAIRS);

        this.tag(ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS).add(ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_CHAIRS).addTags(ModTags.Blocks.UPHOLSTERED_OAK_CHAIRS, ModTags.Blocks.UPHOLSTERED_SPRUCE_CHAIRS, ModTags.Blocks.UPHOLSTERED_BIRCH_CHAIRS, ModTags.Blocks.UPHOLSTERED_JUNGLE_CHAIRS, ModTags.Blocks.UPHOLSTERED_ACACIA_CHAIRS, ModTags.Blocks.UPHOLSTERED_DARK_OAK_CHAIRS, ModTags.Blocks.UPHOLSTERED_CRIMSON_CHAIRS, ModTags.Blocks.UPHOLSTERED_WARPED_CHAIRS);

        this.tag(ModTags.Blocks.STOOLS).add(ModBlocks.OAK_STOOL.get(), ModBlocks.SPRUCE_STOOL.get(), ModBlocks.BIRCH_STOOL.get(), ModBlocks.JUNGLE_STOOL.get(), ModBlocks.ACACIA_STOOL.get(), ModBlocks.DARK_OAK_STOOL.get(), ModBlocks.CRIMSON_STOOL.get(), ModBlocks.WARPED_STOOL.get());

        this.tag(ModTags.Blocks.UPHOLSTERED_OAK_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS).add(ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS.stream().map(Supplier::get).toArray(Block[]::new));
        this.tag(ModTags.Blocks.UPHOLSTERED_STOOLS).addTags(ModTags.Blocks.UPHOLSTERED_OAK_STOOLS, ModTags.Blocks.UPHOLSTERED_SPRUCE_STOOLS, ModTags.Blocks.UPHOLSTERED_BIRCH_STOOLS, ModTags.Blocks.UPHOLSTERED_JUNGLE_STOOLS, ModTags.Blocks.UPHOLSTERED_ACACIA_STOOLS, ModTags.Blocks.UPHOLSTERED_DARK_OAK_STOOLS, ModTags.Blocks.UPHOLSTERED_CRIMSON_STOOLS, ModTags.Blocks.UPHOLSTERED_WARPED_STOOLS);

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
        ModBlocks.CURTAINS.values().forEach(pair -> {
            this.tag(ModTags.Blocks.CURTAINS).add(pair.getFirst().get());
            this.tag(ModTags.Blocks.CURTAINS).add(pair.getSecond().get());
        });

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTags(ModTags.Blocks.TABLES, ModTags.Blocks.CHAIRS, ModTags.Blocks.UPHOLSTERED_CHAIRS, ModTags.Blocks.STOOLS, ModTags.Blocks.UPHOLSTERED_STOOLS, ModTags.Blocks.DESKS, ModTags.Blocks.FABRIC_DESK_LAMPS);
    }
}
