package net.valhelsia.valhelsia_furniture.datagen.models;

import com.google.gson.JsonElement;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockEntrySet;
import net.valhelsia.valhelsia_core.api.registry.helper.block.BlockRegistryEntry;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.common.block.*;
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.List;
import java.util.Map;
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

    private final Consumer<Item> skippedAutoItemModels;

    private ModBlockModels(BlockModelGenerators generators, Consumer<Item> skippedAutoItemModels) {
        this.generators = generators;
        this.blockStateOutput = generators.blockStateOutput;
        this.modelOutput = generators.modelOutput;
        this.skippedAutoItemModels = skippedAutoItemModels;

    }

    public static void create(BlockModelGenerators generators, Consumer<Item> skippedAutoItemModels) {
        new ModBlockModels(generators, skippedAutoItemModels).createModels();
    }

    private void skipAutoItemBlock(Block block) {
        this.skippedAutoItemModels.accept(block.asItem());
    }

    public void createModels() {
        this.createTable(ModBlocks.OAK_TABLE.get());
        this.createTable(ModBlocks.SPRUCE_TABLE.get());
        this.createTable(ModBlocks.BIRCH_TABLE.get());
        this.createTable(ModBlocks.JUNGLE_TABLE.get());
        this.createTable(ModBlocks.ACACIA_TABLE.get());
        this.createTable(ModBlocks.CHERRY_TABLE.get());
        this.createTable(ModBlocks.DARK_OAK_TABLE.get());
        this.createTable(ModBlocks.MANGROVE_TABLE.get());
        this.createTable(ModBlocks.CRIMSON_TABLE.get());
        this.createTable(ModBlocks.WARPED_TABLE.get());

        this.apply(ModBlocks.COLORED_OAK_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_SPRUCE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_BIRCH_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_JUNGLE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_ACACIA_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_CHERRY_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_DARK_OAK_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_MANGROVE_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_CRIMSON_TABLES, this::createTable);
        this.apply(ModBlocks.COLORED_WARPED_TABLES, this::createTable);

        this.createChair(ModBlocks.OAK_CHAIR.get());
        this.createChair(ModBlocks.SPRUCE_CHAIR.get());
        this.createChair(ModBlocks.BIRCH_CHAIR.get());
        this.createChair(ModBlocks.JUNGLE_CHAIR.get());
        this.createChair(ModBlocks.ACACIA_CHAIR.get());
        this.createChair(ModBlocks.CHERRY_CHAIR.get());
        this.createChair(ModBlocks.DARK_OAK_CHAIR.get());
        this.createChair(ModBlocks.MANGROVE_CHAIR.get());
        this.createChair(ModBlocks.CRIMSON_CHAIR.get());
        this.createChair(ModBlocks.WARPED_CHAIR.get());

        this.createChair(ModBlocks.HAY_OAK_CHAIR.get());
        this.createChair(ModBlocks.HAY_SPRUCE_CHAIR.get());
        this.createChair(ModBlocks.HAY_BIRCH_CHAIR.get());
        this.createChair(ModBlocks.HAY_JUNGLE_CHAIR.get());
        this.createChair(ModBlocks.HAY_ACACIA_CHAIR.get());
        this.createChair(ModBlocks.HAY_CHERRY_CHAIR.get());
        this.createChair(ModBlocks.HAY_DARK_OAK_CHAIR.get());
        this.createChair(ModBlocks.HAY_MANGROVE_CHAIR.get());
        this.createChair(ModBlocks.HAY_CRIMSON_CHAIR.get());
        this.createChair(ModBlocks.HAY_WARPED_CHAIR.get());

        this.apply(ModBlocks.WOOL_OAK_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_SPRUCE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_BIRCH_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_JUNGLE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_ACACIA_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_CHERRY_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_DARK_OAK_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_MANGROVE_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_CRIMSON_CHAIRS, this::createChair);
        this.apply(ModBlocks.WOOL_WARPED_CHAIRS, this::createChair);

        this.apply(ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CHERRY_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS, this::createUpholsteredChair);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS, this::createUpholsteredChair);

        this.createStool(ModBlocks.OAK_STOOL.get());
        this.createStool(ModBlocks.SPRUCE_STOOL.get());
        this.createStool(ModBlocks.BIRCH_STOOL.get());
        this.createStool(ModBlocks.JUNGLE_STOOL.get());
        this.createStool(ModBlocks.ACACIA_STOOL.get());
        this.createStool(ModBlocks.CHERRY_STOOL.get());
        this.createStool(ModBlocks.DARK_OAK_STOOL.get());
        this.createStool(ModBlocks.MANGROVE_STOOL.get());
        this.createStool(ModBlocks.CRIMSON_STOOL.get());
        this.createStool(ModBlocks.WARPED_STOOL.get());

        this.apply(ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CHERRY_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS, this::createUpholsteredStool);
        this.apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS, this::createUpholsteredStool);

        this.createDesk(ModBlocks.OAK_DESK.get());
        this.createDesk(ModBlocks.SPRUCE_DESK.get());
        this.createDesk(ModBlocks.BIRCH_DESK.get());
        this.createDesk(ModBlocks.JUNGLE_DESK.get());
        this.createDesk(ModBlocks.ACACIA_DESK.get());
        this.createDesk(ModBlocks.CHERRY_DESK.get());
        this.createDesk(ModBlocks.DARK_OAK_DESK.get());
        this.createDesk(ModBlocks.MANGROVE_DESK.get());
        this.createDesk(ModBlocks.CRIMSON_DESK.get());
        this.createDesk(ModBlocks.WARPED_DESK.get());

        this.createDesk(ModBlocks.OAK_DESK_DRAWER.get());
        this.createDesk(ModBlocks.SPRUCE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.BIRCH_DESK_DRAWER.get());
        this.createDesk(ModBlocks.JUNGLE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.ACACIA_DESK_DRAWER.get());
        this.createDesk(ModBlocks.CHERRY_DESK_DRAWER.get());
        this.createDesk(ModBlocks.DARK_OAK_DESK_DRAWER.get());
        this.createDesk(ModBlocks.MANGROVE_DESK_DRAWER.get());
        this.createDesk(ModBlocks.CRIMSON_DESK_DRAWER.get());
        this.createDesk(ModBlocks.WARPED_DESK_DRAWER.get());

        this.apply(ModBlocks.FABRIC_DESK_LAMPS, this::createDeskLamp);

        this.apply(ModBlocks.CLOSED_CURTAINS, block -> this.createCurtain(block, ModBlockStateProperties.CLOSED_CURTAIN_PART));
        this.apply(ModBlocks.OPEN_CURTAINS, block -> this.createCurtain(block, ModBlockStateProperties.OPEN_CURTAIN_PART));
    }

    private <T extends Block> void apply(BlockEntrySet<T, ?> set, Consumer<T> consumer) {
        for (BlockRegistryEntry<T> entry : set.values()) {
            consumer.accept(entry.get());
        }
    }

    private <T extends Block, K extends Enum<K> & StringRepresentable> void apply(BlockEntrySet<T, K> set, BiConsumer<T, K> consumer) {
        for (Map.Entry<K, BlockRegistryEntry<T>> entry : set.entrySet()) {
            consumer.accept(entry.getValue().get(), entry.getKey());
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
            return drawer ? ModModelTemplates.DESK_DRAWER_RIGHT : ModModelTemplates.DESK_RIGHT;
        } else if (right) {
            return drawer ? ModModelTemplates.DESK_DRAWER_LEFT : ModModelTemplates.DESK_LEFT;
        } else {
            return drawer ? ModModelTemplates.DESK_DRAWER : ModModelTemplates.DESK;
        }
    }

    private void createDeskLamp(FabricDeskLampBlock block, DyeColor color) {
        TextureMapping textureMapping = new TextureMapping().put(ModTextureSlots.COLOR, new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/fabric_desk_lamp/colors/" + color.getName()));

        ResourceLocation model = ModModelTemplates.FABRIC_DESK_LAMP.create(block, textureMapping, this.modelOutput);
        ResourceLocation modelOn = ModModelTemplates.FABRIC_DESK_LAMP_ON.createWithSuffix(block, "_rotated", textureMapping, this.modelOutput);

        this.createSimpleFlatItemModel(block.asItem());
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createBooleanModelDispatch(ModBlockStateProperties.SWITCHED_ON, modelOn, model)));
    }

    private void createCurtain(AbstractCurtainBlock<?> block, EnumProperty<? extends CurtainPart> property) {
        for (CurtainPart part : property.getPossibleValues()) {
            if (part.getModelTemplate() == null) {
                continue;
            }

            String folder = "curtain/" + block.getColor().getName();
            TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TOP, ModTextureMapping.getBlockTexture(folder, part.getTopTexture())).put(TextureSlot.DOWN, ModTextureMapping.getBlockTexture(folder, part.getBottomTexture()));
            part.getModelTemplate().createWithSuffix(block, part.getModelName(), textureMapping, this.modelOutput);
        }

        PropertyDispatch dispatch = PropertyDispatch.property(property).generate(part -> {
            ResourceLocation model = BuiltInRegistries.BLOCK.getKey(block).withPath(s -> "block/" + s + part.getModelName());

            if (part.getModelTemplate() == null) {
                model = new ResourceLocation(ValhelsiaFurniture.MOD_ID, "block/curtain/curtain_bracket");
            }

            return Variant.variant().with(VariantProperties.MODEL, model);
        });

        if (block instanceof ClosedCurtainBlock) {
            this.delegateItemModel(block, ModelLocationUtils.getModelLocation(block, "_single"));
        }
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createHorizontalFacingDispatch()).with(dispatch));
    }

    //TODO: move into core
    private static MultiVariantGenerator createSimpleBlock(Block block, ResourceLocation resourceLocation) {
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation));
    }

    private static PropertyDispatch createRotatedDispatch(ResourceLocation model) {
        return PropertyDispatch.property(ModBlockStateProperties.ROTATED).select(false, Variant.variant()).select(true, Variant.variant().with(VariantProperties.MODEL, model));
    }

    //TODO: move into core
    void createSimpleFlatItemModel(Item item) {
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(item), this.modelOutput);
    }

    //TODO: move into core
    void delegateItemModel(Block block, ResourceLocation resourceLocation) {
        this.modelOutput.accept(ModelLocationUtils.getModelLocation(block.asItem()), new DelegatedModel(resourceLocation));
    }
}
