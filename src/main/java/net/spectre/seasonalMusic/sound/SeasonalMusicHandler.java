package net.spectre.seasonalMusic.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.ISeasonState;


public class SeasonalMusicHandler {
    public static void playSeasonalMusic(Level world) {

        if (Minecraft.getInstance().player == null) {
            return; // No player, exit early
        }
        // Get the current season state
        ISeasonState seasonState = SeasonHelper.getSeasonState(world);

        if (seasonState != null) {
            // Fetch the current season
            Season currentSeason = seasonState.getSeason();

            // Play music based on the season
            SoundEvent musicToPlay = switch (currentSeason) {
                case SPRING -> ModSounds.NEW_DAY.get();
                case SUMMER -> ModSounds.APPLE_CIDER.get();
                case AUTUMN -> ModSounds.AUTUMN_MUSIC.get();
                case WINTER -> ModSounds.WINTER_COLD.get();
            };

            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.playSound(musicToPlay, 1.0F, 1.0F);
            }
        }
    }
}
