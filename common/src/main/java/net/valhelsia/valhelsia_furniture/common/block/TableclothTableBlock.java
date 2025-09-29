package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-18
 */
public class TableclothTableBlock extends TableBlock {

    private final DyeColor color;

    public TableclothTableBlock(Supplier<TableBlock> baseTable, DyeColor color, WoodType woodType, Properties properties) {
        super(woodType, properties.overrideDescription(baseTable.get().getDescriptionId()));
        this.color = color;
    }

    //TODO
//    @Override
//    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
//        list.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_tablecloth").withStyle(ChatFormatting.GRAY));
//    }

    public DyeColor getColor() {
        return this.color;
    }
}
