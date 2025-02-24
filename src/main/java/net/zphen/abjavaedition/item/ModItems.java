package net.zphen.abjavaedition.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;
import net.zphen.abjavaedition.entity.ModEntities;

import javax.tools.Tool;

public class ModItems {
    public static final Item AVIAN_EGG = registerItem("avian_egg", new Item(new Item.Settings()));
    public static final Item GOLDEN_EGG = registerItem("golden_egg", new Item(new Item.Settings()));
    public static final Item DONUT = registerItem("donut", new Item(new Item.Settings().food(ModFoodComponents.DONUT)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    public static final Item SLINGSHOT = registerItem("slingshot", new Item(new Item.Settings().maxCount(1)));
    public static final Item FORK = registerItem("fork",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 1, -1.0f))));

    public static final Item PIGGY_SPAWN_EGG = registerItem("piggy_spawn_egg",
            new SpawnEggItem(ModEntities.PIGGY, 16777215, 16777215, new Item.Settings()));

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
            entries.add(FORK);
            entries.add(SLINGSHOT);
        });
    }
}
