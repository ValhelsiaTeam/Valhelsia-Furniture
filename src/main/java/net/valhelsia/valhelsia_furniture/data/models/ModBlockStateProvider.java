package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockStateProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.function.Function;

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
        forEach(block -> block instanceof UpholsteredChairBlock, block -> {
            horizontalBlock(block, models()
                    .withExistingParent(getName(block), modLoc("block/template_upholstered_chair"))
                    .texture("wool", modLoc("block/upholstered_chair/colors/" + ((ChairBlock) block).getColor()))
                    .texture("wood", modLoc("block/upholstered_chair/base/" + ((ChairBlock) block).getBaseName())));
        });
        forEach(block -> block instanceof ChairBlock, block -> {
            horizontalBlock(block, models()
                    .withExistingParent(getName(block), modLoc("block/template_chair"))
                    .texture("chair", modLoc("block/chair/" + ((ChairBlock) block).getBaseName() + "/" + getName(block))));
        });
        forEach(block -> block instanceof StoolBlock, block -> this.stoolBlock((StoolBlock) block));
        forEach(block -> block instanceof DeskBlock, block -> this.horizontalBlock(block, state -> {
            boolean left = state.getValue(ModBlockStateProperties.LEFT);
            boolean right = state.getValue(ModBlockStateProperties.RIGHT);

            String variant = "";

            if (left && right) {
                variant = "_center";
            } else if (left) {
                variant = "_left";
            } else if (right) {
                variant = "_right";
            }

            String name = getName(block);
            boolean drawer = false;

            if (name.contains("drawer")) {
                name = name.substring(0, name.length() - 7);
                drawer = true;
            }

            return models().withExistingParent(getName(block) + variant, modLoc("block/template_desk" + (drawer ? "_drawer" : "" )+ variant)).texture("desk", modLoc("block/desk/" + name));
        }));
        ModBlocks.FABRIC_DESK_LAMPS.forEach((color, registryObject) -> take(block -> {
            ModelFile model = models().withExistingParent(getName(block), modLoc("block/template_fabric_desk_lamp")).texture("color", modLoc("block/fabric_desk_lamp/colors/" + color));
            ModelFile modelOn = models().withExistingParent(getName(block) + "_on", modLoc("block/template_fabric_desk_lamp_on")).texture("color", modLoc("block/fabric_desk_lamp/colors/" + color));

            this.getVariantBuilder(block).forAllStatesExcept(state -> {
                return ConfiguredModel.builder().modelFile(state.getValue(ModBlockStateProperties.SWITCHED_ON) ? modelOn : model).build();
            }, BlockStateProperties.WATERLOGGED);
        }, registryObject));
        ModBlocks.CURTAINS.forEach((color, registryObject) -> take(block -> {
            this.horizontalBlock(block, state -> {
                CurtainPart part = state.getValue(ModBlockStateProperties.CURTAIN_PART);
                boolean open = state.getValue(BlockStateProperties.OPEN);

                if (part == CurtainPart.TOP) {
                    return models().getExistingFile(modLoc("block/curtain/curtain_bracket"));
                }

                return models().withExistingParent(getName(block) + part.getModelName() + (open ? "_open" : ""), part.getParentModel())
                        .texture("top", modLoc("block/curtain/" + color + "/" + part.getTopTexture(open)))
                        .texture("down", modLoc("block/curtain/" + color + "/" + part.getBottomTexture(open)));
            });
        }, registryObject));
        // forEach(this::simpleBlock);
    }

    @Override
    public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        this.getVariantBuilder(block).forAllStatesExcept(state -> ConfiguredModel.builder()
                .modelFile(modelFunc.apply(state))
                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + angleOffset) % 360)
                .build(),
                BlockStateProperties.WATERLOGGED
        );
    }

    private void tableBlock(TableBlock block) {
        String name = this.getName(block);

        this.getVariantBuilder(block).forAllStatesExcept(state -> {
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

    private void stoolBlock(StoolBlock block) {
        ModelFile model;
        ModelFile rotatedModel;

        if (block.getColor() != null) {
            model = models().withExistingParent(getName(block), modLoc("block/template_upholstered_stool")).texture("wood", modLoc("block/upholstered_stool/base/" + block.getBaseName())).texture("wool", modLoc("block/upholstered_stool/colors/" + block.getColor()));
            rotatedModel = models().withExistingParent(getName(block) + "_rotated", modLoc("block/template_upholstered_stool_rotated")).texture("wood", modLoc("block/upholstered_stool/base/" + block.getBaseName())).texture("wool", modLoc("block/upholstered_stool/colors/" + block.getColor()));

        } else {
            model = models().withExistingParent(getName(block), modLoc("block/template_stool")).texture("stool", modLoc("block/stool/" + this.getName(block)));
            rotatedModel = models().withExistingParent(getName(block) + "_rotated", modLoc("block/template_stool_rotated")).texture("stool", modLoc("block/stool/" + this.getName(block)));
        }

        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            return ConfiguredModel.builder().modelFile(state.getValue(ModBlockStateProperties.ROTATED) ? rotatedModel : model).build();
            }, BlockStateProperties.WATERLOGGED
        );
    }
}
