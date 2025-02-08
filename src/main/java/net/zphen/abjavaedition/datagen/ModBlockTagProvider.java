package net.zphen.abjavaedition.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.zphen.abjavaedition.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.SLINGSHOT_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.SLINGSHOT_SLAB);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(ModBlocks.SLINGSHOT_BUTTON);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.SLINGSHOT_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.SLINGSHOT_WALL);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.SLINGSHOT_FENCE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.POLISHED_STONE_WALL);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.POLISHED_STONE_STAIR);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.POLISHED_STONE_SLAB);



    }
}

//.add(ModBlocks.SLINGSHOT_STAIRS)
//.add(ModBlocks.SLINGSHOT_SLAB)
//.add(ModBlocks.SLINGSHOT_BUTTON)
//.add(ModBlocks.SLINGSHOT_PRESSURE_PLATE)
//.add(ModBlocks.SLINGSHOT_BUTTON)
//.add(ModBlocks.SLINGSHOT_WALL)
//.add(ModBlocks.SLINGSHOT_FENCE);