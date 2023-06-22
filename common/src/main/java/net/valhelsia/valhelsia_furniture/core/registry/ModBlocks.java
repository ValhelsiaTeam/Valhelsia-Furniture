package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.valhelsia.valhelsia_core.api.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.ChairBlock;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;
import net.valhelsia.valhelsia_furniture.common.block.TableclothTableBlock;

/**
 * @author Valhelsia Team
 * @since 2023-06-11
 */
public class ModBlocks implements RegistryClass {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    public static final BlockRegistryEntry<Block> OAK_TABLE = HELPER.register("oak_table", () -> new TableBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> SPRUCE_TABLE = HELPER.register("spruce_table", () -> new TableBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> BIRCH_TABLE = HELPER.register("birch_table", () -> new TableBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> JUNGLE_TABLE = HELPER.register("jungle_table", () -> new TableBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> ACACIA_TABLE = HELPER.register("acacia_table", () -> new TableBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> DARK_OAK_TABLE = HELPER.register("dark_oak_table", () -> new TableBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> MANGROVE_TABLE = HELPER.register("mangrove_table", () -> new TableBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> CRIMSON_TABLE = HELPER.register("crimson_table", () -> new TableBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> WARPED_TABLE = HELPER.register("warped_table", () -> new TableBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);

    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_OAK_TABLES = HELPER.registerColorEntrySet("oak_table", color -> new TableclothTableBlock(OAK_TABLE, color, WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_SPRUCE_TABLES = HELPER.registerColorEntrySet("spruce_table", color -> new TableclothTableBlock(SPRUCE_TABLE, color, WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_BIRCH_TABLES = HELPER.registerColorEntrySet("birch_table", color -> new TableclothTableBlock(BIRCH_TABLE, color, WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_JUNGLE_TABLES = HELPER.registerColorEntrySet("jungle_table", color -> new TableclothTableBlock(JUNGLE_TABLE, color, WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_ACACIA_TABLES = HELPER.registerColorEntrySet("acacia_table", color -> new TableclothTableBlock(ACACIA_TABLE, color, WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_DARK_OAK_TABLES = HELPER.registerColorEntrySet("dark_oak_table", color -> new TableclothTableBlock(DARK_OAK_TABLE, color, WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_MANGROVE_TABLES = HELPER.registerColorEntrySet("mangrove_table", color -> new TableclothTableBlock(MANGROVE_TABLE, color, WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_CRIMSON_TABLES = HELPER.registerColorEntrySet("crimson_table", color -> new TableclothTableBlock(CRIMSON_TABLE, color, WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<TableBlock, DyeColor> COLORED_WARPED_TABLES = HELPER.registerColorEntrySet("warped_table", color -> new TableclothTableBlock(WARPED_TABLE, color, WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));

    public static final BlockRegistryEntry<Block> OAK_CHAIR = HELPER.register("oak_chair", () -> new ChairBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> SPRUCE_CHAIR = HELPER.register("spruce_chair", () -> new ChairBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> BIRCH_CHAIR = HELPER.register("birch_chair", () -> new ChairBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> JUNGLE_CHAIR = HELPER.register("jungle_chair", () -> new ChairBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> ACACIA_CHAIR = HELPER.register("acacia_chair", () -> new ChairBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> DARK_OAK_CHAIR = HELPER.register("dark_oak_chair", () -> new ChairBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> MANGROVE_CHAIR = HELPER.register("mangrove_chair", () -> new ChairBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> CRIMSON_CHAIR = HELPER.register("crimson_chair", () -> new ChairBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> WARPED_CHAIR = HELPER.register("warped_chair", () -> new ChairBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);

    public static final BlockRegistryEntry<Block> HAY_OAK_CHAIR = HELPER.register("hay_oak_chair", () -> new ChairBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_SPRUCE_CHAIR = HELPER.register("hay_spruce_chair", () -> new ChairBlock(WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_BIRCH_CHAIR = HELPER.register("hay_birch_chair", () -> new ChairBlock(WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_JUNGLE_CHAIR = HELPER.register("hay_jungle_chair", () -> new ChairBlock(WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_ACACIA_CHAIR = HELPER.register("hay_acacia_chair", () -> new ChairBlock(WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_DARK_OAK_CHAIR = HELPER.register("hay_dark_oak_chair", () -> new ChairBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_MANGROVE_CHAIR = HELPER.register("hay_mangrove_chair", () -> new ChairBlock(WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_CRIMSON_CHAIR = HELPER.register("hay_crimson_chair", () -> new ChairBlock(WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry<Block> HAY_WARPED_CHAIR = HELPER.register("hay_warped_chair", () -> new ChairBlock(WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);

    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_OAK_CHAIRS = HELPER.registerColorEntrySet("oak_chair", color -> new ChairBlock(WoodType.OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_SPRUCE_CHAIRS = HELPER.registerColorEntrySet("spruce_chair", color -> new ChairBlock(WoodType.SPRUCE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_BIRCH_CHAIRS = HELPER.registerColorEntrySet("birch_chair", color -> new ChairBlock(WoodType.BIRCH, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_JUNGLE_CHAIRS = HELPER.registerColorEntrySet("jungle_chair", color -> new ChairBlock(WoodType.JUNGLE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_ACACIA_CHAIRS = HELPER.registerColorEntrySet("acacia_chair", color -> new ChairBlock(WoodType.ACACIA, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_DARK_OAK_CHAIRS = HELPER.registerColorEntrySet("dark_oak_chair", color -> new ChairBlock(WoodType.DARK_OAK, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_MANGROVE_CHAIRS = HELPER.registerColorEntrySet("mangrove_chair", color -> new ChairBlock(WoodType.MANGROVE, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_CRIMSON_CHAIRS = HELPER.registerColorEntrySet("crimson_chair", color -> new ChairBlock(WoodType.CRIMSON, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<ChairBlock, DyeColor> WOOL_WARPED_CHAIRS = HELPER.registerColorEntrySet("warped_chair", color -> new ChairBlock(WoodType.WARPED, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));

}
