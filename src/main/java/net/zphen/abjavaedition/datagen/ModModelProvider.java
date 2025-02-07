package net.zphen.abjavaedition.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.zphen.abjavaedition.block.ModBlocks;
import net.zphen.abjavaedition.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool slingshotPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SLINGSHOT_PLANKS);

        slingshotPlankPool.stairs(ModBlocks.SLINGSHOT_STAIRS);
        slingshotPlankPool.slab(ModBlocks.SLINGSHOT_SLAB);

        slingshotPlankPool.button(ModBlocks.SLINGSHOT_BUTTON);
        slingshotPlankPool.pressurePlate(ModBlocks.SLINGSHOT_PRESSURE_PLATE);

        slingshotPlankPool.wall(ModBlocks.SLINGSHOT_WALL);
        slingshotPlankPool.fence(ModBlocks.SLINGSHOT_FENCE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
