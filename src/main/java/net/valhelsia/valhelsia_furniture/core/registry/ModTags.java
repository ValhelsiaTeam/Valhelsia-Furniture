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

        public static final TagKey<Block> OAK_TABLES = modTag("oak_tables");
        public static final TagKey<Block> SPRUCE_TABLES = modTag("spruce_tables");
        public static final TagKey<Block> BIRCH_TABLES = modTag("birch_tables");
        public static final TagKey<Block> JUNGLE_TABLES = modTag("jungle_tables");
        public static final TagKey<Block> ACACIA_TABLES = modTag("acacia_tables");
        public static final TagKey<Block> DARK_OAK_TABLES = modTag("dark_oak_tables");
        public static final TagKey<Block> CRIMSON_TABLES = modTag("crimson_tables");
        public static final TagKey<Block> WARPED_TABLES = modTag("warped_tables");
        public static final TagKey<Block> TABLES = modTag("tables");

        public static final TagKey<Block> OAK_CHAIRS = modTag("oak_chairs");
        public static final TagKey<Block> SPRUCE_CHAIRS = modTag("spruce_chairs");
        public static final TagKey<Block> BIRCH_CHAIRS = modTag("birch_chairs");
        public static final TagKey<Block> JUNGLE_CHAIRS = modTag("jungle_chairs");
        public static final TagKey<Block> ACACIA_CHAIRS = modTag("acacia_chairs");
        public static final TagKey<Block> DARK_OAK_CHAIRS = modTag("dark_oak_chairs");
        public static final TagKey<Block> CRIMSON_CHAIRS = modTag("crimson_chairs");
        public static final TagKey<Block> WARPED_CHAIRS = modTag("warped_chairs");
        public static final TagKey<Block> CHAIRS = modTag("chairs");

        public static final TagKey<Block> UPHOLSTERED_OAK_CHAIRS = modTag("upholstered_oak_chairs");
        public static final TagKey<Block> UPHOLSTERED_SPRUCE_CHAIRS = modTag("upholstered_spruce_chairs");
        public static final TagKey<Block> UPHOLSTERED_BIRCH_CHAIRS = modTag("upholstered_birch_chairs");
        public static final TagKey<Block> UPHOLSTERED_JUNGLE_CHAIRS = modTag("upholstered_jungle_chairs");
        public static final TagKey<Block> UPHOLSTERED_ACACIA_CHAIRS = modTag("upholstered_acacia_chairs");
        public static final TagKey<Block> UPHOLSTERED_DARK_OAK_CHAIRS = modTag("upholstered_dark_oak_chairs");
        public static final TagKey<Block> UPHOLSTERED_CRIMSON_CHAIRS = modTag("upholstered_crimson_chairs");
        public static final TagKey<Block> UPHOLSTERED_WARPED_CHAIRS = modTag("upholstered_warped_chairs");
        public static final TagKey<Block> UPHOLSTERED_CHAIRS = modTag("upholstered_chairs");

        public static final TagKey<Block> STOOLS = modTag("stools");

        public static final TagKey<Block> UPHOLSTERED_OAK_STOOLS = modTag("upholstered_oak_stools");
        public static final TagKey<Block> UPHOLSTERED_SPRUCE_STOOLS = modTag("upholstered_spruce_stools");
        public static final TagKey<Block> UPHOLSTERED_BIRCH_STOOLS = modTag("upholstered_birch_stools");
        public static final TagKey<Block> UPHOLSTERED_JUNGLE_STOOLS= modTag("upholstered_jungle_stools");
        public static final TagKey<Block> UPHOLSTERED_ACACIA_STOOLS = modTag("upholstered_acacia_stools");
        public static final TagKey<Block> UPHOLSTERED_DARK_OAK_STOOLS = modTag("upholstered_dark_oak_stools");
        public static final TagKey<Block> UPHOLSTERED_CRIMSON_STOOLS = modTag("upholstered_crimson_stools");
        public static final TagKey<Block> UPHOLSTERED_WARPED_STOOLS = modTag("upholstered_warped_stools");
        public static final TagKey<Block> UPHOLSTERED_STOOLS = modTag("upholstered_stools");

        public static final TagKey<Block> OAK_DESKS = modTag("oak_desks");
        public static final TagKey<Block> SPRUCE_DESKS = modTag("spruce_desks");
        public static final TagKey<Block> BIRCH_DESKS = modTag("birch_desks");
        public static final TagKey<Block> JUNGLE_DESKS = modTag("jungle_desks");
        public static final TagKey<Block> ACACIA_DESKS = modTag("acacia_desks");
        public static final TagKey<Block> DARK_OAK_DESKS = modTag("dark_oak_desks");
        public static final TagKey<Block> CRIMSON_DESKS = modTag("crimson_desks");
        public static final TagKey<Block> WARPED_DESKS = modTag("warped_desks");
        public static final TagKey<Block> DESKS = modTag("desks");
        public static final TagKey<Block> FABRIC_DESK_LAMPS = modTag("fabric_desk_lamps");
        public static final TagKey<Block> CURTAINS = modTag("curtains");

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
        public static final TagKey<Item> FABRIC_DESK_LAMPS = modTag("fabric_desk_lamps");

        private static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
        }

        private static TagKey<Item> modTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ValhelsiaFurniture.MOD_ID, name));
        }
    }
}
