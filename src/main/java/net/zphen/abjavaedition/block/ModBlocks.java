package net.zphen.abjavaedition.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
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
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block SLINGSHOT_LOG = registerBlock("slingshot_log",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block PIGGY_TNT = registerBlock("piggy_tnt",
                new Block(AbstractBlock.Settings.create().strength(2f)
                        .sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block POLISHED_STONE = registerBlock("polished_stone",
                new Block(AbstractBlock.Settings.create().strength(1.5f)
                        .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
                new Block(AbstractBlock.Settings.create().strength(0.3f)
                        .sounds(BlockSoundGroup.GLASS)));

    public static final Block SLINGSHOT_STAIRS = registerBlock("slingshot_stairs",
            new StairsBlock(ModBlocks.SLINGSHOT_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BAMBOO_WOOD)));
    public static final Block SLINGSHOT_SLAB = registerBlock("slingshot_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block SLINGSHOT_BUTTON = registerBlock("slingshot_button",
            new ButtonBlock(BlockSetType.BAMBOO, 2,
                    AbstractBlock.Settings.create().strength(2f).noCollision().sounds(BlockSoundGroup.BAMBOO_WOOD)));
    public static final Block SLINGSHOT_PRESSURE_PLATE = registerBlock("slingshot_pressure_plate",
            new PressurePlateBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block SLINGSHOT_WALL = registerBlock("slingshot_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BAMBOO_WOOD)));
    public static final Block SLINGSHOT_FENCE = registerBlock("slingshot_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block POLISHED_STONE_WALL = registerBlock("polished_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_STONE_STAIR = registerBlock("polished_stone_stairs",
            new StairsBlock(ModBlocks.POLISHED_STONE.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_STONE_SLAB = registerBlock("polished_stone_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.STONE)));

    public static final Block REINFORCED_GLASS_WALL = registerBlock("reinforced_glass_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(0.3f)
                    .sounds(BlockSoundGroup.GLASS)));
    public static final Block REINFORCED_GLASS_STAIRS = registerBlock("reinforced_glass_stairs",
            new StairsBlock(ModBlocks.REINFORCED_GLASS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(0.3f).sounds(BlockSoundGroup.GLASS)));
    public static final Block REINFORCED_GLASS_SLAB = registerBlock("reinforced_glass_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(0.3f)
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

        });
    }
}
