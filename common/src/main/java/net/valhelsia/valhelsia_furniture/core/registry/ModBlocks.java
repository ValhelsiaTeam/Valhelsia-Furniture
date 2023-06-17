package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.valhelsia.valhelsia_core.api.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;

/**
 * @author Valhelsia Team
 * @since 2023-06-11
 */
public class ModBlocks implements RegistryClass {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    public static final BlockRegistryEntry OAK_TABLE = HELPER.register("oak_table", () -> new TableBlock("oak_table", WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry SPRUCE_TABLE = HELPER.register("spruce_table", () -> new TableBlock("spruce_table", WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry BIRCH_TABLE = HELPER.register("birch_table", () -> new TableBlock("birch_table", WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry JUNGLE_TABLE = HELPER.register("jungle_table", () -> new TableBlock("jungle_table", WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry ACACIA_TABLE = HELPER.register("acacia_table", () -> new TableBlock("acacia_table", WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry DARK_OAK_TABLE = HELPER.register("dark_oak_table", () -> new TableBlock("dark_oak_table", WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry MANGROVE_TABLE = HELPER.register("mangrove_table", () -> new TableBlock("mangrove_table", WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry CRIMSON_TABLE = HELPER.register("crimson_table", () -> new TableBlock("crimson_table", WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);
    public static final BlockRegistryEntry WARPED_TABLE = HELPER.register("warped_table", () -> new TableBlock("warped_table", WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem().renderType(RenderType::cutout);

    public static final BlockEntrySet<DyeColor> COLORED_OAK_TABLES = HELPER.registerColorEntrySet("oak_table", color -> new TableBlock("oak_table", color, WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_SPRUCE_TABLES = HELPER.registerColorEntrySet("spruce_table", color -> new TableBlock("spruce_table", color, WoodType.SPRUCE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_BIRCH_TABLES = HELPER.registerColorEntrySet("birch_table", color -> new TableBlock("birch_table", color, WoodType.BIRCH, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_JUNGLE_TABLES = HELPER.registerColorEntrySet("jungle_table", color -> new TableBlock("jungle_table", color, WoodType.JUNGLE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_ACACIA_TABLES = HELPER.registerColorEntrySet("acacia_table", color -> new TableBlock("acacia_table", color, WoodType.ACACIA, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_DARK_OAK_TABLES = HELPER.registerColorEntrySet("dark_oak_table", color -> new TableBlock("dark_oak_table", color, WoodType.DARK_OAK, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_MANGROVE_TABLES = HELPER.registerColorEntrySet("mangrove_table", color -> new TableBlock("mangrove_table", color, WoodType.MANGROVE, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_CRIMSON_TABLES = HELPER.registerColorEntrySet("crimson_table", color -> new TableBlock("crimson_table", color, WoodType.CRIMSON, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));
    public static final BlockEntrySet<DyeColor> COLORED_WARPED_TABLES = HELPER.registerColorEntrySet("warped_table", color -> new TableBlock("warped_table", color, WoodType.WARPED, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), entry -> entry.withItem().renderType(RenderType::cutout));

}
