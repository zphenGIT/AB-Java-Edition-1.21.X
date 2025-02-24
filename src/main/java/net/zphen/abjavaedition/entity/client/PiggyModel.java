package net.zphen.abjavaedition.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.zphen.abjavaedition.ABJavaEdition;
import net.zphen.abjavaedition.entity.custom.PiggyEntity;

import javax.swing.text.html.parser.Entity;

public class PiggyModel<T extends PiggyEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer PIGGY = new EntityModelLayer(Identifier.of(ABJavaEdition.MOD_ID, "piggy"), "main");

    private final ModelPart piggy;

    public PiggyModel(ModelPart root) {
        this.piggy = root.getChild("piggy");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData piggy = modelPartData.addChild("piggy", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -9.0F, -5.0F, 11.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData earR = piggy.addChild("earR", ModelPartBuilder.create().uv(18, 18).cuboid(-1.0F, -3.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -8.0F, -0.5F));

        ModelPartData earL = piggy.addChild("earL", ModelPartBuilder.create().uv(18, 21).cuboid(-1.0F, -3.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, -0.5F));

        ModelPartData nose = piggy.addChild("nose", ModelPartBuilder.create().uv(0, 18).cuboid(-3.5F, -2.0F, -2.0F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -4.0F, -5.0F));

        ModelPartData tail = piggy.addChild("tail", ModelPartBuilder.create().uv(0, -3).cuboid(0.0F, -2.5F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.5F, 4.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(PiggyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadingAngles(netHeadYaw, headPitch);

        this.animateMovement(PiggyAnimations.HOP, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, PiggyAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadingAngles(float piggyYaw, float piggyPitch) {
        piggyYaw = MathHelper.clamp(piggyYaw, -30.0F, 30.0F);
        piggyPitch = MathHelper.clamp(piggyPitch, -25.0F, 45.0F);

        this.piggy.yaw = piggyYaw * 0.0174529F;
        this.piggy.pitch = piggyPitch * 0.0174529F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        piggy.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return piggy;
    }
}

