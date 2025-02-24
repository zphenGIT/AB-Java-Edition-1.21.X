package net.zphen.abjavaedition.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;
import net.zphen.abjavaedition.entity.custom.PiggyEntity;

public class ModEntities {
    public static final EntityType<PiggyEntity> PIGGY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ABJavaEdition.MOD_ID, "piggy"),
            EntityType.Builder.create(PiggyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.75f, 0.7f).build());


    public static void registerModEntities() {
        ABJavaEdition.LOGGER.info("Registering Mod Entities for " + ABJavaEdition.MOD_ID);
    }
}
