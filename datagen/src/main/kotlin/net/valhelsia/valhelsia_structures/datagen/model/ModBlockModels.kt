package net.valhelsia.valhelsia_structures.datagen.model

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.blockstates.MultiVariantGenerator
import net.minecraft.data.models.blockstates.PropertyDispatch
import net.minecraft.data.models.blockstates.Variant
import net.minecraft.data.models.blockstates.VariantProperties
import net.minecraft.data.models.model.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.StringRepresentable
import net.minecraft.world.item.DyeColor
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.valhelsia.dataforge.model.BlockModelGenerator
import net.valhelsia.dataforge.model.createModel
import net.valhelsia.valhelsia_core.api.common.registry.helper.block.BlockEntrySet
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture
import net.valhelsia.valhelsia_furniture.common.block.*
import net.valhelsia.valhelsia_furniture.common.block.properties.CurtainPart
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks
import net.valhelsia.valhelsia_furniture.datagen.models.ModModelTemplates
import net.valhelsia.valhelsia_furniture.datagen.models.ModTextureSlots
import kotlin.Enum

class ModBlockModels(defaultGenerators: BlockModelGenerators) : BlockModelGenerator(defaultGenerators) {
    override fun generate() {
        createTable(ModBlocks.OAK_TABLE.get())
        createTable(ModBlocks.SPRUCE_TABLE.get())
        createTable(ModBlocks.BIRCH_TABLE.get())
        createTable(ModBlocks.JUNGLE_TABLE.get())
        createTable(ModBlocks.ACACIA_TABLE.get())
        createTable(ModBlocks.CHERRY_TABLE.get())
        createTable(ModBlocks.DARK_OAK_TABLE.get())
        createTable(ModBlocks.MANGROVE_TABLE.get())
        createTable(ModBlocks.CRIMSON_TABLE.get())
        createTable(ModBlocks.WARPED_TABLE.get())

        apply(ModBlocks.COLORED_OAK_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_SPRUCE_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_BIRCH_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_JUNGLE_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_ACACIA_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_CHERRY_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_DARK_OAK_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_MANGROVE_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_CRIMSON_TABLES) { createTable(it) }
        apply(ModBlocks.COLORED_WARPED_TABLES) { createTable(it) }

        createChair(ModBlocks.OAK_CHAIR.get())
        createChair(ModBlocks.SPRUCE_CHAIR.get())
        createChair(ModBlocks.BIRCH_CHAIR.get())
        createChair(ModBlocks.JUNGLE_CHAIR.get())
        createChair(ModBlocks.ACACIA_CHAIR.get())
        createChair(ModBlocks.CHERRY_CHAIR.get())
        createChair(ModBlocks.DARK_OAK_CHAIR.get())
        createChair(ModBlocks.MANGROVE_CHAIR.get())
        createChair(ModBlocks.CRIMSON_CHAIR.get())
        createChair(ModBlocks.WARPED_CHAIR.get())

        createChair(ModBlocks.HAY_OAK_CHAIR.get())
        createChair(ModBlocks.HAY_SPRUCE_CHAIR.get())
        createChair(ModBlocks.HAY_BIRCH_CHAIR.get())
        createChair(ModBlocks.HAY_JUNGLE_CHAIR.get())
        createChair(ModBlocks.HAY_ACACIA_CHAIR.get())
        createChair(ModBlocks.HAY_CHERRY_CHAIR.get())
        createChair(ModBlocks.HAY_DARK_OAK_CHAIR.get())
        createChair(ModBlocks.HAY_MANGROVE_CHAIR.get())
        createChair(ModBlocks.HAY_CRIMSON_CHAIR.get())
        createChair(ModBlocks.HAY_WARPED_CHAIR.get())

        apply(ModBlocks.WOOL_OAK_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_SPRUCE_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_BIRCH_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_JUNGLE_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_ACACIA_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_CHERRY_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_DARK_OAK_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_MANGROVE_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_CRIMSON_CHAIRS) { createChair(it) }
        apply(ModBlocks.WOOL_WARPED_CHAIRS) { createChair(it) }

        apply(ModBlocks.WOOL_UPHOLSTERED_OAK_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_CHERRY_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_CHAIRS) { createUpholsteredChair(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_CHAIRS) { createUpholsteredChair(it) }

        createStool(ModBlocks.OAK_STOOL.get())
        createStool(ModBlocks.SPRUCE_STOOL.get())
        createStool(ModBlocks.BIRCH_STOOL.get())
        createStool(ModBlocks.JUNGLE_STOOL.get())
        createStool(ModBlocks.ACACIA_STOOL.get())
        createStool(ModBlocks.CHERRY_STOOL.get())
        createStool(ModBlocks.DARK_OAK_STOOL.get())
        createStool(ModBlocks.MANGROVE_STOOL.get())
        createStool(ModBlocks.CRIMSON_STOOL.get())
        createStool(ModBlocks.WARPED_STOOL.get())

        apply(ModBlocks.WOOL_UPHOLSTERED_OAK_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_SPRUCE_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_BIRCH_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_JUNGLE_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_ACACIA_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_CHERRY_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_DARK_OAK_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_MANGROVE_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_CRIMSON_STOOLS) { createUpholsteredStool(it) }
        apply(ModBlocks.WOOL_UPHOLSTERED_WARPED_STOOLS) { createUpholsteredStool(it) }

        createDesk(ModBlocks.OAK_DESK.get())
        createDesk(ModBlocks.SPRUCE_DESK.get())
        createDesk(ModBlocks.BIRCH_DESK.get())
        createDesk(ModBlocks.JUNGLE_DESK.get())
        createDesk(ModBlocks.ACACIA_DESK.get())
        createDesk(ModBlocks.CHERRY_DESK.get())
        createDesk(ModBlocks.DARK_OAK_DESK.get())
        createDesk(ModBlocks.MANGROVE_DESK.get())
        createDesk(ModBlocks.CRIMSON_DESK.get())
        createDesk(ModBlocks.WARPED_DESK.get())

        createDesk(ModBlocks.OAK_DESK_DRAWER.get())
        createDesk(ModBlocks.SPRUCE_DESK_DRAWER.get())
        createDesk(ModBlocks.BIRCH_DESK_DRAWER.get())
        createDesk(ModBlocks.JUNGLE_DESK_DRAWER.get())
        createDesk(ModBlocks.ACACIA_DESK_DRAWER.get())
        createDesk(ModBlocks.CHERRY_DESK_DRAWER.get())
        createDesk(ModBlocks.DARK_OAK_DESK_DRAWER.get())
        createDesk(ModBlocks.MANGROVE_DESK_DRAWER.get())
        createDesk(ModBlocks.CRIMSON_DESK_DRAWER.get())
        createDesk(ModBlocks.WARPED_DESK_DRAWER.get())

        apply(ModBlocks.FABRIC_DESK_LAMPS) { entry, color -> createDeskLamp(entry, color) }
        apply(ModBlocks.CLOSED_CURTAINS) { createCurtain(it, ModBlockStateProperties.CLOSED_CURTAIN_PART) }
        apply(ModBlocks.OPEN_CURTAINS) { createCurtain(it, ModBlockStateProperties.OPEN_CURTAIN_PART) }
    }

    private fun <T : Block> apply(set: BlockEntrySet<T, *>, consumer: (T) -> Unit) {
        for (entry in set.values) {
            consumer(entry.get())
        }
    }

    private fun <T : Block, K> apply(set: BlockEntrySet<T, K>, consumer: (T, K) -> Unit) where K : Enum<K>, K : StringRepresentable {
        for (entry in set.entries) {
            consumer(entry.value.get(), entry.key)
        }
    }

    private fun createTable(block: TableBlock) {
        val folder: String = FurnitureBlock.Type.TABLE.serializedName + "/" + block.woodType.name()
        val textureMapping: TextureMapping =
            TextureMapping().put(ModTextureSlots.TABLE, ModTextureMapping.getBlockTexture(block, folder)).put(
                ModTextureSlots.CONNECTED_TABLE,
                ModTextureMapping.getBlockTexture(block, folder, "_connected")
            )

        createTableModels(block, textureMapping)

        val dispatch: PropertyDispatch = PropertyDispatch.properties(
            BlockStateProperties.NORTH,
            BlockStateProperties.EAST,
            BlockStateProperties.SOUTH,
            BlockStateProperties.WEST,
            ModBlockStateProperties.ROTATED
        ).generate { north, east, south, west, rotated ->
            val connected = north || east || south || west
            val allConnected = north && east && south && west

            var suffix = if (connected) "_" else ""

            if (north) {
                suffix = if (rotated && !allConnected) (suffix + "e") else (suffix + "n")
            }
            if (east) {
                suffix = if (rotated && !allConnected) (suffix + "s") else (suffix + "e")
            }
            if (south) {
                suffix = if (rotated && !allConnected) (suffix + "w") else (suffix + "s")
            }
            if (west) {
                suffix = if (rotated && !allConnected) (suffix + "n") else (suffix + "w")
            }

            suffix = when (suffix) {
                "_esn" -> "_nes"
                "_swn" -> "_nsw"
                "_ewn" -> "_new"
                "_sn" -> "_ns"
                "_en" -> "_ne"
                "_wn" -> "_nw"
                else -> suffix
            }

            val variant: Variant = Variant.variant()
                .with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, suffix))

            if (rotated) {
                variant.with(
                    VariantProperties.Y_ROT,
                    if (!connected) VariantProperties.Rotation.R90 else VariantProperties.Rotation.R270
                )
            }
            variant
        }

        blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(dispatch))
    }

    private fun createTableModels(block: Block, mapping: TextureMapping) {
        ModModelTemplates.TABLE.create(block, mapping, modelOutput)
        ModModelTemplates.TABLE_N.createWithSuffix(block, "_n", mapping, modelOutput)
        ModModelTemplates.TABLE_E.createWithSuffix(block, "_e", mapping, modelOutput)
        ModModelTemplates.TABLE_S.createWithSuffix(block, "_s", mapping, modelOutput)
        ModModelTemplates.TABLE_W.createWithSuffix(block, "_w", mapping, modelOutput)
        ModModelTemplates.TABLE_NE.createWithSuffix(block, "_ne", mapping, modelOutput)
        ModModelTemplates.TABLE_NES.createWithSuffix(block, "_nes", mapping, modelOutput)
        ModModelTemplates.TABLE_NESW.createWithSuffix(block, "_nesw", mapping, modelOutput)
        ModModelTemplates.TABLE_NEW.createWithSuffix(block, "_new", mapping, modelOutput)
        ModModelTemplates.TABLE_NS.createWithSuffix(block, "_ns", mapping, modelOutput)
        ModModelTemplates.TABLE_NSW.createWithSuffix(block, "_nsw", mapping, modelOutput)
        ModModelTemplates.TABLE_NW.createWithSuffix(block, "_nw", mapping, modelOutput)
        ModModelTemplates.TABLE_SW.createWithSuffix(block, "_sw", mapping, modelOutput)
        ModModelTemplates.TABLE_ES.createWithSuffix(block, "_es", mapping, modelOutput)
        ModModelTemplates.TABLE_ESW.createWithSuffix(block, "_esw", mapping, modelOutput)
        ModModelTemplates.TABLE_EW.createWithSuffix(block, "_ew", mapping, modelOutput)
    }

    private fun createChair(block: ChairBlock) {
        val textureMapping: TextureMapping = TextureMapping().put(
            ModTextureSlots.CHAIR,
            ModTextureMapping.getBlockTexture(block, "chair/" + block.woodType.name())
        )
        val model: ResourceLocation = ModModelTemplates.CHAIR.create(block, textureMapping, modelOutput)

        blockStateOutput.accept(
            createSimpleBlock(
                block,
                model
            ).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createUpholsteredChair(block: UpholsteredChairBlock) {
        val textureMapping: TextureMapping = TextureMapping()
            .put(
                ModTextureSlots.WOOL,
                ResourceLocation.fromNamespaceAndPath(
                    ValhelsiaFurniture.MOD_ID,
                    "block/upholstered_chair/colors/" + block.color
                )
            )
            .put(
                ModTextureSlots.WOOD,
                ResourceLocation.fromNamespaceAndPath(
                    ValhelsiaFurniture.MOD_ID,
                    "block/upholstered_chair/base/" + block.woodType.name()
                )
            )
        val model: ResourceLocation =
            ModModelTemplates.UPHOLSTERED_CHAIR.create(block, textureMapping, modelOutput)

        blockStateOutput.accept(
            createSimpleBlock(
                block,
                model
            ).with(BlockModelGenerators.createHorizontalFacingDispatch())
        )
    }

    private fun createStool(block: Block) {
        val textureMapping: TextureMapping =
            TextureMapping().put(ModTextureSlots.STOOL, ModTextureMapping.getBlockTexture(block, "stool"))
        val model: ResourceLocation = ModModelTemplates.STOOL.create(block, textureMapping, modelOutput)
        val rotatedModel: ResourceLocation =
            ModModelTemplates.STOOL_ROTATED.createWithSuffix(block, "_rotated", textureMapping, modelOutput)

        blockStateOutput.accept(createSimpleBlock(block, model).with(createRotatedDispatch(rotatedModel)))
    }

    private fun createUpholsteredStool(block: StoolBlock) {
        val textureMapping: TextureMapping = TextureMapping()
            .put(
                ModTextureSlots.WOOD,
                ResourceLocation.fromNamespaceAndPath(
                    ValhelsiaFurniture.MOD_ID,
                    "block/upholstered_stool/base/" + block.woodType.name()
                )
            )
            .put(
                ModTextureSlots.WOOL,
                ResourceLocation.fromNamespaceAndPath(
                    ValhelsiaFurniture.MOD_ID,
                    "block/upholstered_stool/colors/" + block.color
                )
            )

        val model: ResourceLocation =
            ModModelTemplates.UPHOLSTERED_STOOL.create(block, textureMapping, modelOutput)
        val rotatedModel: ResourceLocation = ModModelTemplates.UPHOLSTERED_STOOL_ROTATED.createWithSuffix(
            block,
            "_rotated",
            textureMapping,
            modelOutput
        )

        blockStateOutput.accept(createSimpleBlock(block, model).with(createRotatedDispatch(rotatedModel)))
    }

    private fun createDesk(block: DeskBlock) {
        val dispatch: PropertyDispatch =
            PropertyDispatch.properties(ModBlockStateProperties.LEFT, ModBlockStateProperties.RIGHT)
                .generate { left, right ->
                    var variant = ""
                    if (left && right) {
                        variant = "_center"
                    } else if (left) {
                        variant = "_right"
                    } else if (right) {
                        variant = "_left"
                    }

                    val textureSlots: List<TextureSlot> = when (variant) {
                        "_left", "_right" -> DeskBlock.VARIANT_TEXTURES["left_or_right"]
                        "_center" -> DeskBlock.VARIANT_TEXTURES["center"]
                        else -> DeskBlock.VARIANT_TEXTURES["single"]
                    } ?: listOf()

                    val textureMapping = TextureMapping()

                    for (slot in textureSlots) {
                        textureMapping.put(
                            slot,
                            ResourceLocation.fromNamespaceAndPath(
                                ValhelsiaFurniture.MOD_ID,
                                "block/desk/" + block.woodType.name() + "/" + slot.id
                            )
                        )
                    }

                    val model: ResourceLocation = getDeskModel(left, right, block is DeskDrawerBlock)
                        .createWithSuffix(block, variant, textureMapping, modelOutput)
                    Variant.variant().with(VariantProperties.MODEL, model)
                }

        blockStateOutput.accept(
            MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(dispatch)
        )
    }

    private fun getDeskModel(left: Boolean, right: Boolean, drawer: Boolean): ModelTemplate {
        return if (left && right) {
            if (drawer) ModModelTemplates.DESK_DRAWER_CENTER else ModModelTemplates.DESK_CENTER
        } else if (left) {
            if (drawer) ModModelTemplates.DESK_DRAWER_RIGHT else ModModelTemplates.DESK_RIGHT
        } else if (right) {
            if (drawer) ModModelTemplates.DESK_DRAWER_LEFT else ModModelTemplates.DESK_LEFT
        } else {
            if (drawer) ModModelTemplates.DESK_DRAWER else ModModelTemplates.DESK
        }
    }

    private fun createDeskLamp(block: FabricDeskLampBlock, color: DyeColor) {
        val textureMapping: TextureMapping = TextureMapping().put(
            ModTextureSlots.COLOR,
            ResourceLocation.fromNamespaceAndPath(
                ValhelsiaFurniture.MOD_ID,
                "block/fabric_desk_lamp/colors/" + color.serializedName
            )
        )

        val model: ResourceLocation =
            ModModelTemplates.FABRIC_DESK_LAMP.create(block, textureMapping, modelOutput)
        val modelOn: ResourceLocation = ModModelTemplates.FABRIC_DESK_LAMP_ON.createWithSuffix(
            block,
            "_rotated",
            textureMapping,
            modelOutput
        )

        createSimpleFlatItemModel(block.asItem())
        blockStateOutput.accept(
            MultiVariantGenerator.multiVariant(block).with(
                BlockModelGenerators.createBooleanModelDispatch(
                    ModBlockStateProperties.SWITCHED_ON,
                    modelOn,
                    model
                )
            )
        )
    }

    private fun <E> createCurtain(
        block: AbstractCurtainBlock<*>,
        property: EnumProperty<E>
    ) where E : Enum<E>, E : CurtainPart {
        for (part in property.getPossibleValues()) {
            if (part.modelTemplate == null) {
                continue
            }

            val folder = "curtain/" + block.color.serializedName
            val textureMapping: TextureMapping = TextureMapping().put(
                TextureSlot.TOP,
                ModTextureMapping.getBlockTexture(folder, part.topTexture)
            ).put(TextureSlot.DOWN, ModTextureMapping.getBlockTexture(folder, part.bottomTexture))
            part.modelTemplate?.createWithSuffix(block, part.modelName, textureMapping, modelOutput)
        }

        val dispatch: PropertyDispatch = PropertyDispatch.property(property).generate { part ->
            var model: ResourceLocation =
                BuiltInRegistries.BLOCK.getKey(block).withPath { s -> "block/" + s + part.modelName }
            if (part.modelTemplate == null) {
                model = ResourceLocation.fromNamespaceAndPath(
                    ValhelsiaFurniture.MOD_ID,
                    "block/curtain/curtain_bracket"
                )
            }
            Variant.variant().with(VariantProperties.MODEL, model)
        }

        if (block is ClosedCurtainBlock) {
            delegateItemModel(block, ModelLocationUtils.getModelLocation(block, "_single"))
        }
        blockStateOutput.accept(
            MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(dispatch)
        )
    }

    private fun delegateItemModel(block: Block, resourceLocation: ResourceLocation) {
        modelOutput.accept(ModelLocationUtils.getModelLocation(block.asItem()), DelegatedModel(resourceLocation))
    }

    companion object {
        private fun createSimpleBlock(block: Block, resourceLocation: ResourceLocation): MultiVariantGenerator =
            MultiVariantGenerator.multiVariant(
                block,
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
            )

        private fun createRotatedDispatch(model: ResourceLocation): PropertyDispatch = PropertyDispatch
            .property(ModBlockStateProperties.ROTATED)
            .select(false, Variant.variant())
            .select(true, Variant.variant().with(VariantProperties.MODEL, model))

        private fun createSimpleFlatItemModel(item: ItemLike) = ModelTemplates.FLAT_ITEM.createModel(
            ModelLocationUtils.getModelLocation(item.asItem()),
            TextureMapping.layer0(item.asItem())
        )
    }
}
