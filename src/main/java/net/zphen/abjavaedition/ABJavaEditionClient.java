package net.zphen.abjavaedition;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.zphen.abjavaedition.entity.ModEntities;
import net.zphen.abjavaedition.entity.client.PiggyModel;
import net.zphen.abjavaedition.entity.client.PiggyRenderer;

public class ABJavaEditionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(PiggyModel.PIGGY, PiggyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PIGGY, PiggyRenderer::new);

    }
}
