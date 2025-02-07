package net.zphen.abjavaedition;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.zphen.abjavaedition.datagen.ModBlockTagProvider;
import net.zphen.abjavaedition.datagen.ModItemTagProvider;
import net.zphen.abjavaedition.datagen.ModLootTableProvider;
import net.zphen.abjavaedition.datagen.ModModelProvider;

public class ABJavaEditionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
