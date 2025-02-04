package net.zphen.abjavaedition.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;

public class ModBlocks {

    public static final Block SLINGSHOT_PLANKS = registerBlock("slingshot_planks",
            new Block(AbstractBlock.Settings.create().strength(1f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block PIGGY_TNT = registerBlock("piggy_tnt",
                new Block(AbstractBlock.Settings.create().strength(1f)
                        .requiresTool().sounds(BlockSoundGroup.WOOD)));




    private static Block registerBlock (String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ABJavaEdition.MOD_ID, name), block);
    }

    private static void registerBlockItems (String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ABJavaEdition.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        ABJavaEdition.LOGGER.info("Registering Mod Blocks for " + ABJavaEdition.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SLINGSHOT_PLANKS);
            entries.add(ModBlocks.PIGGY_TNT);
        });
    }
}
