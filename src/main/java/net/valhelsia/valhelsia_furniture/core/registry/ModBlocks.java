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

    public static final List<RegistryObject<TableBlock> > OAK_TABLES = registerTables("oak_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > SPRUCE_TABLES = registerTables("spruce_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > BIRCH_TABLES = registerTables("birch_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > JUNGLE_TABLES = registerTables("jungle_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > ACACIA_TABLES = registerTables("acacia_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > DARK_OAK_TABLES = registerTables("dark_oak_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > CRIMSON_TABLES = registerTables("crimson_table", ValhelsiaRenderType.CUTOUT);
    public static final List<RegistryObject<TableBlock> > WARPED_TABLES = registerTables("warped_table", ValhelsiaRenderType.CUTOUT);

    public static List<RegistryObject<TableBlock>> registerTables(String name, ValhelsiaRenderType renderType) {
        List<RegistryObject<TableBlock>> list = new ArrayList<>();

        for (DyeColor color : DyeColor.values()) {
            list.add(HELPER.register(color.getName() + "_" + name, new TableBlock(name, color, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), renderType));
        }

        return list;
    }
}
