package net.valhelsia.valhelsia_furniture.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.valhelsia.valhelsia_furniture.common.block.DeskDrawerBlock;
import net.valhelsia.valhelsia_furniture.core.registry.ModBlockEntities;

import javax.annotation.Nonnull;

/**
 * @author Valhelsia Team
 * @since 2022-09-03
 */
public class DeskDrawerBlockEntity extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state) {
            DeskDrawerBlockEntity.this.playSound(state, SoundEvents.BARREL_OPEN);
        }

        @Override
        protected void onClose(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state) {
            DeskDrawerBlockEntity.this.playSound(state, SoundEvents.BARREL_CLOSE);
        }

        @Override
        protected void openerCountChanged(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state, int count, int openCount) {
        }

        @Override
        protected boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu menu) {
                Container container = menu.getContainer();
                return container == DeskDrawerBlockEntity.this;
            } else {
                return false;
            }
        }
    };

    public DeskDrawerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DESK_DRAWER.get(), pos, state);
    }

    @Nonnull
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@Nonnull NonNullList<ItemStack> itemStacks) {
        this.items = itemStacks;
    }

    @Nonnull
    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.valhelsia_furniture.desk_drawer");
    }

    @Nonnull
    @Override
    protected AbstractContainerMenu createMenu(int id, @Nonnull Inventory inventory) {
        return new ChestMenu(MenuType.GENERIC_9x1, id, inventory, this, 1);
    }

    @Override
    protected void saveAdditional(@Nonnull CompoundTag tag) {
        super.saveAdditional(tag);

        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items);
        }
    }

    @Override
    public void load(@Nonnull CompoundTag tag) {
        super.load(tag);

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return 9;
    }

    @Override
    public void startOpen(@Nonnull Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    @Override
    public void stopOpen(@Nonnull Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    private void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = state.getValue(DeskDrawerBlock.FACING).getNormal();
        double d0 = this.worldPosition.getX() + 0.5D + vec3i.getX() / 2.0D;
        double d1 = this.worldPosition.getY() + 0.5D + vec3i.getY() / 2.0D;
        double d2 = this.worldPosition.getZ() + 0.5D + vec3i.getZ() / 2.0D;

        this.level.playSound(null, d0, d1, d2, soundEvent, SoundSource.BLOCKS, 0.5F, this.level.getRandom().nextFloat() * 0.1F + 0.9F);
    }
}
