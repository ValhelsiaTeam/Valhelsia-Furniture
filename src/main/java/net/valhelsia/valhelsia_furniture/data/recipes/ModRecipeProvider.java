package net.valhelsia.valhelsia_furniture.data.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.valhelsia.valhelsia_core.data.recipes.RecipeSubProvider;
import net.valhelsia.valhelsia_core.data.recipes.ValhelsiaRecipeProvider;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author Valhelsia Team
 * @since 2022-09-23
 */
public class ModRecipeProvider extends RecipeSubProvider {

    public ModRecipeProvider(ValhelsiaRecipeProvider provider) {
        super(provider);
    }

    @Override
    protected void registerRecipes() {
        this.table(ModBlocks.OAK_TABLE, Blocks.OAK_PLANKS, ModBlocks.OAK_TABLES);
        this.table(ModBlocks.SPRUCE_TABLE, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_TABLES);
        this.table(ModBlocks.BIRCH_TABLE, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_TABLES);
        this.table(ModBlocks.JUNGLE_TABLE, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_TABLES);
        this.table(ModBlocks.ACACIA_TABLE, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_TABLES);
        this.table(ModBlocks.DARK_OAK_TABLE, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_TABLES);
        this.table(ModBlocks.MANGROVE_TABLE, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_TABLES);
        this.table(ModBlocks.CRIMSON_TABLE, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_TABLES);
        this.table(ModBlocks.WARPED_TABLE, Blocks.WARPED_PLANKS, ModBlocks.WARPED_TABLES);

        this.desk(ModBlocks.OAK_DESK, ModBlocks.OAK_DESK_DRAWER, Blocks.OAK_PLANKS, Blocks.OAK_SLAB);
        this.desk(ModBlocks.SPRUCE_DESK, ModBlocks.SPRUCE_DESK_DRAWER, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB);
        this.desk(ModBlocks.BIRCH_DESK, ModBlocks.BIRCH_DESK_DRAWER, Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB);
        this.desk(ModBlocks.JUNGLE_DESK, ModBlocks.JUNGLE_DESK_DRAWER, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB);
        this.desk(ModBlocks.ACACIA_DESK, ModBlocks.ACACIA_DESK_DRAWER, Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB);
        this.desk(ModBlocks.DARK_OAK_DESK, ModBlocks.DARK_OAK_DESK_DRAWER, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB);
        this.desk(ModBlocks.MANGROVE_DESK, ModBlocks.MANGROVE_DESK_DRAWER, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB);
        this.desk(ModBlocks.CRIMSON_DESK, ModBlocks.CRIMSON_DESK_DRAWER, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
        this.desk(ModBlocks.WARPED_DESK, ModBlocks.WARPED_DESK_DRAWER, Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);

        this.chair(ModBlocks.OAK_CHAIR, ModBlocks.HAY_OAK_CHAIR, Blocks.OAK_PLANKS, ModBlocks.WOOL_OAK_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS);
        this.chair(ModBlocks.SPRUCE_CHAIR, ModBlocks.HAY_SPRUCE_CHAIR, Blocks.SPRUCE_PLANKS, ModBlocks.WOOL_SPRUCE_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS);
        this.chair(ModBlocks.BIRCH_CHAIR, ModBlocks.HAY_BIRCH_CHAIR, Blocks.BIRCH_PLANKS, ModBlocks.WOOL_BIRCH_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS);
        this.chair(ModBlocks.JUNGLE_CHAIR, ModBlocks.HAY_JUNGLE_CHAIR, Blocks.JUNGLE_PLANKS, ModBlocks.WOOL_JUNGLE_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS);
        this.chair(ModBlocks.ACACIA_CHAIR, ModBlocks.HAY_ACACIA_CHAIR, Blocks.ACACIA_PLANKS, ModBlocks.WOOL_ACACIA_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS);
        this.chair(ModBlocks.DARK_OAK_CHAIR, ModBlocks.HAY_DARK_OAK_CHAIR, Blocks.DARK_OAK_PLANKS, ModBlocks.WOOL_DARK_OAK_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS);
        this.chair(ModBlocks.MANGROVE_CHAIR, ModBlocks.HAY_MANGROVE_CHAIR, Blocks.MANGROVE_PLANKS, ModBlocks.WOOL_MANGROVE_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS);

        this.chair(ModBlocks.CRIMSON_CHAIR, ModBlocks.HAY_CRIMSON_CHAIR, Blocks.CRIMSON_PLANKS, ModBlocks.WOOL_CRIMSON_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS);
        this.chair(ModBlocks.WARPED_CHAIR, ModBlocks.HAY_WARPED_CHAIR, Blocks.WARPED_PLANKS, ModBlocks.WOOL_WARPED_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS);

        ModBlocks.CURTAINS.forEach((color, pair) -> this.curtain(pair.getFirst(), color));

        this.stool(ModBlocks.OAK_STOOL, Blocks.OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS);
        this.stool(ModBlocks.SPRUCE_STOOL, Blocks.SPRUCE_SLAB, ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS);
        this.stool(ModBlocks.BIRCH_STOOL, Blocks.BIRCH_SLAB, ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS);
        this.stool(ModBlocks.JUNGLE_STOOL, Blocks.JUNGLE_SLAB, ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS);
        this.stool(ModBlocks.ACACIA_STOOL, Blocks.ACACIA_SLAB, ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS);
        this.stool(ModBlocks.DARK_OAK_STOOL, Blocks.DARK_OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS);
        this.stool(ModBlocks.MANGROVE_STOOL, Blocks.MANGROVE_SLAB, ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS);
        this.stool(ModBlocks.CRIMSON_STOOL, Blocks.CRIMSON_SLAB, ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS);
        this.stool(ModBlocks.WARPED_STOOL, Blocks.WARPED_SLAB, ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS);

        ModBlocks.FABRIC_DESK_LAMPS.forEach((color, registryObject) -> this.fabricDeskLamp(registryObject, color));
    }

    private void table(Supplier<TableBlock> table, ItemLike material, List<? extends Supplier<TableBlock>> coloredTables) {
        this.table(table, material);

        coloredTables.forEach(registryObject -> {
            this.coloredTable(registryObject, table);
        });
    }

    private void table(Supplier<TableBlock> block, ItemLike material) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), builder -> builder.group("valhelsia_furniture:table").pattern("###").pattern("X X").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy(this, material));
    }

    private void coloredTable(Supplier<TableBlock> block, Supplier<TableBlock> table) {
        Block carpet = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_carpet"));

        if (carpet != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), builder -> builder.group("valhelsia_furniture:colored_" + block.get().getBaseName()).pattern("#").pattern("X").define('#', carpet).define('X', table.get()).unlockedBy(this, table.get()).unlockedBy(this, carpet));
        }
    }

    private void desk(Supplier<DeskBlock> desk, Supplier<DeskDrawerBlock> deskDrawer, ItemLike material, ItemLike materialSlab) {
        this.desk(desk, material);
        this.deskDrawer(deskDrawer, material, materialSlab);
    }

    private void desk(Supplier<DeskBlock> block, ItemLike material) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), builder -> builder.group("valhelsia_furniture:desk").pattern("###").pattern("# #").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy(this, material));
    }

    private void deskDrawer(Supplier<DeskDrawerBlock> block, ItemLike material, ItemLike materialSlab) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), builder -> builder.group("valhelsia_furniture:desk_drawer").pattern("###").pattern("#S#").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('S', materialSlab).unlockedBy(this, material).unlockedBy(this, materialSlab));
    }

    private void chair(Supplier<ChairBlock> chair, Supplier<ChairBlock> hayChair, ItemLike material, List<? extends Supplier<ChairBlock>> coloredChairs, List<? extends Supplier<UpholsteredChairBlock>> upholsteredChairs) {
        this.chair(chair, material);
        this.hayChair(hayChair, material);

        coloredChairs.forEach(registryObject -> {
            this.coloredChair(registryObject, material);
        });

        upholsteredChairs.forEach(registryObject -> {
            this.upholsteredChair(registryObject, material);
        });
    }

    private void chair(Supplier<ChairBlock> block, ItemLike material) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:chair").pattern("X  ").pattern("###").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy(this, material));
    }

    private void coloredChair(Supplier<ChairBlock> block, ItemLike material) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:colored_" + block.get().getBaseName()).pattern("X  ").pattern("#WW").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy(this, material).unlockedBy(this, wool));
        }
    }

    private void hayChair(Supplier<ChairBlock> block, ItemLike material) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:hayChair").pattern("X  ").pattern("#HH").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('H', Blocks.HAY_BLOCK).unlockedBy(this, material).unlockedBy(this, Blocks.HAY_BLOCK));
    }

    private void upholsteredChair(Supplier<UpholsteredChairBlock> block, ItemLike material) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:upholstered_" + block.get().getBaseName()).pattern("W  ").pattern("#WW").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy(this, material).unlockedBy(this, wool));
        }
    }

    private void curtain(Supplier<ClosedCurtainBlock> block, DyeColor color) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(color.getName() + "_wool"));

        if (wool != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:curtain").pattern("XX").pattern("##").pattern("##").define('#', wool).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(wool)));
        }
    }

    private void stool(Supplier<StoolBlock> stool, ItemLike material, List<? extends Supplier<StoolBlock>> upholsteredStools) {
        this.stool(stool, material);

        upholsteredStools.forEach(registryObject -> {
            this.upholsteredStool(registryObject, material);
        });
    }


    private void stool(Supplier<StoolBlock> block, ItemLike material) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:stool").pattern("###").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy(this, material));
    }

    private void upholsteredStool(Supplier<StoolBlock> block, ItemLike material) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), 2, builder -> builder.group("valhelsia_furniture:upholstered_" + block.get().getBaseName()).pattern("#W#").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy(this, material).unlockedBy(this, wool));
        }
    }

    private void fabricDeskLamp(Supplier<FabricDeskLampBlock> block, DyeColor color) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(color.getName() + "_wool"));

        if (wool != null) {
            this.shaped(RecipeCategory.DECORATIONS, block.get(), builder -> builder.group("valhelsia_furniture:fabric_desk_lamp").pattern("#").pattern("G").pattern("X").define('#', wool).define('X', Tags.Items.RODS_WOODEN).define('G', Items.GLOWSTONE_DUST).unlockedBy(this, wool).unlockedBy(this, Items.GLOWSTONE_DUST));
        }
    }
}
