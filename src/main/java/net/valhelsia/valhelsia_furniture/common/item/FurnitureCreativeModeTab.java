package net.valhelsia.valhelsia_furniture.common.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.valhelsia.valhelsia_furniture.ValhelsiaFurniture;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlocks;

import javax.annotation.Nonnull;

/**
 * @author Valhelsia Team
 * @since 2022-09-03
 */
public class FurnitureCreativeModeTab extends CreativeModeTab {

    public FurnitureCreativeModeTab() {
        super(ValhelsiaFurniture.MOD_ID);
    }

    @Nonnull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModBlocks.HAY_OAK_CHAIR.get());
    }
}
