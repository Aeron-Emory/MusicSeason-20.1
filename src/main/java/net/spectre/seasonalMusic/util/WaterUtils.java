package net.spectre.seasonalMusic.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class WaterUtils {
    public static boolean isPlayerUnderwater(Player player, int minDepth) {
        Level level = player.level();
        BlockPos headPos = player.blockPosition().above();

        int waterCount = 0;

        for (int i = 0; i < minDepth; i++) {
            BlockPos checkPos = headPos.above(i);
            BlockState state = level.getBlockState(checkPos);

            if (state.getFluidState().is(FluidTags.WATER)) {
                waterCount++;
            } else {
                break;
            }
        }

        return waterCount >= minDepth;
    }
}
