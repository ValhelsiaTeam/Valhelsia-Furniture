package net.valhelsia.valhelsia_furniture.core.registry;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_core.client.util.ValhelsiaRenderType;
import net.valhelsia.valhelsia_core.core.registry.RegistryClass;
import net.valhelsia.valhelsia_core.core.registry.helper.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_core.core.registry.helper.block.BlockRegistryObject;
import net.valhelsia.valhelsia_core.core.registry.helper.block.RenderType;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Mod Blocks <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
 *
 * @author Valhelsia Team
 * @version 1.19 - 0.1.0
 * @since 2022-01-02
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks implements RegistryClass {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> OAK_TABLE = HELPER.create("oak_table", () -> new TableBlock("oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> SPRUCE_TABLE = HELPER.create("spruce_table", () -> new TableBlock("spruce_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> BIRCH_TABLE = HELPER.create("birch_table", () -> new TableBlock("birch_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> JUNGLE_TABLE = HELPER.create("jungle_table", () -> new TableBlock("jungle_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> ACACIA_TABLE = HELPER.create("acacia_table", () -> new TableBlock("acacia_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> DARK_OAK_TABLE = HELPER.create("dark_oak_table", () -> new TableBlock("dark_oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> MANGROVE_TABLE = HELPER.create("mangrove_table", () -> new TableBlock("mangrove_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> CRIMSON_TABLE = HELPER.create("crimson_table", () -> new TableBlock("crimson_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<TableBlock> WARPED_TABLE = HELPER.create("warped_table", () -> new TableBlock("warped_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> OAK_TABLES = registerTables("oak_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> SPRUCE_TABLES = registerTables("spruce_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> BIRCH_TABLES = registerTables("birch_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> JUNGLE_TABLES = registerTables("jungle_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> ACACIA_TABLES = registerTables("acacia_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> DARK_OAK_TABLES = registerTables("dark_oak_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> MANGROVE_TABLES = registerTables("mangrove_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> CRIMSON_TABLES = registerTables("crimson_table");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<TableBlock>> WARPED_TABLES = registerTables("warped_table");

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> OAK_CHAIR = HELPER.create("oak_chair", () -> new ChairBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> SPRUCE_CHAIR = HELPER.create("spruce_chair", () -> new ChairBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> BIRCH_CHAIR = HELPER.create("birch_chair", () -> new ChairBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> JUNGLE_CHAIR = HELPER.create("jungle_chair", () -> new ChairBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> ACACIA_CHAIR = HELPER.create("acacia_chair", () -> new ChairBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> DARK_OAK_CHAIR = HELPER.create("dark_oak_chair", () -> new ChairBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> MANGROVE_CHAIR = HELPER.create("mangrove_chair", () -> new ChairBlock("mangrove", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> CRIMSON_CHAIR = HELPER.create("crimson_chair", () -> new ChairBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> WARPED_CHAIR = HELPER.create("warped_chair", () -> new ChairBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_OAK_CHAIR = HELPER.create("hay_oak_chair", () -> new ChairBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_SPRUCE_CHAIR = HELPER.create("hay_spruce_chair", () -> new ChairBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_BIRCH_CHAIR = HELPER.create("hay_birch_chair", () -> new ChairBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_JUNGLE_CHAIR = HELPER.create("hay_jungle_chair", () -> new ChairBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_ACACIA_CHAIR = HELPER.create("hay_acacia_chair", () -> new ChairBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_DARK_OAK_CHAIR = HELPER.create("hay_dark_oak_chair", () -> new ChairBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_MANGROVE_CHAIR = HELPER.create("hay_mangrove_chair", () -> new ChairBlock("mangrove", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_CRIMSON_CHAIR = HELPER.create("hay_crimson_chair", () -> new ChairBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final BlockRegistryObject<ChairBlock> HAY_WARPED_CHAIR = HELPER.create("hay_warped_chair", () -> new ChairBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_OAK_CHAIRS = registerWoolChairs("oak_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_SPRUCE_CHAIRS = registerWoolChairs("spruce_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_BIRCH_CHAIRS = registerWoolChairs("birch_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_JUNGLE_CHAIRS = registerWoolChairs("jungle_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_ACACIA_CHAIRS = registerWoolChairs("acacia_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_DARK_OAK_CHAIRS = registerWoolChairs("dark_oak_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_MANGROVE_CHAIRS = registerWoolChairs("mangrove_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_CRIMSON_CHAIRS = registerWoolChairs("crimson_chair");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<ChairBlock>> WOOL_WARPED_CHAIRS = registerWoolChairs("warped_chair");

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_OAK_CHAIRS = registerUpholsteredWoolChairs("oak");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_SPRUCE_CHAIRS = registerUpholsteredWoolChairs("spruce");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_BIRCH_CHAIRS = registerUpholsteredWoolChairs("birch");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_JUNGLE_CHAIRS = registerUpholsteredWoolChairs("jungle");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_ACACIA_CHAIRS = registerUpholsteredWoolChairs("acacia");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_DARK_OAK_CHAIRS = registerUpholsteredWoolChairs("dark_oak");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_MANGROVE_CHAIRS = registerUpholsteredWoolChairs("mangrove");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_CRIMSON_CHAIRS = registerUpholsteredWoolChairs("crimson");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_WARPED_CHAIRS = registerUpholsteredWoolChairs("warped");

    public static final BlockRegistryObject<StoolBlock> OAK_STOOL = HELPER.create("oak_stool", () -> new StoolBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> SPRUCE_STOOL = HELPER.create("spruce_stool", () -> new StoolBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> BIRCH_STOOL = HELPER.create("birch_stool", () -> new StoolBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> JUNGLE_STOOL = HELPER.create("jungle_stool", () -> new StoolBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> ACACIA_STOOL = HELPER.create("acacia_stool", () -> new StoolBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> DARK_OAK_STOOL = HELPER.create("dark_oak_stool", () -> new StoolBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> MANGROVE_STOOL = HELPER.create("mangrove_stool", () -> new StoolBlock("mangrove", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> CRIMSON_STOOL = HELPER.create("crimson_stool", () -> new StoolBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<StoolBlock> WARPED_STOOL = HELPER.create("warped_stool", () -> new StoolBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_OAK_STOOLS = registerUpholsteredStools("oak");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_SPRUCE_STOOLS = registerUpholsteredStools("spruce");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_BIRCH_STOOLS = registerUpholsteredStools("birch");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_JUNGLE_STOOLS = registerUpholsteredStools("jungle");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_ACACIA_STOOLS = registerUpholsteredStools("acacia");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_DARK_OAK_STOOLS = registerUpholsteredStools("dark_oak");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_MANGROVE_STOOLS = registerUpholsteredStools("mangrove");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_CRIMSON_STOOLS = registerUpholsteredStools("crimson");
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final List<BlockRegistryObject<StoolBlock>> WOOL_UPHOLSTERED_WARPED_STOOLS = registerUpholsteredStools("warped");

    // Desks
    public static final BlockRegistryObject<DeskBlock> OAK_DESK = HELPER.create("oak_desk", () -> new DeskBlock(ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> SPRUCE_DESK = HELPER.create("spruce_desk", () -> new DeskBlock(ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> BIRCH_DESK = HELPER.create("birch_desk", () -> new DeskBlock(ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> JUNGLE_DESK = HELPER.create("jungle_desk", () -> new DeskBlock(ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> ACACIA_DESK = HELPER.create("acacia_desk", () -> new DeskBlock(ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> DARK_OAK_DESK = HELPER.create("dark_oak_desk", () -> new DeskBlock(ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> MANGROVE_DESK = HELPER.create("mangrove_desk", () -> new DeskBlock(ModTags.Blocks.MANGROVE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> CRIMSON_DESK = HELPER.create("crimson_desk", () -> new DeskBlock(ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskBlock> WARPED_DESK = HELPER.create("warped_desk", () -> new DeskBlock(ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    // Desk Drawers
    public static final BlockRegistryObject<DeskDrawerBlock> OAK_DESK_DRAWER = HELPER.create("oak_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> SPRUCE_DESK_DRAWER = HELPER.create("spruce_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> BIRCH_DESK_DRAWER = HELPER.create("birch_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> JUNGLE_DESK_DRAWER = HELPER.create("jungle_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> ACACIA_DESK_DRAWER = HELPER.create("acacia_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> DARK_OAK_DESK_DRAWER = HELPER.create("dark_oak_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> MANGROVE_DESK_DRAWER = HELPER.create("mangrove_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.MANGROVE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> CRIMSON_DESK_DRAWER = HELPER.create("crimson_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();
    public static final BlockRegistryObject<DeskDrawerBlock> WARPED_DESK_DRAWER = HELPER.create("warped_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem();

    // Fabric Desk Lamps
    @RenderType(ValhelsiaRenderType.CUTOUT)
    public static final Map<DyeColor, BlockRegistryObject<FabricDeskLampBlock>> FABRIC_DESK_LAMPS = registerColorVariants("fabric_desk_lamp", () -> new FabricDeskLampBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().lightLevel(state -> {
        return state.getValue(ModBlockStateProperties.SWITCHED_ON) ? 14 : 0;
    })));

    // Curtains
    public static final Map<DyeColor, Pair<BlockRegistryObject<ClosedCurtainBlock>, BlockRegistryObject<OpenCurtainBlock>>> CURTAINS = registerCurtains("curtain");

    public static List<BlockRegistryObject<TableBlock>> registerTables(String name) {
        List<BlockRegistryObject<TableBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.create(color.getName() + "_" + name, () -> new TableBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem());
        }

        return list;
    }

    public static List<BlockRegistryObject<ChairBlock>> registerWoolChairs(String name) {
        List<BlockRegistryObject<ChairBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.create(color.getName() + "_" + name, () -> new ChairBlock(name.substring(0, name.length() - 6), color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem());
        }

        return list;
    }

    public static List<BlockRegistryObject<UpholsteredChairBlock>> registerUpholsteredWoolChairs(String name) {
        List<BlockRegistryObject<UpholsteredChairBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.create(color.getName() + "_upholstered_" + name + "_chair", () -> new UpholsteredChairBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem());
        }

        return list;
    }

    public static List<BlockRegistryObject<StoolBlock>> registerUpholsteredStools(String name) {
        List<BlockRegistryObject<StoolBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.create(color.getName() + "_upholstered_" + name + "_stool", () -> new StoolBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))).withItem());
        }

        return list;
    }

    public static <T extends Block> Map<DyeColor, BlockRegistryObject<T>> registerColorVariants(String name, Supplier<T> block) {
        Map<DyeColor, BlockRegistryObject<T>> map = new HashMap<>();

        for (DyeColor color : DyeColor.values()) {
            map.put(color, HELPER.create(color.getName() + "_" + name, block).withItem());
        }

        return map;
    }

    public static Map<DyeColor, Pair<BlockRegistryObject<ClosedCurtainBlock>, BlockRegistryObject<OpenCurtainBlock>>> registerCurtains(String name) {
        Map<DyeColor, Pair<BlockRegistryObject<ClosedCurtainBlock>, BlockRegistryObject<OpenCurtainBlock>>> map = new HashMap<>();

        for (DyeColor color : DyeColor.values()) {
            map.put(color, Pair.of(
                    HELPER.create(color.getName() + "_" + name, () -> new ClosedCurtainBlock(color, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion())).withItem(),
                    HELPER.create("open_" + color.getName() + "_" + name, () -> new OpenCurtainBlock(color, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().lootFrom(ModBlocks.CURTAINS.get(color).getFirst())))));
        }

        return map;
    }
}
