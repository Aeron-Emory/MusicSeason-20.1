package net.spectre.seasonalMusic.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spectre.seasonalMusic.seasonalMusic;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, seasonalMusic.MOD_ID);

    public static final RegistryObject<Item> SEASON_DISC = ITEMS.register("seasondisc",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SPRING_DISC = ITEMS.register("springdisc",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
