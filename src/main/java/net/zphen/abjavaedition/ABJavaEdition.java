package net.zphen.abjavaedition;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.zphen.abjavaedition.block.ModBlocks;
import net.zphen.abjavaedition.entity.ModEntities;
import net.zphen.abjavaedition.entity.custom.PiggyEntity;
import net.zphen.abjavaedition.item.ModItemGroups;
import net.zphen.abjavaedition.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ABJavaEdition implements ModInitializer {
	public static final String MOD_ID = "ab_java_edition";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Comment to new Commit on separate device.

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.PIGGY, PiggyEntity.createAttributes());

	}
}