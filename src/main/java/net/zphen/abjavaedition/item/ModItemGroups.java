package net.zphen.abjavaedition.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;
import net.zphen.abjavaedition.block.ModBlocks;

public class ModItemGroups {
        public static final ItemGroup AB_JAVA_EDITION_ITEMS = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(ABJavaEdition.MOD_ID, "ab_java_edition_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GOLDEN_EGG))
                        .displayName(Text.translatable("itemgroup.ab_java_edition.ab_java_edition_items"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.GOLDEN_EGG);
                            entries.add(ModItems.AVIAN_EGG);
                            entries.add(ModItems.STRAWBERRY);
                            entries.add(ModItems.DONUT);
                            entries.add(ModItems.FORK);
                        })

                    .build());

        public static final ItemGroup AB_JAVA_EDITION_BLOCKS = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(ABJavaEdition.MOD_ID, "ab_java_edition_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PIGGY_TNT))
                        .displayName(Text.translatable("itemgroup.ab_java_edition.ab_java_edition_blocks"))
                        .entries((displayContext, entries) -> {

                            entries.add(ModBlocks.SLINGSHOT_LOG);
;                           entries.add(ModBlocks.SLINGSHOT_PLANKS);
                            entries.add(ModBlocks.SLINGSHOT_STAIRS);
                            entries.add(ModBlocks.SLINGSHOT_SLAB);
                            entries.add(ModBlocks.SLINGSHOT_BUTTON);
                            entries.add(ModBlocks.SLINGSHOT_PRESSURE_PLATE);
                            entries.add(ModBlocks.SLINGSHOT_WALL);
                            entries.add(ModBlocks.SLINGSHOT_FENCE);
                            entries.add(ModBlocks.PIGGY_TNT);

                            entries.add(ModBlocks.POLISHED_STONE);
                            entries.add(ModBlocks.POLISHED_STONE_WALL);
                            entries.add(ModBlocks.POLISHED_STONE_STAIR);
                            entries.add(ModBlocks.POLISHED_STONE_SLAB);

                            entries.add(ModBlocks.REINFORCED_GLASS);
                            entries.add(ModBlocks.REINFORCED_GLASS_WALL);
                            entries.add(ModBlocks.REINFORCED_GLASS_STAIRS);
                            entries.add(ModBlocks.REINFORCED_GLASS_SLAB);
                        })

                        .build());



    public static void registerItemGroups() {
        ABJavaEdition.LOGGER.info("Registering Item Groups for " + ABJavaEdition.MOD_ID);
    }
}
