package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.client.util.ValhelsiaRenderType;
import net.valhelsia.valhelsia_core.core.registry.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Mod Blocks <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
 *
 * @author Valhelsia Team
 * @version 1.18.1 - 0.1.0
 * @since 2022-01-02
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static final BlockRegistryHelper HELPER = ValhelsiaFurniture.REGISTRY_MANAGER.getBlockHelper();

    public static final RegistryObject<TableBlock> OAK_TABLE = HELPER.register("oak_table", new TableBlock("oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> SPRUCE_TABLE = HELPER.register("spruce_table", new TableBlock("spruce_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> BIRCH_TABLE = HELPER.register("birch_table", new TableBlock("birch_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> JUNGLE_TABLE = HELPER.register("jungle_table", new TableBlock("jungle_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> ACACIA_TABLE = HELPER.register("acacia_table", new TableBlock("acacia_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> DARK_OAK_TABLE = HELPER.register("dark_oak_table", new TableBlock("dark_oak_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> CRIMSON_TABLE = HELPER.register("crimson_table", new TableBlock("crimson_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<TableBlock> WARPED_TABLE = HELPER.register("warped_table", new TableBlock("warped_table", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);


    public static List<RegistryObject<TableBlock>> registerTables(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<TableBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_" + name, new TableBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }
}
