package net.valhelsia.valhelsia_furniture.datagen.model;

import com.google.gson.JsonElement;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-15
 */
public class ModBlockModels {

    private final BlockModelGenerators generators;
    private final Consumer<BlockStateGenerator> blockStateOutput;
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;

    private ModBlockModels(BlockModelGenerators generators) {
        this.generators = generators;
        this.blockStateOutput = generators.blockStateOutput;
        this.modelOutput = generators.modelOutput;

    }

    public static void create(BlockModelGenerators generators) {
        new ModBlockModels(generators).createModels();
    }

    public void createModels() {
        this.createTable(ModBlocks.OAK_TABLE.get());
        this.createTable(ModBlocks.SPRUCE_TABLE.get());
        this.createTable(ModBlocks.BIRCH_TABLE.get());
        this.createTable(ModBlocks.JUNGLE_TABLE.get());
        this.createTable(ModBlocks.ACACIA_TABLE.get());
        this.createTable(ModBlocks.DARK_OAK_TABLE.get());
        this.createTable(ModBlocks.MANGROVE_TABLE.get());
        this.createTable(ModBlocks.CRIMSON_TABLE.get());
        this.createTable(ModBlocks.WARPED_TABLE.get());

        this.apply(ModBlocks.COLORED_OAK_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_SPRUCE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_BIRCH_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_JUNGLE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_ACACIA_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_DARK_OAK_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_MANGROVE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_CRIMSON_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_WARPED_TABLES, this::createTable);

        this.createChair(ModBlocks.OAK_CHAIR.get());
        this.createChair(ModBlocks.SPRUCE_CHAIR.get());
        this.createChair(ModBlocks.BIRCH_CHAIR.get());
        this.createChair(ModBlocks.JUNGLE_CHAIR.get());
        this.createChair(ModBlocks.ACACIA_CHAIR.get());
        this.createChair(ModBlocks.DARK_OAK_CHAIR.get());
        this.createChair(ModBlocks.MANGROVE_CHAIR.get());
        this.createChair(ModBlocks.CRIMSON_CHAIR.get());
        this.createChair(ModBlocks.WARPED_CHAIR.get());

        this.createChair(ModBlocks.HAY_OAK_CHAIR.get());
        this.createChair(ModBlocks.HAY_SPRUCE_CHAIR.get());
        this.createChair(ModBlocks.HAY_BIRCH_CHAIR.get());
        this.createChair(ModBlocks.HAY_JUNGLE_CHAIR.get());
        this.createChair(ModBlocks.HAY_ACACIA_CHAIR.get());
        this.createChair(ModBlocks.HAY_DARK_OAK_CHAIR.get());
        this.createChair(ModBlocks.HAY_MANGROVE_CHAIR.get());
        this.createChair(ModBlocks.HAY_CRIMSON_CHAIR.get());
        this.createChair(ModBlocks.HAY_WARPED_CHAIR.get());

        this.apply(ModBlocks.WOOL_OAK_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_SPRUCE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_BIRCH_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_JUNGLE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_ACACIA_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_DARK_OAK_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_MANGROVE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_CRIMSON_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_WARPED_CHAIRS, this::createChair);

        this.apply(ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS, this::createUpholsteredChair);

        this.createStool(ModBlocks.OAK_STOOL.get());
        this.createStool(ModBlocks.SPRUCE_STOOL.get());
        this.createStool(ModBlocks.BIRCH_STOOL.get());
        this.createStool(ModBlocks.JUNGLE_STOOL.get());
        this.createStool(ModBlocks.ACACIA_STOOL.get());
        this.createStool(ModBlocks.DARK_OAK_STOOL.get());
        this.createStool(ModBlocks.MANGROVE_STOOL.get());
        this.createStool(ModBlocks.CRIMSON_STOOL.get());
        this.createStool(ModBlocks.WARPED_STOOL.get());

        this.apply(ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS, this::createUpholsteredStool);

        this.createDesk(ModBlocks.OAK_DESK.get());
        this.createDesk(ModBlocks.SPRUCE_DESK.get());
        this.createDesk(ModBlocks.BIRCH_DESK.get());
        this.createDesk(ModBlocks.JUNGLE_DESK.get());
        this.createDesk(ModBlocks.ACACIA_DESK.get());
        this.createDesk(ModBlocks.DARK_OAK_DESK.get());
        this.createDesk(ModBlocks.MANGROVE_DESK.get());
        this.createDesk(ModBlocks.CRIMSON_DESK.get());
        this.createDesk(ModBlocks.WARPED_DESK.get());

        this.createDesk(ModBlocks.OAK_DESK_DRAWER.get());
        this.createDesk(ModBlocks.SPRUCE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.BIRCH_DESK_DRAWER.get());
        this.createDesk(ModBlocks.JUNGLE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.ACACIA_DESK_DRAWER.get());
        this.createDesk(ModBlocks.DARK_OAK_DESK_DRAWER.get());
        this.createDesk(ModBlocks.MANGROVE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.CRIMSON_DESK_DRAWER.get());
        this.createDesk(ModBlocks.WARPED_DESK_DRAWER.get());
    }

