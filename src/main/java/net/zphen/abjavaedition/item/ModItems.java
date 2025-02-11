package net.zphen.abjavaedition.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;

public class ModItems {
    public static final Item AVIAN_EGG = registerItem("avian_egg", new Item(new Item.Settings()));
    public static final Item GOLDEN_EGG = registerItem("golden_egg", new Item(new Item.Settings()));
    public static final Item DONUT = registerItem("donut", new Item(new Item.Settings().food(ModFoodComponents.DONUT)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ABJavaEdition.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ABJavaEdition.LOGGER.info("Registering Mod Items for " + ABJavaEdition.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AVIAN_EGG);
            entries.add(GOLDEN_EGG);
            entries.add(DONUT);
            entries.add(STRAWBERRY);
        });
    }
}
