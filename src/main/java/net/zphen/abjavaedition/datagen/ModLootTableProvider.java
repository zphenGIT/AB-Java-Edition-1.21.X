package net.zphen.abjavaedition.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.zphen.abjavaedition.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
    addDrop(ModBlocks.SLINGSHOT_STAIRS);
    addDrop(ModBlocks.SLINGSHOT_SLAB, slabDrops(ModBlocks.SLINGSHOT_SLAB));

    addDrop(ModBlocks.SLINGSHOT_BUTTON);
    addDrop(ModBlocks.SLINGSHOT_PRESSURE_PLATE);

    addDrop(ModBlocks.SLINGSHOT_WALL);
    addDrop(ModBlocks.SLINGSHOT_FENCE);

    }
}
