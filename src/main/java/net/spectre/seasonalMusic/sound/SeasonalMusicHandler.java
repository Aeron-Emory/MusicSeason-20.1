package net.spectre.seasonalMusic.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.ISeasonState;


public class SeasonalMusicHandler {
    private static Holder<SoundEvent> currentPlayingMusic = null;

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
//            SoundEvent musicToPlay = switch (currentSeason) {
//                case SPRING -> ModSounds.NEW_DAY.get();
//                case SUMMER -> ModSounds.APPLE_CIDER.get();
//                case AUTUMN -> ModSounds.AUTUMN_MUSIC.get();
//                case WINTER -> ModSounds.WINTER_COLD.get();
//                default -> null;
//            };

            Holder<SoundEvent> musicToPlay = switch (currentSeason) {
                case SPRING -> Holder.direct(ModSounds.NEW_DAY.get());
                case SUMMER -> Holder.direct(ModSounds.APPLE_CIDER.get());
                case AUTUMN -> Holder.direct(ModSounds.AUTUMN_MUSIC.get());
                case WINTER -> Holder.direct(ModSounds.WINTER_COLD.get());
                default -> null;
            };

            if (musicToPlay != null && musicToPlay != currentPlayingMusic) {
                MusicManager musicManager = Minecraft.getInstance().getMusicManager();
                musicManager.stopPlaying();
                Music music = new Music(musicToPlay, 20, 20, true);
                musicManager.startPlaying(music);
                currentPlayingMusic = musicToPlay;
            }
        }
    }
}
