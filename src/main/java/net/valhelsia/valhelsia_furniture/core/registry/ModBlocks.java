package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.valhelsia.valhelsia_core.client.util.ValhelsiaRenderType;
import net.valhelsia.valhelsia_core.core.registry.block.BlockRegistryHelper;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.ConnectedTableBlock;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;

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

    public static final RegistryObject<TableBlock> BLUE_OAK_TABLE = HELPER.register("blue_oak_table", new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);
    public static final RegistryObject<ConnectedTableBlock> CONNECTED_BLUE_OAK_TABLE = HELPER.registerNoItem("connected_blue_oak_table", new ConnectedTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ValhelsiaRenderType.CUTOUT);

}
