package net.spectre.seasonalMusic.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spectre.seasonalMusic.seasonalMusic;
import net.spectre.seasonalMusic.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, seasonalMusic.MOD_ID);

    public static final RegistryObject<Item> SUMMER_DISC = ITEMS.register("summerdisc",
            () -> new RecordItem(6, ModSounds.APPLE_CIDER, new Item.Properties().stacksTo(1), 3980));

    public static final RegistryObject<Item> SPRING_DISC = ITEMS.register("springdisc",
            () -> new RecordItem(6, ModSounds.NEW_DAY, new Item.Properties().stacksTo(1), 5200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
