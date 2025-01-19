package net.spectre.seasonalMusic.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spectre.seasonalMusic.seasonalMusic;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, seasonalMusic.MOD_ID);

    public static final RegistryObject<SoundEvent> NEW_DAY = registerSoundEvents("new_day");
    public static final RegistryObject<SoundEvent> WINTER_COLD = registerSoundEvents("winter_cold");
    public static final RegistryObject<SoundEvent> APPLE_CIDER = registerSoundEvents("apple_cider");
    public static final RegistryObject<SoundEvent> AUTUMN_MUSIC = registerSoundEvents("autumn_sound");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(seasonalMusic.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
