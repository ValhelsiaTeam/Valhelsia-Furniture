package net.valhelsia.valhelsia_furniture.data.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Valhelsia Team
 * @since 2022-09-23
 */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        this.addTableRecipes(ModBlocks.OAK_TABLE, Blocks.OAK_PLANKS, ModBlocks.OAK_TABLES, consumer);
        this.addTableRecipes(ModBlocks.SPRUCE_TABLE, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_TABLES, consumer);
        this.addTableRecipes(ModBlocks.BIRCH_TABLE, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_TABLES, consumer);
        this.addTableRecipes(ModBlocks.JUNGLE_TABLE, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_TABLES, consumer);
        this.addTableRecipes(ModBlocks.ACACIA_TABLE, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_TABLES, consumer);
        this.addTableRecipes(ModBlocks.DARK_OAK_TABLE, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_TABLES, consumer);
        this.addTableRecipes(ModBlocks.CRIMSON_TABLE, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_TABLES, consumer);
        this.addTableRecipes(ModBlocks.WARPED_TABLE, Blocks.WARPED_PLANKS, ModBlocks.WARPED_TABLES, consumer);

        this.addDeskRecipes(ModBlocks.OAK_DESK, ModBlocks.OAK_DESK_DRAWER, Blocks.OAK_PLANKS, Blocks.OAK_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.SPRUCE_DESK, ModBlocks.SPRUCE_DESK_DRAWER, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.BIRCH_DESK, ModBlocks.BIRCH_DESK_DRAWER, Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.JUNGLE_DESK, ModBlocks.JUNGLE_DESK_DRAWER, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.ACACIA_DESK, ModBlocks.ACACIA_DESK_DRAWER, Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.DARK_OAK_DESK, ModBlocks.DARK_OAK_DESK_DRAWER, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.CRIMSON_DESK, ModBlocks.CRIMSON_DESK_DRAWER, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB, consumer);
        this.addDeskRecipes(ModBlocks.WARPED_DESK, ModBlocks.WARPED_DESK_DRAWER, Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB, consumer);

        this.addChairRecipes(ModBlocks.OAK_CHAIR, ModBlocks.HAY_OAK_CHAIR, Blocks.OAK_PLANKS, ModBlocks.WOOL_OAK_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.SPRUCE_CHAIR, ModBlocks.HAY_SPRUCE_CHAIR, Blocks.SPRUCE_PLANKS, ModBlocks.WOOL_SPRUCE_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.BIRCH_CHAIR, ModBlocks.HAY_BIRCH_CHAIR, Blocks.BIRCH_PLANKS, ModBlocks.WOOL_BIRCH_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.JUNGLE_CHAIR, ModBlocks.HAY_JUNGLE_CHAIR, Blocks.JUNGLE_PLANKS, ModBlocks.WOOL_JUNGLE_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.ACACIA_CHAIR, ModBlocks.HAY_ACACIA_CHAIR, Blocks.ACACIA_PLANKS, ModBlocks.WOOL_ACACIA_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.DARK_OAK_CHAIR, ModBlocks.HAY_DARK_OAK_CHAIR, Blocks.DARK_OAK_PLANKS, ModBlocks.WOOL_DARK_OAK_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.CRIMSON_CHAIR, ModBlocks.HAY_CRIMSON_CHAIR, Blocks.CRIMSON_PLANKS, ModBlocks.WOOL_CRIMSON_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS, consumer);
        this.addChairRecipes(ModBlocks.WARPED_CHAIR, ModBlocks.HAY_WARPED_CHAIR, Blocks.WARPED_PLANKS, ModBlocks.WOOL_WARPED_CHAIRS, ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS, consumer);

        ModBlocks.CURTAINS.forEach((dyeColor, registryObject) -> this.curtain(registryObject, dyeColor, consumer));

        this.addStoolRecipes(ModBlocks.OAK_STOOL, Blocks.OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.SPRUCE_STOOL, Blocks.SPRUCE_SLAB, ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.BIRCH_STOOL, Blocks.BIRCH_SLAB, ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.JUNGLE_STOOL, Blocks.JUNGLE_SLAB, ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.ACACIA_STOOL, Blocks.ACACIA_SLAB, ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.DARK_OAK_STOOL, Blocks.DARK_OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.CRIMSON_STOOL, Blocks.CRIMSON_SLAB, ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS, consumer);
        this.addStoolRecipes(ModBlocks.WARPED_STOOL, Blocks.WARPED_SLAB, ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS, consumer);
    }

    private void addTableRecipes(RegistryObject<TableBlock> table, ItemLike material, List<RegistryObject<TableBlock>> coloredTables, @Nonnull Consumer<FinishedRecipe> consumer) {
        this.table(table, material, consumer);

        coloredTables.forEach(registryObject -> {
            this.coloredTable(registryObject, table, consumer);
        });
    }

    private void table(RegistryObject<TableBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get()).group("valhelsia_furniture:table").pattern("###").pattern("X X").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(material)).save(consumer);
    }

    private void coloredTable(RegistryObject<TableBlock> block, RegistryObject<TableBlock> table, @Nonnull Consumer<FinishedRecipe> consumer) {
        Block carpet = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_carpet"));

        if (carpet != null) {
            ShapedRecipeBuilder.shaped(block.get()).group("valhelsia_furniture:colored_" + block.get().getBaseName()).pattern("#").pattern("X").define('#', carpet).define('X', table.get()).unlockedBy("has_table", has(table.get())).unlockedBy("has_carpet", has(carpet)).save(consumer);
        }
    }

    private void addDeskRecipes(RegistryObject<DeskBlock> desk, RegistryObject<DeskDrawerBlock> deskDrawer, ItemLike material, ItemLike materialSlab, @Nonnull Consumer<FinishedRecipe> consumer) {
        this.desk(desk, material, consumer);
        this.deskDrawer(deskDrawer, material, materialSlab, consumer);
    }

    private void desk(RegistryObject<DeskBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get()).group("valhelsia_furniture:desk").pattern("###").pattern("# #").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(material)).save(consumer);
    }

    private void deskDrawer(RegistryObject<DeskDrawerBlock> block, ItemLike material, ItemLike materialSlab, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get()).group("valhelsia_furniture:desk_drawer").pattern("###").pattern("#S#").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('S', materialSlab).unlockedBy("has_item", has(material)).unlockedBy("has_slab", has(materialSlab)).save(consumer);
    }

    private void addChairRecipes(RegistryObject<ChairBlock> chair, RegistryObject<ChairBlock> hayChair, ItemLike material, List<RegistryObject<ChairBlock>> coloredChairs, List<RegistryObject<UpholsteredChairBlock>> upholsteredChairs, @Nonnull Consumer<FinishedRecipe> consumer) {
        this.chair(chair, material, consumer);
        this.hayChair(hayChair, material, consumer);

        coloredChairs.forEach(registryObject -> {
            this.coloredChair(registryObject, material, consumer);
        });

        upholsteredChairs.forEach(registryObject -> {
            this.upholsteredChair(registryObject, material, consumer);
        });
    }

    private void chair(RegistryObject<ChairBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:chair").pattern("X  ").pattern("###").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(material)).save(consumer);
    }

    private void coloredChair(RegistryObject<ChairBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:colored_" + block.get().getBaseName()).pattern("X  ").pattern("#WW").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy("has_item", has(material)).unlockedBy("has_wool", has(wool)).save(consumer);
        }
    }

    private void hayChair(RegistryObject<ChairBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:hayChair").pattern("X  ").pattern("#HH").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('H', Blocks.HAY_BLOCK).unlockedBy("has_item", has(material)).unlockedBy("has_hay_block", has(Blocks.HAY_BLOCK)).save(consumer);
    }

    private void upholsteredChair(RegistryObject<UpholsteredChairBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:upholstered_" + block.get().getBaseName()).pattern("W  ").pattern("#WW").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy("has_item", has(material)).unlockedBy("has_wool", has(wool)).save(consumer);
        }
    }

    private void curtain(RegistryObject<CurtainBlock> block, DyeColor color, @Nonnull Consumer<FinishedRecipe> consumer) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(color.getName() + "_wool"));

        if (wool != null) {
            ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:curtain").pattern("XX").pattern("##").pattern("##").define('#', wool).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(wool)).save(consumer);
        }
    }

    private void addStoolRecipes(RegistryObject<StoolBlock> stool, ItemLike material, List<RegistryObject<StoolBlock>> upholsteredStools, @Nonnull Consumer<FinishedRecipe> consumer) {
        this.stool(stool, material, consumer);

        upholsteredStools.forEach(registryObject -> {
            this.upholsteredStool(registryObject, material, consumer);
        });
    }


    private void stool(RegistryObject<StoolBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:stool").pattern("###").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).unlockedBy("has_item", has(material)).save(consumer);
    }

    private void upholsteredStool(RegistryObject<StoolBlock> block, ItemLike material, @Nonnull Consumer<FinishedRecipe> consumer) {
        Block wool = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Objects.requireNonNull(block.get().getColor()).getName() + "_wool"));

        if (wool != null) {
            ShapedRecipeBuilder.shaped(block.get(), 2).group("valhelsia_furniture:upholstered_" + block.get().getBaseName()).pattern("#W#").pattern("X X").define('#', material).define('X', Tags.Items.RODS_WOODEN).define('W', wool).unlockedBy("has_item", has(material)).unlockedBy("has_wool", has(wool)).save(consumer);
        }
    }
}
