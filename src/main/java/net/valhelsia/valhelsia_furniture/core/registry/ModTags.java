package net.valhelsia.valhelsia_furniture.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;

/**
 * Mod Tags <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.core.registry.ModTags
 *
 * @author Valhelsia Team
 * @version 1.18.2 - 0.1.0
 * @since 2022-05-15
 */
public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> OAK_DESKS = modTag("oak_desks");
        public static final TagKey<Block> SPRUCE_DESKS = modTag("spruce_desks");
        public static final TagKey<Block> BIRCH_DESKS = modTag("birch_desks");
        public static final TagKey<Block> JUNGLE_DESKS = modTag("jungle_desks");
        public static final TagKey<Block> ACACIA_DESKS = modTag("acacia_desks");
        public static final TagKey<Block> DARK_OAK_DESKS = modTag("dark_oak_desks");
        public static final TagKey<Block> CRIMSON_DESKS = modTag("crimson_desks");
        public static final TagKey<Block> WARPED_DESKS = modTag("warped_desks");
        public static final TagKey<Block> DESKS = modTag("desks");

        private static TagKey<Block> forgeTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", name));
        }

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ValhelsiaFurniture.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> OAK_DESKS = modTag("oak_desks");
        public static final TagKey<Item> SPRUCE_DESKS = modTag("spruce_desks");
        public static final TagKey<Item> BIRCH_DESKS = modTag("birch_desks");
        public static final TagKey<Item> JUNGLE_DESKS = modTag("jungle_desks");
        public static final TagKey<Item> ACACIA_DESKS = modTag("acacia_desks");
        public static final TagKey<Item> DARK_OAK_DESKS = modTag("dark_oak_desks");
        public static final TagKey<Item> CRIMSON_DESKS = modTag("crimson_desks");
        public static final TagKey<Item> WARPED_DESKS = modTag("warped_desks");
        public static final TagKey<Item> DESKS = modTag("desks");

        private static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
        }

        private static TagKey<Item> modTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ValhelsiaFurniture.MOD_ID, name));
        }
    }
}
