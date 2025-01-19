package net.spectre.seasonalMusic.events;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spectre.seasonalMusic.sound.SeasonalMusicHandler;

@Mod.EventBusSubscriber
public class SeasonalMusicEventListener {

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.level.isClientSide) {
            SeasonalMusicHandler.playSeasonalMusic(event.level);
        }
    }
}
