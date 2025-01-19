package net.spectre.seasonalMusic.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.ISeasonState;


public class SeasonalMusicHandler {
    private static SoundEvent currentPlayingMusic = null;
    private static SoundInstance currentSoundInstance = null;

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
                default -> null;
            };

            if (musicToPlay != null && musicToPlay != currentPlayingMusic) {
                SoundManager soundManager = Minecraft.getInstance().getSoundManager();
                if (currentSoundInstance != null) {
                    soundManager.stop(currentSoundInstance);
                }
                currentSoundInstance = net.minecraft.client.resources.sounds.SimpleSoundInstance.forMusic(musicToPlay);
                soundManager.play(currentSoundInstance);
                currentPlayingMusic = musicToPlay;
            }
        }
    }
}
