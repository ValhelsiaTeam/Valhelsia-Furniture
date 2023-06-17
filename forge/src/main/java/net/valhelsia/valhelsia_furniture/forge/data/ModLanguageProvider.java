package net.valhelsia.valhelsia_furniture.forge.data;

import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
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
        this.add(ModBlocks.DARK_OAK_TABLE.get(), "Dark Oak Table");
        this.add(ModBlocks.MANGROVE_TABLE.get(), "Mangrove Table");
        this.add(ModBlocks.CRIMSON_TABLE.get(), "Crimson Table");
        this.add(ModBlocks.WARPED_TABLE.get(), "Warped Table");

        for (DyeColor color : DyeColor.values()) {
            String name = COLOR_TO_STRING.get(color);

            this.add(String.format("tooltip.valhelsia_furniture.%s_tablecloth", color.getName()), String.format("%s Tablecloth", name));
            this.add(String.format("tooltip.valhelsia_furniture.%s_wool_seat", color.getName()), String.format("%s Wool Seat", name));
        }

        this.add("tooltip.valhelsia_furniture.hay_seat", "Hay Seat");
        this.add("container.valhelsia_furniture.desk_drawer", "Desk Drawer");
    }
}
