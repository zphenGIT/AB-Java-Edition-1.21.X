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
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block SLINGSHOT_LOG = registerBlock("slingshot_log",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block PIGGY_TNT = registerBlock("piggy_tnt",
                new Block(AbstractBlock.Settings.create().strength(2f)
                        .sounds(BlockSoundGroup.WOOD)));

    public static final Block POLISHED_STONE = registerBlock("polished_stone",
                new Block(AbstractBlock.Settings.create().strength(1.5f)
                        .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
                new Block(AbstractBlock.Settings.create().strength(0.3f)
                        .sounds(BlockSoundGroup.GLASS)));




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
            entries.add(ModBlocks.SLINGSHOT_LOG);
            entries.add(ModBlocks.PIGGY_TNT);
            entries.add(ModBlocks.POLISHED_STONE);
            entries.add(ModBlocks.REINFORCED_GLASS);
        });
    }
}
