package com.flexymechanicalcheese;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChargedUltraMegaCheeseItem extends Item {
    public ChargedUltraMegaCheeseItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            level.explode(null, entity.getX(), entity.getY(), entity.getZ(), 6.0F, true, Level.ExplosionInteraction.TNT);
            
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(entity.getX(), entity.getY(), entity.getZ());
                level.addFreshEntity(lightning);
            }
            
            entity.addEffect(new MobEffectInstance(MobEffects.WITHER, -1, 9, false, false));
        }
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            stack.shrink(1);
        }
        return stack;
    }
}
