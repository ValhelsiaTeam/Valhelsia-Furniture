package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockStateProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;

/**
 * Mod Block State Provider <br>
 * Valhelsia Structures - net.valhelsia.valhelsia_furniture.data.DataGenerators.models.ModBlockStateProvider
 *
 * @author Valhelsia Team
 * @version 1.18.1-0.1.0
 * @since 2021-01-05
 */
public class ModBlockStateProvider extends ValhelsiaBlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ValhelsiaFurniture.REGISTRY_MANAGER, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        forEach(block -> block instanceof TableBlock, block -> this.tableBlock((TableBlock) block));

       // forEach(this::simpleBlock);
    }

    private void tableBlock(TableBlock block) {
        String name = this.getName(block);

        getVariantBuilder(block).forAllStatesExcept(state -> {
            boolean north = state.getValue(BlockStateProperties.NORTH);
            boolean east = state.getValue(BlockStateProperties.EAST);
            boolean south = state.getValue(BlockStateProperties.SOUTH);
            boolean west = state.getValue(BlockStateProperties.WEST);

            boolean rotated = state.getValue(ModBlockStateProperties.ROTATED);

            boolean connected = north || east || south || west;
            boolean allConnected = north && east && south && west;

            String s = connected ? "_" : "";

            if (north) {
                s = rotated && !allConnected ? s.concat("e") : s.concat("n");
            }
            if (east) {
                s = rotated && !allConnected ? s.concat("s") : s.concat("e");
            }
            if (south) {
                s = rotated && !allConnected ? s.concat("w") : s.concat("s");
            }
            if (west) {
                s = rotated && !allConnected ? s.concat("n") : s.concat("w");
            }

            s = switch (s) {
                case "_esn" -> "_nes";
                case "_swn" -> "_nsw";
                case "_ewn" -> "_new";
                case "_sn" -> "_ns";
                case "_en" -> "_ne";
                case "_wn" -> "_nw";
                default -> s;
            };

            ModelFile model = models().withExistingParent(name + s, modLoc("block/template_table" + s))
                    .texture("table", modLoc("block/" + block.getBaseName() + "/" + name))
                    .texture("connected_table", modLoc("block/" + block.getBaseName() + "/" + name + "_connected"));

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(!connected && rotated ? 90 : rotated ? 270 : 0)
                    .build();
        }, BlockStateProperties.WATERLOGGED);
    }
}