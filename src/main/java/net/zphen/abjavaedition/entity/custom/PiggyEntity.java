package net.zphen.abjavaedition.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;
import net.zphen.abjavaedition.entity.ModEntities;
import net.zphen.abjavaedition.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class PiggyEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(PiggyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private final int idleAnimationLength = 40;

    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;
    private final int attackAmimationLength = //Put length in ticks here, make 0 for now. Marking as error so you see this

    public PiggyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new MeleeAttackGoal(this, 1.0, true));

        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.AVIAN_EGG), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        //when animations are set up, uncomment this so animations are being ran

        /*
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
        */
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }
    private void setupAnimationStates() {
        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            // if this is attacking and animation timer needs reset
            attackAnimationTimeout = attackAmimationLength;
            attackAnimationState.start(this.age);
        } else if(this.isAttacking()) {
            // if timer doesnt need reset but it is still attacking
            --this.attackAnimationTimeout;
        } else { // if it stopped attacking
            attackAnimationState.stop();
        }

        if (!this.isAttacking()) {
            //Makes sure idle isnt playing while it is attacking
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = idleAnimationLength;
                this.idleAnimationState.start(this.age);
            } else {
                --this.idleAnimationTimeout;
            }
        }

    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }



    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        this.dataTracker.set(ATTACKING, false);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.AVIAN_EGG);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PIGGY.create(world);
    }
}
