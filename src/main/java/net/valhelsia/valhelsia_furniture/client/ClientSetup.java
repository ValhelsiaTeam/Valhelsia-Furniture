package net.valhelsia.valhelsia_furniture.client;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valhelsia.valhelsia_core.client.util.combiner.BlockCombiner;
import net.valhelsia.valhelsia_furniture.common.block.properties.ModBlockStateProperties;
import net.valhelsia.valhelsia_furniture.core.registry.ModTags;

import java.util.ArrayList;
import java.util.List;

/**
 * Client Setup <br>
 * Valhelsia Furniture - net.valhelsia.valhelsia_furniture.client.ClientSetup
 *
 * @author Valhelsia Team
 * @version 1.19 - 0.1.0
 * @since 2022-01-22
 */
public class ClientSetup {

    public ClientSetup() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onClientSetup);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        BlockCombiner.registerBrightnessCombiner(state -> state.is(ModTags.Blocks.DESKS), (level, state, pos) -> {
            List<BlockPos> list = new ArrayList<>();
            Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

            list.add(pos);

            if (state.getValue(ModBlockStateProperties.LEFT)) {
                BlockPos relativePos = pos.relative(facing.getClockWise());

                list.add(relativePos);

                if (level.getBlockState(relativePos).getValue(ModBlockStateProperties.LEFT)) {
                    list.add(relativePos.relative(facing.getClockWise()));
                }
            }

            if (state.getValue(ModBlockStateProperties.RIGHT)) {
                BlockPos relativePos = pos.relative(facing.getCounterClockWise());

                list.add(relativePos);

                if (level.getBlockState(relativePos).getValue(ModBlockStateProperties.RIGHT)) {
                    list.add(relativePos.relative(facing.getCounterClockWise()));
                }
            }

            return BlockCombiner.combine(list);
        });
    }
}
