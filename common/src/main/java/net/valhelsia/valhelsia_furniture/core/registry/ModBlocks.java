package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.valhelsia.valhelsia_core.api.client.ValhelsiaRenderType;
import net.valhelsia.valhelsia_core.api.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

/**
 * @author Valhelsia Team
 * @since 2023-06-11
 */
public class ModBlocks implements RegistryClass {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    public static final BlockRegistryEntry<TableBlock> OAK_TABLE = HELPER.register("oak_table", () -> new TableBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> SPRUCE_TABLE = HELPER.register("spruce_table", () -> new TableBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> BIRCH_TABLE = HELPER.register("birch_table", () -> new TableBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> JUNGLE_TABLE = HELPER.register("jungle_table", () -> new TableBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> ACACIA_TABLE = HELPER.register("acacia_table", () -> new TableBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> CHERRY_TABLE = HELPER.register("cherry_table", () -> new TableBlock(WoodType.CHERRY, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> DARK_OAK_TABLE = HELPER.register("dark_oak_table", () -> new TableBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> MANGROVE_TABLE = HELPER.register("mangrove_table", () -> new TableBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> CRIMSON_TABLE = HELPER.register("crimson_table", () -> new TableBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<TableBlock> WARPED_TABLE = HELPER.register("warped_table", () -> new TableBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);

    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_OAK_TABLES = HELPER.registerColorEntrySet("oak_table", color -> new TableclothTableBlock(OAK_TABLE, color, WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_SPRUCE_TABLES = HELPER.registerColorEntrySet("spruce_table", color -> new TableclothTableBlock(SPRUCE_TABLE, color, WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_BIRCH_TABLES = HELPER.registerColorEntrySet("birch_table", color -> new TableclothTableBlock(BIRCH_TABLE, color, WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_JUNGLE_TABLES = HELPER.registerColorEntrySet("jungle_table", color -> new TableclothTableBlock(JUNGLE_TABLE, color, WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_ACACIA_TABLES = HELPER.registerColorEntrySet("acacia_table", color -> new TableclothTableBlock(ACACIA_TABLE, color, WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_CHERRY_TABLES = HELPER.registerColorEntrySet("cherry_table", color -> new TableclothTableBlock(CHERRY_TABLE, color, WoodType.CHERRY, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_DARK_OAK_TABLES = HELPER.registerColorEntrySet("dark_oak_table", color -> new TableclothTableBlock(DARK_OAK_TABLE, color, WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_MANGROVE_TABLES = HELPER.registerColorEntrySet("mangrove_table", color -> new TableclothTableBlock(MANGROVE_TABLE, color, WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_CRIMSON_TABLES = HELPER.registerColorEntrySet("crimson_table", color -> new TableclothTableBlock(CRIMSON_TABLE, color, WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<TableclothTableBlock, DyeColor> COLORED_WARPED_TABLES = HELPER.registerColorEntrySet("warped_table", color -> new TableclothTableBlock(WARPED_TABLE, color, WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    public static final BlockRegistryEntry<ChairBlock> OAK_CHAIR = HELPER.register("oak_chair", () -> new ChairBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> SPRUCE_CHAIR = HELPER.register("spruce_chair", () -> new ChairBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> BIRCH_CHAIR = HELPER.register("birch_chair", () -> new ChairBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> JUNGLE_CHAIR = HELPER.register("jungle_chair", () -> new ChairBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> ACACIA_CHAIR = HELPER.register("acacia_chair", () -> new ChairBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> CHERRY_CHAIR = HELPER.register("cherry_chair", () -> new ChairBlock(WoodType.CHERRY, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> DARK_OAK_CHAIR = HELPER.register("dark_oak_chair", () -> new ChairBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> MANGROVE_CHAIR = HELPER.register("mangrove_chair", () -> new ChairBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> CRIMSON_CHAIR = HELPER.register("crimson_chair", () -> new ChairBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> WARPED_CHAIR = HELPER.register("warped_chair", () -> new ChairBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);

    public static final BlockRegistryEntry<ChairBlock> HAY_OAK_CHAIR = HELPER.register("hay_oak_chair", () -> new ChairBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_SPRUCE_CHAIR = HELPER.register("hay_spruce_chair", () -> new ChairBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_BIRCH_CHAIR = HELPER.register("hay_birch_chair", () -> new ChairBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_JUNGLE_CHAIR = HELPER.register("hay_jungle_chair", () -> new ChairBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_ACACIA_CHAIR = HELPER.register("hay_acacia_chair", () -> new ChairBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_CHERRY_CHAIR = HELPER.register("hay_cherry_chair", () -> new ChairBlock(WoodType.CHERRY, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_DARK_OAK_CHAIR = HELPER.register("hay_dark_oak_chair", () -> new ChairBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_MANGROVE_CHAIR = HELPER.register("hay_mangrove_chair", () -> new ChairBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_CRIMSON_CHAIR = HELPER.register("hay_crimson_chair", () -> new ChairBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);
    public static final BlockRegistryEntry<ChairBlock> HAY_WARPED_CHAIR = HELPER.register("hay_warped_chair", () -> new ChairBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(ValhelsiaRenderType.CUTOUT);

    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_OAK_CHAIRS = HELPER.registerColorEntrySet("oak_chair", color -> new ChairBlock(WoodType.OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_SPRUCE_CHAIRS = HELPER.registerColorEntrySet("spruce_chair", color -> new ChairBlock(WoodType.SPRUCE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_BIRCH_CHAIRS = HELPER.registerColorEntrySet("birch_chair", color -> new ChairBlock(WoodType.BIRCH, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_JUNGLE_CHAIRS = HELPER.registerColorEntrySet("jungle_chair", color -> new ChairBlock(WoodType.JUNGLE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_ACACIA_CHAIRS = HELPER.registerColorEntrySet("acacia_chair", color -> new ChairBlock(WoodType.ACACIA, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_CHERRY_CHAIRS = HELPER.registerColorEntrySet("cherry_chair", color -> new ChairBlock(WoodType.CHERRY, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_DARK_OAK_CHAIRS = HELPER.registerColorEntrySet("dark_oak_chair", color -> new ChairBlock(WoodType.DARK_OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_MANGROVE_CHAIRS = HELPER.registerColorEntrySet("mangrove_chair", color -> new ChairBlock(WoodType.MANGROVE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_CRIMSON_CHAIRS = HELPER.registerColorEntrySet("crimson_chair", color -> new ChairBlock(WoodType.CRIMSON, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_WARPED_CHAIRS = HELPER.registerColorEntrySet("warped_chair", color -> new ChairBlock(WoodType.WARPED, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_OAK_CHAIRS = HELPER.registerColorEntrySet("upholstered_oak_chair", color -> new UpholsteredChairBlock(WoodType.OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_SPRUCE_CHAIRS = HELPER.registerColorEntrySet("upholstered_spruce_chair", color -> new UpholsteredChairBlock(WoodType.SPRUCE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_BIRCH_CHAIRS = HELPER.registerColorEntrySet("upholstered_birch_chair", color -> new UpholsteredChairBlock(WoodType.BIRCH, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_JUNGLE_CHAIRS = HELPER.registerColorEntrySet("upholstered_jungle_chair", color -> new UpholsteredChairBlock(WoodType.JUNGLE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_ACACIA_CHAIRS = HELPER.registerColorEntrySet("upholstered_acacia_chair", color -> new UpholsteredChairBlock(WoodType.ACACIA, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_CHERRY_CHAIRS = HELPER.registerColorEntrySet("upholstered_cherry_chair", color -> new UpholsteredChairBlock(WoodType.CHERRY, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_DARK_OAK_CHAIRS = HELPER.registerColorEntrySet("upholstered_dark_oak_chair", color -> new UpholsteredChairBlock(WoodType.DARK_OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_MANGROVE_CHAIRS = HELPER.registerColorEntrySet("upholstered_mangrove_chair", color -> new UpholsteredChairBlock(WoodType.MANGROVE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_CRIMSON_CHAIRS = HELPER.registerColorEntrySet("upholstered_crimson_chair", color -> new UpholsteredChairBlock(WoodType.CRIMSON, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<UpholsteredChairBlock, DyeColor> WOOL_UPHOLSTERED_WARPED_CHAIRS = HELPER.registerColorEntrySet("upholstered_warped_chair", color -> new UpholsteredChairBlock(WoodType.WARPED, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    public static final BlockRegistryEntry<StoolBlock> OAK_STOOL = HELPER.register("oak_stool", () -> new StoolBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> SPRUCE_STOOL = HELPER.register("spruce_stool", () -> new StoolBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> BIRCH_STOOL = HELPER.register("birch_stool", () -> new StoolBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> JUNGLE_STOOL = HELPER.register("jungle_stool", () -> new StoolBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> ACACIA_STOOL = HELPER.register("acacia_stool", () -> new StoolBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> CHERRY_STOOL = HELPER.register("cherry_stool", () -> new StoolBlock(WoodType.CHERRY, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> DARK_OAK_STOOL = HELPER.register("dark_oak_stool", () -> new StoolBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> MANGROVE_STOOL = HELPER.register("mangrove_stool", () -> new StoolBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> CRIMSON_STOOL = HELPER.register("crimson_stool", () -> new StoolBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<StoolBlock> WARPED_STOOL = HELPER.register("warped_stool", () -> new StoolBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_OAK_STOOLS = HELPER.registerColorEntrySet("upholstered_oak_stool", color -> new StoolBlock(WoodType.OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_SPRUCE_STOOLS = HELPER.registerColorEntrySet("upholstered_spruce_stool", color -> new StoolBlock(WoodType.SPRUCE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_BIRCH_STOOLS = HELPER.registerColorEntrySet("upholstered_birch_stool", color -> new StoolBlock(WoodType.BIRCH, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_JUNGLE_STOOLS = HELPER.registerColorEntrySet("upholstered_jungle_stool", color -> new StoolBlock(WoodType.JUNGLE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_ACACIA_STOOLS = HELPER.registerColorEntrySet("upholstered_acacia_stool", color -> new StoolBlock(WoodType.ACACIA, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_CHERRY_STOOLS = HELPER.registerColorEntrySet("upholstered_cherry_stool", color -> new StoolBlock(WoodType.CHERRY, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_DARK_OAK_STOOLS = HELPER.registerColorEntrySet("upholstered_dark_oak_stool", color -> new StoolBlock(WoodType.DARK_OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_MANGROVE_STOOLS = HELPER.registerColorEntrySet("upholstered_mangrove_stool", color -> new StoolBlock(WoodType.MANGROVE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_CRIMSON_STOOLS = HELPER.registerColorEntrySet("upholstered_crimson_stool", color -> new StoolBlock(WoodType.CRIMSON, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));
    public static final BlockEntrySet<StoolBlock, DyeColor> WOOL_UPHOLSTERED_WARPED_STOOLS = HELPER.registerColorEntrySet("upholstered_warped_stool", color -> new StoolBlock(WoodType.WARPED, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    // Desks
    public static final BlockRegistryEntry<DeskBlock> OAK_DESK = HELPER.register("oak_desk", () -> new DeskBlock(WoodType.OAK, ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> SPRUCE_DESK = HELPER.register("spruce_desk", () -> new DeskBlock(WoodType.SPRUCE, ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> BIRCH_DESK = HELPER.register("birch_desk", () -> new DeskBlock(WoodType.BIRCH, ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> JUNGLE_DESK = HELPER.register("jungle_desk", () -> new DeskBlock(WoodType.JUNGLE, ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> ACACIA_DESK = HELPER.register("acacia_desk", () -> new DeskBlock(WoodType.ACACIA, ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> CHERRY_DESK = HELPER.register("cherry_desk", () -> new DeskBlock(WoodType.CHERRY, ModTags.Blocks.CHERRY_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> DARK_OAK_DESK = HELPER.register("dark_oak_desk", () -> new DeskBlock(WoodType.DARK_OAK, ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> MANGROVE_DESK = HELPER.register("mangrove_desk", () -> new DeskBlock(WoodType.MANGROVE, ModTags.Blocks.MANGROVE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> CRIMSON_DESK = HELPER.register("crimson_desk", () -> new DeskBlock(WoodType.CRIMSON, ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskBlock> WARPED_DESK = HELPER.register("warped_desk", () -> new DeskBlock(WoodType.WARPED, ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    // Desk Drawers
    public static final BlockRegistryEntry<DeskDrawerBlock> OAK_DESK_DRAWER = HELPER.register("oak_desk_drawer", () -> new DeskDrawerBlock(WoodType.OAK, ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> SPRUCE_DESK_DRAWER = HELPER.register("spruce_desk_drawer", () -> new DeskDrawerBlock(WoodType.SPRUCE, ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> BIRCH_DESK_DRAWER = HELPER.register("birch_desk_drawer", () -> new DeskDrawerBlock(WoodType.BIRCH, ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> JUNGLE_DESK_DRAWER = HELPER.register("jungle_desk_drawer", () -> new DeskDrawerBlock(WoodType.JUNGLE, ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> ACACIA_DESK_DRAWER = HELPER.register("acacia_desk_drawer", () -> new DeskDrawerBlock(WoodType.ACACIA, ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> CHERRY_DESK_DRAWER = HELPER.register("cherry_desk_drawer", () -> new DeskDrawerBlock(WoodType.CHERRY, ModTags.Blocks.CHERRY_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> DARK_OAK_DESK_DRAWER = HELPER.register("dark_oak_desk_drawer", () -> new DeskDrawerBlock(WoodType.DARK_OAK, ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> MANGROVE_DESK_DRAWER = HELPER.register("mangrove_desk_drawer", () -> new DeskDrawerBlock(WoodType.MANGROVE, ModTags.Blocks.MANGROVE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> CRIMSON_DESK_DRAWER = HELPER.register("crimson_desk_drawer", () -> new DeskDrawerBlock(WoodType.CRIMSON, ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryEntry<DeskDrawerBlock> WARPED_DESK_DRAWER = HELPER.register("warped_desk_drawer", () -> new DeskDrawerBlock(WoodType.WARPED, ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    // Fabric Desk Lamps
    public static final BlockEntrySet<FabricDeskLampBlock, DyeColor> FABRIC_DESK_LAMPS = HELPER.registerColorEntrySet("fabric_desk_lamp", color -> new FabricDeskLampBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().lightLevel(state -> {
        return state.getValue(ModBlockStateProperties.SWITCHED_ON) ? 14 : 0;
    })), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    // Curtains
    public static final BlockEntrySet<ClosedCurtainBlock, DyeColor> CLOSED_CURTAINS = HELPER.registerColorEntrySet("curtain", color -> new ClosedCurtainBlock(color, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()), entry -> entry.withItem().renderType(ValhelsiaRenderType.CUTOUT));

    public static final BlockEntrySet<OpenCurtainBlock, DyeColor> OPEN_CURTAINS = HELPER.registerColorEntrySet(s -> "open_" + s +"_curtain", color -> new OpenCurtainBlock(color, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().dropsLike(CLOSED_CURTAINS.get(color).get())), entry -> entry.renderType(ValhelsiaRenderType.CUTOUT));
}