    private <T extends Block> void apply(BlockEntrySet<T, ?> set, Consumer<T> consumer) {
        for (BlockRegistryEntry<T> entry : set.values()) {
            consumer.accept(entry.get());
        }
    }

    private void createTable(Block block) {
        if (!(block instanceof TableBlock tableBlock)) {
            return;
        }

        String folder = FurnitureBlock.Type.TABLE.getSerializedName() + "/" + tableBlock.getWoodType().name();
        TextureMapping textureMapping = new TextureMapping().put(ModTextureSlots.TABLE, ModTextureMapping.getBlockTexture(block, folder)).put(ModTextureSlots.CONNECTED_TABLE, ModTextureMapping.getBlockTexture(block, folder, "_connected"));

        this.createTableModels(block, textureMapping);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, ModBlockStateProperties.ROTATED).generate((north, east, south, west, rotated) -> {
            boolean connected = north || east || south || west;
            boolean allConnected = north && east && south && west;

            String suffix = connected ? "_" : "";

            if (north) {
                suffix = rotated && !allConnected ? suffix.concat("e") : suffix.concat("n");
            }
            if (east) {
                suffix = rotated && !allConnected ? suffix.concat("s") : suffix.concat("e");
            }
            if (south) {
                suffix = rotated && !allConnected ? suffix.concat("w") : suffix.concat("s");
            }
            if (west) {
                suffix = rotated && !allConnected ? suffix.concat("n") : suffix.concat("w");
            }

            suffix = switch (suffix) {
                case "_esn" -> "_nes";
                case "_swn" -> "_nsw";
                case "_ewn" -> "_new";
                case "_sn" -> "_ns";
                case "_en" -> "_ne";
                case "_wn" -> "_nw";
                default -> suffix;
            };

            Variant variant = Variant.variant()
                    .with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, suffix));

            if (rotated) {
                variant.with(VariantProperties.Y_ROT, !connected ? VariantProperties.Rotation.R90 : VariantProperties.Rotation.R270);
            }

