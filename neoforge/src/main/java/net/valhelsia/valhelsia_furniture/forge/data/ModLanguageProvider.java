package net.valhelsia.valhelsia_furniture.forge.data;

import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Valhelsia Team
 * @since 2023-06-11
 */
public class ModLanguageProvider extends LanguageProvider {

    public static final Map<DyeColor, String> COLOR_TO_STRING = Util.make(new EnumMap<>(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, "White");
        map.put(DyeColor.ORANGE, "Orange");
        map.put(DyeColor.MAGENTA, "Magenta");
        map.put(DyeColor.LIGHT_BLUE, "Light Blue");
        map.put(DyeColor.YELLOW, "Yellow");
        map.put(DyeColor.LIME, "Lime");
        map.put(DyeColor.PINK, "Pink");
        map.put(DyeColor.GRAY, "Gray");
        map.put(DyeColor.LIGHT_GRAY, "Light Gray");
        map.put(DyeColor.CYAN, "Cyan");
        map.put(DyeColor.PURPLE, "Purple");
        map.put(DyeColor.BLUE, "Blue");
        map.put(DyeColor.BROWN, "Brown");
        map.put(DyeColor.GREEN, "Green");
        map.put(DyeColor.RED, "Red");
        map.put(DyeColor.BLACK, "Black");
    });

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, ValhelsiaFurniture.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.valhelsia_furniture", "Valhelsia Furniture");

        this.add(ModBlocks.OAK_TABLE.get(), "Oak Table");
        this.add(ModBlocks.SPRUCE_TABLE.get(), "Spruce Table");
        this.add(ModBlocks.BIRCH_TABLE.get(), "Birch Table");
        this.add(ModBlocks.JUNGLE_TABLE.get(), "Jungle Table");
        this.add(ModBlocks.ACACIA_TABLE.get(), "Acacia Table");
        this.add(ModBlocks.CHERRY_TABLE.get(), "Cherry Table");
        this.add(ModBlocks.DARK_OAK_TABLE.get(), "Dark Oak Table");
        this.add(ModBlocks.MANGROVE_TABLE.get(), "Mangrove Table");
        this.add(ModBlocks.CRIMSON_TABLE.get(), "Crimson Table");
        this.add(ModBlocks.WARPED_TABLE.get(), "Warped Table");

        this.add(ModBlocks.OAK_CHAIR.get(), "Oak Chair");
        this.add(ModBlocks.SPRUCE_CHAIR.get(), "Spruce Chair");
        this.add(ModBlocks.BIRCH_CHAIR.get(), "Birch Chair");
        this.add(ModBlocks.JUNGLE_CHAIR.get(), "Jungle Chair");
        this.add(ModBlocks.ACACIA_CHAIR.get(), "Acacia Chair");
        this.add(ModBlocks.CHERRY_CHAIR.get(), "Cherry Chair");
        this.add(ModBlocks.DARK_OAK_CHAIR.get(), "Dark Oak Chair");
        this.add(ModBlocks.MANGROVE_CHAIR.get(), "Mangrove Chair");
        this.add(ModBlocks.CRIMSON_CHAIR.get(), "Crimson Chair");
        this.add(ModBlocks.WARPED_CHAIR.get(), "Warped Chair");

        this.add("block.valhelsia_furniture.upholstered_oak_chair", "Upholstered Oak Chair");
        this.add("block.valhelsia_furniture.upholstered_spruce_chair", "Upholstered Spruce Chair");
        this.add("block.valhelsia_furniture.upholstered_birch_chair", "Upholstered Birch Chair");
        this.add("block.valhelsia_furniture.upholstered_jungle_chair", "Upholstered Jungle Chair");
        this.add("block.valhelsia_furniture.upholstered_acacia_chair", "Upholstered Acacia Chair");
        this.add("block.valhelsia_furniture.upholstered_cherry_chair", "Upholstered Cherry Chair");
        this.add("block.valhelsia_furniture.upholstered_dark_oak_chair", "Upholstered Dark Oak Chair");
        this.add("block.valhelsia_furniture.upholstered_mangrove_chair", "Upholstered Mangrove Chair");
        this.add("block.valhelsia_furniture.upholstered_crimson_chair", "Upholstered Crimson Chair");
        this.add("block.valhelsia_furniture.upholstered_warped_chair", "Upholstered Warped Chair");

        this.add(ModBlocks.OAK_STOOL.get(), "Oak Stool");
        this.add(ModBlocks.SPRUCE_STOOL.get(), "Spruce Stool");
        this.add(ModBlocks.BIRCH_STOOL.get(), "Birch Stool");
        this.add(ModBlocks.JUNGLE_STOOL.get(), "Jungle Stool");
        this.add(ModBlocks.ACACIA_STOOL.get(), "Acacia Stool");
        this.add(ModBlocks.CHERRY_STOOL.get(), "Cherry Stool");
        this.add(ModBlocks.DARK_OAK_STOOL.get(), "Dark Oak Stool");
        this.add(ModBlocks.MANGROVE_STOOL.get(), "Mangrove Stool");
        this.add(ModBlocks.CRIMSON_STOOL.get(), "Crimson Stool");
        this.add(ModBlocks.WARPED_STOOL.get(), "Warped Stool");

        this.add(ModBlocks.OAK_DESK.get(), "Oak Desk");
        this.add(ModBlocks.SPRUCE_DESK.get(), "Spruce Desk");
        this.add(ModBlocks.BIRCH_DESK.get(), "Birch Desk");
        this.add(ModBlocks.JUNGLE_DESK.get(), "Jungle Desk");
        this.add(ModBlocks.ACACIA_DESK.get(), "Acacia Desk");
        this.add(ModBlocks.CHERRY_DESK.get(), "Cherry Desk");
        this.add(ModBlocks.DARK_OAK_DESK.get(), "Dark Oak Desk");
        this.add(ModBlocks.MANGROVE_DESK.get(), "Mangrove Desk");
        this.add(ModBlocks.CRIMSON_DESK.get(), "Crimson Desk");
        this.add(ModBlocks.WARPED_DESK.get(), "Warped Desk");

        this.add(ModBlocks.OAK_DESK_DRAWER.get(), "Oak Desk Drawer");
        this.add(ModBlocks.SPRUCE_DESK_DRAWER.get(), "Spruce Desk Drawer");
        this.add(ModBlocks.BIRCH_DESK_DRAWER.get(), "Birch Desk Drawer");
        this.add(ModBlocks.JUNGLE_DESK_DRAWER.get(), "Jungle Desk Drawer");
        this.add(ModBlocks.ACACIA_DESK_DRAWER.get(), "Acacia Desk Drawer");
        this.add(ModBlocks.CHERRY_DESK_DRAWER.get(), "Cherry Desk Drawer");
        this.add(ModBlocks.DARK_OAK_DESK_DRAWER.get(), "Dark Oak Desk Drawer");
        this.add(ModBlocks.MANGROVE_DESK_DRAWER.get(), "Mangrove Desk Drawer");
        this.add(ModBlocks.CRIMSON_DESK_DRAWER.get(), "Crimson Desk Drawer");
        this.add(ModBlocks.WARPED_DESK_DRAWER.get(), "Warped Desk Drawer");

        ModBlocks.FABRIC_DESK_LAMPS.forEach((color, entry) -> {
            this.add(entry.get(), "");
        });

        for (DyeColor color : DyeColor.values()) {
            String name = COLOR_TO_STRING.get(color);

            this.add(String.format("tooltip.valhelsia_furniture.%s_tablecloth", color.getName()), String.format("%s Tablecloth", name));
            this.add(String.format("tooltip.valhelsia_furniture.%s_wool_seat", color.getName()), String.format("%s Wool Seat", name));
        }

        this.add("tooltip.valhelsia_furniture.hay_seat", "Hay Seat");
        this.add("container.valhelsia_furniture.desk_drawer", "Desk Drawer");
    }
}
