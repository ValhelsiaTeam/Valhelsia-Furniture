package net.valhelsia.valhelsia_furniture.data.models;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valhelsia.valhelsia_core.core.data.ValhelsiaBlockStateProvider;
import net.valhelsia.valhelsia_furniture.core.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.ClosedCurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.common.block.properties.OpenCurtainPart;
import net.valhelsia.valhelsia_furniture.common.util.TextureKey;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.List;
import java.util.function.Function;

/**
 * @author Valhelsia Team
 * @since 2021-01-05
 */
public class ModBlockStateProvider extends ValhelsiaBlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ValhelsiaFurniture.REGISTRY_MANAGER, exFileHelper);
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
        forEach(block -> block instanceof DeskBlock, block -> this.desk((DeskBlock) block));
        ModBlocks.FABRIC_DESK_LAMPS.forEach((color, registryObject) -> take(block -> {
            ModelFile model = models().withExistingParent(getName(block), modLoc("block/template_fabric_desk_lamp")).texture("color", modLoc("block/fabric_desk_lamp/colors/" + color));
            ModelFile modelOn = models().withExistingParent(getName(block) + "_on", modLoc("block/template_fabric_desk_lamp_on")).texture("color", modLoc("block/fabric_desk_lamp/colors/" + color));

            this.getVariantBuilder(block).forAllStatesExcept(state -> {
                return ConfiguredModel.builder().modelFile(state.getValue(ModBlockStateProperties.SWITCHED_ON) ? modelOn : model).build();
            }, BlockStateProperties.WATERLOGGED, BlockStateProperties.POWERED);
        }, registryObject));
        ModBlocks.CURTAINS.forEach((color, pair) -> {
            take(block -> {
                this.horizontalBlock(block, state -> {
                    ClosedCurtainPart part = state.getValue(ModBlockStateProperties.CLOSED_CURTAIN_PART);

                    return models().withExistingParent(getName(block) + part.getModelName(), part.getParentModel())
                            .texture("top", modLoc("block/curtain/" + color + "/" + part.getTopTexture()))
                            .texture("down", modLoc("block/curtain/" + color + "/" + part.getBottomTexture())).renderType("cutout");
                });
            }, pair.getFirst());
            take(block -> {
                this.horizontalBlock(block, state -> {
                    OpenCurtainPart part = state.getValue(ModBlockStateProperties.OPEN_CURTAIN_PART);

                    if (part == OpenCurtainPart.TOP) {
                        return models().getExistingFile(modLoc("block/curtain/curtain_bracket"));
                    }

                    return models().withExistingParent(getName(block) + part.getModelName() + "_open", part.getParentModel())
                            .texture("top", modLoc("block/curtain/" + color + "/" + part.getTopTexture()))
                            .texture("down", modLoc("block/curtain/" + color + "/" + part.getBottomTexture())).renderType("cutout");
                });
            }, pair.getSecond());
        });
        // forEach(this::simpleBlock);
    }

    @Override
    public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        this.getVariantBuilder(block).forAllStatesExcept(state -> ConfiguredModel.builder()
                .modelFile(modelFunc.apply(state))
                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + angleOffset) % 360)
                .build(),
                BlockStateProperties.WATERLOGGED, BlockStateProperties.POWERED
        );
    }

    private void desk(DeskBlock block) {
        this.horizontalBlock(block, state -> {
            boolean left = state.getValue(ModBlockStateProperties.LEFT);
            boolean right = state.getValue(ModBlockStateProperties.RIGHT);

            String variant = "";

            if (left && right) {
                variant = "_center";
            } else if (left) {
                variant = "_right";
            } else if (right) {
                variant = "_left";
            }

            String name = getName(block);
            boolean drawer = false;

            if (name.contains("drawer")) {
                name = name.substring(0, name.length() - 7);
                drawer = true;
            }

            name = name.substring(0, name.length() - 5);

            List<TextureKey> keys = variant.equals("_left") || variant.equals("_right") ? DeskBlock.VARIANT_TEXTURES.get("left_or_right") : variant.equals("_center") ? DeskBlock.VARIANT_TEXTURES.get("center") : DeskBlock.VARIANT_TEXTURES.get("single");

            return this.addTextures(models().withExistingParent(getName(block) + variant, modLoc("block/desk/template_desk" + (drawer ? "_drawer" : "" ) + variant)), keys, name);
        });
    }

    private BlockModelBuilder addTextures(BlockModelBuilder builder, List<TextureKey> textureKeys, String type) {
        for (TextureKey key : textureKeys) {
            builder.texture(key.key(), key.apply(type));
        }

        return builder;
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