            return variant;
        });

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
    }

    private void createTableModels(Block block, TextureMapping mapping) {
        ModModelTemplates.TABLE.create(block, mapping, this.modelOutput);
        ModModelTemplates.TABLE_N.createWithSuffix(block, "_n", mapping, this.modelOutput);
        ModModelTemplates.TABLE_E.createWithSuffix(block, "_e", mapping, this.modelOutput);
        ModModelTemplates.TABLE_S.createWithSuffix(block, "_s", mapping, this.modelOutput);
        ModModelTemplates.TABLE_W.createWithSuffix(block, "_w", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NE.createWithSuffix(block, "_ne", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NES.createWithSuffix(block, "_nes", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NESW.createWithSuffix(block, "_nesw", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NEW.createWithSuffix(block, "_new", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NS.createWithSuffix(block, "_ns", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NSW.createWithSuffix(block, "_nsw", mapping, this.modelOutput);
        ModModelTemplates.TABLE_NW.createWithSuffix(block, "_nw", mapping, this.modelOutput);
        ModModelTemplates.TABLE_SW.createWithSuffix(block, "_sw", mapping, this.modelOutput);
        ModModelTemplates.TABLE_ES.createWithSuffix(block, "_es", mapping, this.modelOutput);
        ModModelTemplates.TABLE_ESW.createWithSuffix(block, "_esw", mapping, this.modelOutput);
        ModModelTemplates.TABLE_EW.createWithSuffix(block, "_ew", mapping, this.modelOutput);
    }

    private void createChair(Block block) {
        if (!(block instanceof ChairBlock chairBlock)) {
            return;
        }

        TextureMapping textureMapping = new TextureMapping().put(ModTextureSlots.CHAIR, ModTextureMapping.getBlockTexture(block, "chair/" + chairBlock.getWoodType().name()));
        ResourceLocation model = ModModelTemplates.CHAIR.create(block, textureMapping, this.modelOutput);

        this.blockStateOutput.accept(createSimpleBlock(block, model).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createUpholsteredChair(UpholsteredChairBlock block) {
        TextureMapping textureMapping = new TextureMapping()
                .put(ModTextureSlots.WOOL, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/upholstered_chair/colors/" + block.getColor()))
                .put(ModTextureSlots.WOOD, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/upholstered_chair/base/" + block.getWoodType().name()));
        ResourceLocation model = ModModelTemplates.UPHOLSTERED_CHAIR.create(block, textureMapping, this.modelOutput);

        this.blockStateOutput.accept(createSimpleBlock(block, model).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createStool(Block block) {
        TextureMapping textureMapping = new TextureMapping().put(ModTextureSlots.STOOL, ModTextureMapping.getBlockTexture(block, "stool"));
        ResourceLocation model = ModModelTemplates.STOOL.create(block, textureMapping, this.modelOutput);
        ResourceLocation rotatedModel = ModModelTemplates.STOOL_ROTATED.createWithSuffix(block, "_rotated", textureMapping, this.modelOutput);

        this.blockStateOutput.accept(createSimpleBlock(block, model).with(createRotatedDispatch(rotatedModel)));
    }

    private void createUpholsteredStool(StoolBlock block) {
        TextureMapping textureMapping = new TextureMapping()
                .put(ModTextureSlots.WOOD, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/upholstered_stool/base/" + block.getWoodType().name()))
                .put(ModTextureSlots.WOOL, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/upholstered_stool/colors/" + block.getColor()));

        ResourceLocation model = ModModelTemplates.UPHOLSTERED_STOOL.create(block, textureMapping, this.modelOutput);
        ResourceLocation rotatedModel = ModModelTemplates.UPHOLSTERED_STOOL_ROTATED.createWithSuffix(block, "_rotated", textureMapping, this.modelOutput);

        this.blockStateOutput.accept(createSimpleBlock(block, model).with(createRotatedDispatch(rotatedModel)));
    }

    private void createDesk(Block block) {
        if (!(block instanceof DeskBlock deskBlock)) {
            return;
        }

        PropertyDispatch dispatch = PropertyDispatch.properties(ModBlockStateProperties.LEFT, ModBlockStateProperties.RIGHT).generate((left, right) -> {
            String variant = "";

            if (left && right) {
                variant = "_center";
            } else if (left) {
                variant = "_right";
            } else if (right) {
                variant = "_left";
            }

            List<TextureSlot> textureSlots = variant.equals("_left") || variant.equals("_right") ? DeskBlock.VARIANT_TEXTURES.get("left_or_right") : variant.equals("_center") ? DeskBlock.VARIANT_TEXTURES.get("center") : DeskBlock.VARIANT_TEXTURES.get("single");

            TextureMapping textureMapping = new TextureMapping();

            for (TextureSlot slot : textureSlots) {
                textureMapping.put(slot, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/desk/" + deskBlock.getWoodType().name() + "/" + slot.getId()));
            }

            ResourceLocation model = this.getDeskModel(left, right, block instanceof DeskDrawerBlock).createWithSuffix(block, variant, textureMapping, this.modelOutput);

            return Variant.variant().with(VariantProperties.MODEL, model);
        });

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createHorizontalFacingDispatch()).with(dispatch));
    }

    private ModelTemplate getDeskModel(boolean left, boolean right, boolean drawer) {
        if (left && right) {
            return drawer ? ModModelTemplates.DESK_DRAWER_CENTER : ModModelTemplates.DESK_CENTER;
        } else if (left) {
            return drawer ? ModModelTemplates.DESK_DRAWER_LEFT : ModModelTemplates.DESK_LEFT;
        } else if (right) {
            return drawer ? ModModelTemplates.DESK_DRAWER_RIGHT : ModModelTemplates.DESK_RIGHT;
        } else {
            return drawer ? ModModelTemplates.DESK_DRAWER : ModModelTemplates.DESK;
        }
    }

    private static MultiVariantGenerator createSimpleBlock(Block block, ResourceLocation resourceLocation) {
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation));
    }

    private static PropertyDispatch createBooleanModelDispatch(BooleanProperty booleanProperty, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        return PropertyDispatch.property(booleanProperty).select(true, Variant.variant().with(VariantProperties.MODEL, resourceLocation)).select(false, Variant.variant().with(VariantProperties.MODEL, resourceLocation2));
    }

    private static PropertyDispatch createRotatedDispatch(ResourceLocation model) {
        return PropertyDispatch.property(ModBlockStateProperties.ROTATED).select(false, Variant.variant()).select(true, Variant.variant().with(VariantProperties.MODEL, model));
    }
}
