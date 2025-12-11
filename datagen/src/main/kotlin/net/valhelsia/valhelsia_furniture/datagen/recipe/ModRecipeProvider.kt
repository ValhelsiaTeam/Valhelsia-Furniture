package net.valhelsia.valhelsia_furniture.datagen.recipe

import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.Identifier
import net.minecraft.world.item.DyeColor
import net.minecraft.world.item.Items
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Blocks
import net.neoforged.neoforge.common.Tags
import net.valhelsia.dataforge.recipe.RecipeSubProvider
import net.valhelsia.dataforge.recipe.define
import net.valhelsia.dataforge.recipe.pattern
import net.valhelsia.valhelsia_core.api.common.registry.helper.block.BlockEntrySet
import net.valhelsia.valhelsia_furniture.common.block.*
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
import java.util.function.Supplier

class ModRecipeProvider(
    lookupProvider: HolderLookup.Provider,
    recipeOutput: RecipeOutput
) : RecipeSubProvider(lookupProvider, recipeOutput) {
    override fun buildRecipes() {
        this.table(ModBlocks.OAK_TABLE, Blocks.OAK_PLANKS, ModBlocks.COLORED_OAK_TABLES)
        this.table(ModBlocks.SPRUCE_TABLE, Blocks.SPRUCE_PLANKS, ModBlocks.COLORED_SPRUCE_TABLES)
        this.table(ModBlocks.BIRCH_TABLE, Blocks.BIRCH_PLANKS, ModBlocks.COLORED_BIRCH_TABLES)
        this.table(ModBlocks.JUNGLE_TABLE, Blocks.JUNGLE_PLANKS, ModBlocks.COLORED_JUNGLE_TABLES)
        this.table(ModBlocks.ACACIA_TABLE, Blocks.ACACIA_PLANKS, ModBlocks.COLORED_ACACIA_TABLES)
        this.table(ModBlocks.CHERRY_TABLE, Blocks.CHERRY_PLANKS, ModBlocks.COLORED_CHERRY_TABLES)
        this.table(ModBlocks.DARK_OAK_TABLE, Blocks.DARK_OAK_PLANKS, ModBlocks.COLORED_DARK_OAK_TABLES)
        this.table(ModBlocks.MANGROVE_TABLE, Blocks.MANGROVE_PLANKS, ModBlocks.COLORED_MANGROVE_TABLES)
        this.table(ModBlocks.CRIMSON_TABLE, Blocks.CRIMSON_PLANKS, ModBlocks.COLORED_CRIMSON_TABLES)
        this.table(ModBlocks.WARPED_TABLE, Blocks.WARPED_PLANKS, ModBlocks.COLORED_WARPED_TABLES)

        this.desk(ModBlocks.OAK_DESK, ModBlocks.OAK_DESK_DRAWER, Blocks.OAK_PLANKS, Blocks.OAK_SLAB)
        this.desk(ModBlocks.SPRUCE_DESK, ModBlocks.SPRUCE_DESK_DRAWER, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB)
        this.desk(ModBlocks.BIRCH_DESK, ModBlocks.BIRCH_DESK_DRAWER, Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB)
        this.desk(ModBlocks.JUNGLE_DESK, ModBlocks.JUNGLE_DESK_DRAWER, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB)
        this.desk(ModBlocks.ACACIA_DESK, ModBlocks.ACACIA_DESK_DRAWER, Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB)
        this.desk(ModBlocks.CHERRY_DESK, ModBlocks.CHERRY_DESK_DRAWER, Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB)
        this.desk(ModBlocks.DARK_OAK_DESK, ModBlocks.DARK_OAK_DESK_DRAWER, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB)
        this.desk(ModBlocks.MANGROVE_DESK, ModBlocks.MANGROVE_DESK_DRAWER, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB)
        this.desk(ModBlocks.CRIMSON_DESK, ModBlocks.CRIMSON_DESK_DRAWER, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB)
        this.desk(ModBlocks.WARPED_DESK, ModBlocks.WARPED_DESK_DRAWER, Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB)

        this.chair(
            ModBlocks.OAK_CHAIR,
            ModBlocks.HAY_OAK_CHAIR,
            Blocks.OAK_PLANKS,
            ModBlocks.WOOL_OAK_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS
        )
        this.chair(
            ModBlocks.SPRUCE_CHAIR,
            ModBlocks.HAY_SPRUCE_CHAIR,
            Blocks.SPRUCE_PLANKS,
            ModBlocks.WOOL_SPRUCE_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS
        )
        this.chair(
            ModBlocks.BIRCH_CHAIR,
            ModBlocks.HAY_BIRCH_CHAIR,
            Blocks.BIRCH_PLANKS,
            ModBlocks.WOOL_BIRCH_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS
        )
        this.chair(
            ModBlocks.JUNGLE_CHAIR,
            ModBlocks.HAY_JUNGLE_CHAIR,
            Blocks.JUNGLE_PLANKS,
            ModBlocks.WOOL_JUNGLE_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS
        )
        this.chair(
            ModBlocks.ACACIA_CHAIR,
            ModBlocks.HAY_ACACIA_CHAIR,
            Blocks.ACACIA_PLANKS,
            ModBlocks.WOOL_ACACIA_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS
        )
        this.chair(
            ModBlocks.CHERRY_CHAIR,
            ModBlocks.HAY_CHERRY_CHAIR,
            Blocks.CHERRY_PLANKS,
            ModBlocks.WOOL_CHERRY_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_CHERRY_CHAIRS
        )
        this.chair(
            ModBlocks.DARK_OAK_CHAIR,
            ModBlocks.HAY_DARK_OAK_CHAIR,
            Blocks.DARK_OAK_PLANKS,
            ModBlocks.WOOL_DARK_OAK_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS
        )
        this.chair(
            ModBlocks.MANGROVE_CHAIR,
            ModBlocks.HAY_MANGROVE_CHAIR,
            Blocks.MANGROVE_PLANKS,
            ModBlocks.WOOL_MANGROVE_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS
        )

        this.chair(
            ModBlocks.CRIMSON_CHAIR,
            ModBlocks.HAY_CRIMSON_CHAIR,
            Blocks.CRIMSON_PLANKS,
            ModBlocks.WOOL_CRIMSON_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS
        )
        this.chair(
            ModBlocks.WARPED_CHAIR,
            ModBlocks.HAY_WARPED_CHAIR,
            Blocks.WARPED_PLANKS,
            ModBlocks.WOOL_WARPED_CHAIRS,
            ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS
        )

        ModBlocks.CLOSED_CURTAINS.forEach { (color, pair) ->
            this.curtain(pair, color)
        }

        this.stool(ModBlocks.OAK_STOOL, Blocks.OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS)
        this.stool(ModBlocks.SPRUCE_STOOL, Blocks.SPRUCE_SLAB, ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS)
        this.stool(ModBlocks.BIRCH_STOOL, Blocks.BIRCH_SLAB, ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS)
        this.stool(ModBlocks.JUNGLE_STOOL, Blocks.JUNGLE_SLAB, ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS)
        this.stool(ModBlocks.ACACIA_STOOL, Blocks.ACACIA_SLAB, ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS)
        this.stool(ModBlocks.CHERRY_STOOL, Blocks.CHERRY_SLAB, ModBlocks.WOOL_UPHOLSTERED_CHERRY_STOOLS)
        this.stool(ModBlocks.DARK_OAK_STOOL, Blocks.DARK_OAK_SLAB, ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS)
        this.stool(ModBlocks.MANGROVE_STOOL, Blocks.MANGROVE_SLAB, ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS)
        this.stool(ModBlocks.CRIMSON_STOOL, Blocks.CRIMSON_SLAB, ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS)
        this.stool(ModBlocks.WARPED_STOOL, Blocks.WARPED_SLAB, ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS)

        ModBlocks.FABRIC_DESK_LAMPS.forEach { (color, registryObject) ->
            this.fabricDeskLamp(registryObject, color)
        }
    }

    private fun table(
        table: Supplier<TableBlock>,
        material: ItemLike,
        coloredTables: BlockEntrySet<TableclothTableBlock, DyeColor>
    ) {
        this.table(table, material)

        coloredTables.values.forEach { this.coloredTable(it, table) }
    }

    private fun table(block: Supplier<TableBlock>, material: ItemLike) {
        this.shaped(RecipeCategory.DECORATIONS, block.get()) {
            it.group("valhelsia_furniture:table").pattern("###", "X X", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN).unlockedBy(material)
        }
    }

    private fun coloredTable(block: Supplier<TableclothTableBlock>, table: Supplier<TableBlock>) {
        val carpet = BuiltInRegistries.BLOCK.getValue(
            Identifier.withDefaultNamespace(block.get().color.serializedName + "_carpet")
        )

        this.shaped(RecipeCategory.DECORATIONS, block.get()) {
            it.group("valhelsia_furniture:colored_" + block.get().woodType.name() + "_table").pattern("#", "X")
                .define('#' to carpet, 'X' to table.get()).unlockedBy(table.get()).unlockedBy(carpet)
        }
    }

    private fun desk(
        desk: Supplier<DeskBlock>,
        deskDrawer: Supplier<DeskDrawerBlock>,
        material: ItemLike,
        materialSlab: ItemLike
    ) {
        this.desk(desk, material)
        this.deskDrawer(deskDrawer, material, materialSlab)
    }

    private fun desk(block: Supplier<DeskBlock>, material: ItemLike) {
        this.shaped(RecipeCategory.DECORATIONS, block.get()) {
            it.group("valhelsia_furniture:desk").pattern("###", "# #", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN).unlockedBy(material)
        }
    }

    private fun deskDrawer(block: Supplier<DeskDrawerBlock>, material: ItemLike, materialSlab: ItemLike) {
        this.shaped(RecipeCategory.DECORATIONS, block.get()) {
            it.group("valhelsia_furniture:desk_drawer").pattern("###", "#S#", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN, 'S' to materialSlab)
                .unlockedBy(material, materialSlab)
        }
    }

    private fun chair(
        chair: Supplier<ChairBlock>,
        hayChair: Supplier<ChairBlock>,
        material: ItemLike,
        coloredChairs: BlockEntrySet<ChairBlock, DyeColor>,
        upholsteredChairs: BlockEntrySet<UpholsteredChairBlock, DyeColor>
    ) {
        this.chair(chair, material)
        this.hayChair(hayChair, material)

        coloredChairs.values.forEach { this.coloredChair(it, material) }

        upholsteredChairs.values.forEach { this.upholsteredChair(it, material) }
    }

    private fun chair(block: Supplier<ChairBlock>, material: ItemLike) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:chair").pattern("X  ", "###", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN).unlockedBy(material)
        }
    }

    private fun coloredChair(block: Supplier<ChairBlock>, material: ItemLike) {
        val wool = BuiltInRegistries.BLOCK.getValue(
            Identifier.withDefaultNamespace(block.get().color?.serializedName + "_wool")
        )

        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:colored_" + block.get().woodType.name() + "_chair").pattern("X  ")
                .pattern("#WW", "X X").define('#' to material, 'X' to Tags.Items.RODS_WOODEN)
                .define('W', wool).unlockedBy(material).unlockedBy(wool)
        }
    }

    private fun hayChair(block: Supplier<ChairBlock>, material: ItemLike) {
        this.shaped(
            RecipeCategory.DECORATIONS,
            block.get(),
            2
        ) {
            it.group("valhelsia_furniture:hayChair").pattern("X  ", "#HH", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN, 'H' to Blocks.HAY_BLOCK)
                .unlockedBy(material, Blocks.HAY_BLOCK)
        }
    }

    private fun upholsteredChair(block: Supplier<UpholsteredChairBlock>, material: ItemLike) {
        val wool = BuiltInRegistries.BLOCK.getValue(
            Identifier.withDefaultNamespace(block.get().color?.serializedName + "_wool")
        )

        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:upholstered_" + block.get().woodType.name() + "_chair")
                .pattern("W  ", "#WW", "X X").define('#' to material, 'X' to Tags.Items.RODS_WOODEN, 'W' to wool)
                .unlockedBy(material, wool)
        }
    }

    private fun curtain(block: Supplier<ClosedCurtainBlock>, color: DyeColor) {
        val wool =
            BuiltInRegistries.BLOCK.getValue(Identifier.withDefaultNamespace(color.serializedName + "_wool"))

        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:curtain").pattern("XX", "##", "##")
                .define('#' to wool, 'X' to Tags.Items.RODS_WOODEN).unlockedBy(wool)
        }
    }

    private fun stool(
        stool: Supplier<StoolBlock>,
        material: ItemLike,
        upholsteredStools: BlockEntrySet<StoolBlock, DyeColor>
    ) {
        this.stool(stool, material)

        upholsteredStools.values.forEach { this.upholsteredStool(it, material) }
    }


    private fun stool(block: Supplier<StoolBlock>, material: ItemLike) {
        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:stool").pattern("###", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN).unlockedBy(material)
        }
    }

    private fun upholsteredStool(block: Supplier<StoolBlock>, material: ItemLike) {
        val wool = BuiltInRegistries.BLOCK.getValue(
            Identifier.withDefaultNamespace(block.get().color?.serializedName + "_wool")
        )

        this.shaped(RecipeCategory.DECORATIONS, block.get(), 2) {
            it.group("valhelsia_furniture:upholstered_" + block.get().woodType.name() + "_stool").pattern("#W#", "X X")
                .define('#' to material, 'X' to Tags.Items.RODS_WOODEN, 'W' to wool).unlockedBy(material, wool)
        }
    }

    private fun fabricDeskLamp(block: Supplier<FabricDeskLampBlock>, color: DyeColor) {
        val wool =
            BuiltInRegistries.BLOCK.getValue(Identifier.withDefaultNamespace(color.serializedName + "_wool"))

        this.shaped(RecipeCategory.DECORATIONS, block.get()) {
            it.group("valhelsia_furniture:fabric_desk_lamp").pattern("#", "G", "X")
                .define('#' to wool, 'X' to Tags.Items.RODS_WOODEN, 'G' to Items.GLOWSTONE_DUST)
                .unlockedBy(wool, Items.GLOWSTONE_DUST)
        }
    }
}
