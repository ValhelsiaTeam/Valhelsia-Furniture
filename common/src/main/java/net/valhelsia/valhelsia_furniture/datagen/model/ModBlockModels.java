package net.valhelsia.valhelsia_furniture.datagen.model;

import com.google.gson.JsonElement;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_furniture.common.block.FurnitureBlock;
import net.valhelsia.valhelsia_furniture.common.block.TableBlock;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

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
    }

    private void apply(BlockEntrySet<?> set, Consumer<Block> consumer) {
        for (BlockRegistryEntry entry : set.values()) {
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

    private static MultiVariantGenerator createSimpleBlock(Block block, ResourceLocation resourceLocation) {
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation));
    }

    private static PropertyDispatch createBooleanModelDispatch(BooleanProperty booleanProperty, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        return PropertyDispatch.property(booleanProperty).select(true, Variant.variant().with(VariantProperties.MODEL, resourceLocation)).select(false, Variant.variant().with(VariantProperties.MODEL, resourceLocation2));
    }

    private static PropertyDispatch createRotatedDispatch() {
        return PropertyDispatch.property(ModBlockStateProperties.ROTATED).select(false, Variant.variant()).select(true, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));
    }
}
