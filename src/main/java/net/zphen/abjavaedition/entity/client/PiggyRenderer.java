package net.zphen.abjavaedition.entity.client;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zphen.abjavaedition.ABJavaEdition;
import net.zphen.abjavaedition.entity.custom.PiggyEntity;

public class PiggyRenderer extends MobEntityRenderer<PiggyEntity, PiggyModel<PiggyEntity>> {
    public PiggyRenderer(EntityRendererFactory.Context context) {
        super(context, new PiggyModel<>(context.getPart(PiggyModel.PIGGY)), 0.5f);
    }

    @Override
    public Identifier getTexture(PiggyEntity entity) {
        return Identifier.of(ABJavaEdition.MOD_ID, "textures/entity/piggy/piggy.png");
    }

    @Override
    public void render(PiggyEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.55f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
