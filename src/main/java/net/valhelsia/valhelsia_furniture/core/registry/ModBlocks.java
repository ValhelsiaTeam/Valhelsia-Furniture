package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.client.util.ValhelsiaRenderType;
import net.valhelsia.valhelsia_core.core.registry.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mod Blocks <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-01-02
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    public static final RegistryObject<TableBlock> OAK_TABLE = HELPER.register("oak_table", () -> new TableBlock("oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> SPRUCE_TABLE = HELPER.register("spruce_table", () -> new TableBlock("spruce_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> BIRCH_TABLE = HELPER.register("birch_table", () -> new TableBlock("birch_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> JUNGLE_TABLE = HELPER.register("jungle_table", () -> new TableBlock("jungle_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> ACACIA_TABLE = HELPER.register("acacia_table", () -> new TableBlock("acacia_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> DARK_OAK_TABLE = HELPER.register("dark_oak_table", () -> new TableBlock("dark_oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> CRIMSON_TABLE = HELPER.register("crimson_table", () -> new TableBlock("crimson_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> WARPED_TABLE = HELPER.register("warped_table", () -> new TableBlock("warped_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);

    public static final List<RegistryObject<TableBlock>> OAK_TABLES = registerTables("oak_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> SPRUCE_TABLES = registerTables("spruce_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> BIRCH_TABLES = registerTables("birch_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> JUNGLE_TABLES = registerTables("jungle_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> ACACIA_TABLES = registerTables("acacia_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> DARK_OAK_TABLES = registerTables("dark_oak_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> CRIMSON_TABLES = registerTables("crimson_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock>> WARPED_TABLES = registerTables("warped_table", ValhelsiaRenderType.CUTOUT);

    public static final RegistryObject<ChairBlock> OAK_CHAIR = HELPER.register("oak_chair", () -> new ChairBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> SPRUCE_CHAIR = HELPER.register("spruce_chair", () -> new ChairBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> BIRCH_CHAIR = HELPER.register("birch_chair", () -> new ChairBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> JUNGLE_CHAIR = HELPER.register("jungle_chair", () -> new ChairBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> ACACIA_CHAIR = HELPER.register("acacia_chair", () -> new ChairBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> DARK_OAK_CHAIR = HELPER.register("dark_oak_chair", () -> new ChairBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> CRIMSON_CHAIR = HELPER.register("crimson_chair", () -> new ChairBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> WARPED_CHAIR = HELPER.register("warped_chair", () -> new ChairBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);

    public static final RegistryObject<ChairBlock> HAY_OAK_CHAIR = HELPER.register("hay_oak_chair", () -> new ChairBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_SPRUCE_CHAIR = HELPER.register("hay_spruce_chair", () -> new ChairBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_BIRCH_CHAIR = HELPER.register("hay_birch_chair", () -> new ChairBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_JUNGLE_CHAIR = HELPER.register("hay_jungle_chair", () -> new ChairBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_ACACIA_CHAIR = HELPER.register("hay_acacia_chair", () -> new ChairBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_DARK_OAK_CHAIR = HELPER.register("hay_dark_oak_chair", () -> new ChairBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_CRIMSON_CHAIR = HELPER.register("hay_crimson_chair", () -> new ChairBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ChairBlock> HAY_WARPED_CHAIR = HELPER.register("hay_warped_chair", () -> new ChairBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);

    public static final List<RegistryObject<ChairBlock>> WOOL_OAK_CHAIRS = registerWoolChairs("oak_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_SPRUCE_CHAIRS = registerWoolChairs("spruce_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_BIRCH_CHAIRS = registerWoolChairs("birch_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_JUNGLE_CHAIRS = registerWoolChairs("jungle_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_ACACIA_CHAIRS = registerWoolChairs("acacia_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_DARK_OAK_CHAIRS = registerWoolChairs("dark_oak_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_CRIMSON_CHAIRS = registerWoolChairs("crimson_chair", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<ChairBlock>> WOOL_WARPED_CHAIRS = registerWoolChairs("warped_chair", ValhelsiaRenderType.CUTOUT);

    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_OAK_CHAIRS = registerUpholsteredWoolChairs("oak", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_SPRUCE_CHAIRS = registerUpholsteredWoolChairs("spruce", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_BIRCH_CHAIRS = registerUpholsteredWoolChairs("birch", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_JUNGLE_CHAIRS = registerUpholsteredWoolChairs("jungle", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_ACACIA_CHAIRS = registerUpholsteredWoolChairs("acacia", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_DARK_OAK_CHAIRS = registerUpholsteredWoolChairs("dark_oak", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_CRIMSON_CHAIRS = registerUpholsteredWoolChairs("crimson", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<UpholsteredChairBlock>> WOOL_UPHOLSTERED_WARPED_CHAIRS = registerUpholsteredWoolChairs("warped", ValhelsiaRenderType.CUTOUT);

    public static final RegistryObject<StoolBlock> OAK_STOOL = HELPER.register("oak_stool", () -> new StoolBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> SPRUCE_STOOL = HELPER.register("spruce_stool", () -> new StoolBlock("spruce", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> BIRCH_STOOL = HELPER.register("birch_stool", () -> new StoolBlock("birch", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> JUNGLE_STOOL = HELPER.register("jungle_stool", () -> new StoolBlock("jungle", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> ACACIA_STOOL = HELPER.register("acacia_stool", () -> new StoolBlock("acacia", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> DARK_OAK_STOOL = HELPER.register("dark_oak_stool", () -> new StoolBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> CRIMSON_STOOL = HELPER.register("crimson_stool", () -> new StoolBlock("crimson", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);
    public static final RegistryObject<StoolBlock> WARPED_STOOL = HELPER.register("warped_stool", () -> new StoolBlock("warped", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.SOLID);

    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_OAK_STOOLS = registerUpholsteredStools("oak", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_SPRUCE_STOOLS = registerUpholsteredStools("spruce", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_BIRCH_STOOLS = registerUpholsteredStools("birch", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_JUNGLE_STOOLS = registerUpholsteredStools("jungle", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_ACACIA_STOOLS = registerUpholsteredStools("acacia", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_DARK_OAK_STOOLS = registerUpholsteredStools("dark_oak", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_CRIMSON_STOOLS = registerUpholsteredStools("crimson", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<StoolBlock>> WOOL_UPHOLSTERED_WARPED_STOOLS = registerUpholsteredStools("warped", ValhelsiaRenderType.CUTOUT);

    // Desks
    public static final RegistryObject<DeskBlock> OAK_DESK = HELPER.register("oak_desk", () -> new DeskBlock(ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> SPRUCE_DESK = HELPER.register("spruce_desk", () -> new DeskBlock(ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> BIRCH_DESK = HELPER.register("birch_desk", () -> new DeskBlock(ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> JUNGLE_DESK = HELPER.register("jungle_desk", () -> new DeskBlock(ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> ACACIA_DESK = HELPER.register("acacia_desk", () -> new DeskBlock(ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> DARK_OAK_DESK = HELPER.register("dark_oak_desk", () -> new DeskBlock(ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> CRIMSON_DESK = HELPER.register("crimson_desk", () -> new DeskBlock(ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskBlock> WARPED_DESK = HELPER.register("warped_desk", () -> new DeskBlock(ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    // Desk Drawers
    public static final RegistryObject<DeskDrawerBlock> OAK_DESK_DRAWER = HELPER.register("oak_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> SPRUCE_DESK_DRAWER = HELPER.register("spruce_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.SPRUCE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> BIRCH_DESK_DRAWER = HELPER.register("birch_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.BIRCH_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> JUNGLE_DESK_DRAWER = HELPER.register("jungle_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.JUNGLE_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> ACACIA_DESK_DRAWER = HELPER.register("acacia_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.ACACIA_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> DARK_OAK_DESK_DRAWER = HELPER.register("dark_oak_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.DARK_OAK_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> CRIMSON_DESK_DRAWER = HELPER.register("crimson_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.CRIMSON_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<DeskDrawerBlock> WARPED_DESK_DRAWER = HELPER.register("warped_desk_drawer", () -> new DeskDrawerBlock(ModTags.Blocks.WARPED_DESKS, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static List<RegistryObject<TableBlock>> registerTables(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<TableBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_" + name, () -> new TableBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }

    public static List<RegistryObject<ChairBlock>> registerWoolChairs(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<ChairBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_" + name, () -> new ChairBlock(name.substring(0, name.length() - 6), color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }

    public static List<RegistryObject<UpholsteredChairBlock>> registerUpholsteredWoolChairs(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<UpholsteredChairBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_upholstered_" + name + "_chair", () -> new UpholsteredChairBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }

    public static List<RegistryObject<StoolBlock>> registerUpholsteredStools(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<StoolBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_upholstered_" + name + "_stool", () -> new StoolBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }
}
