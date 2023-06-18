package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-18
 */
public class TableclothTableBlock extends TableBlock {

    private final Supplier<Block> baseTable;
    private final DyeColor color;

    public TableclothTableBlock(Supplier<Block> baseTable, DyeColor color, WoodType woodType, Properties properties) {
        super(woodType, properties);
        this.baseTable = baseTable;
        this.color = color;
    }

    @Override
    public @NotNull String getDescriptionId() {
        return this.baseTable.get().getDescriptionId();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.valhelsia_furniture." + this.color + "_tablecloth").withStyle(ChatFormatting.GRAY));
    }
}
