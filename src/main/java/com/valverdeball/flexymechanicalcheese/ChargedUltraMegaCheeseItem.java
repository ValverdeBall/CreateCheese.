package com.valverdeball.flexymechanicalcheese;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ChargedUltraMegaCheeseItem extends TotallySafeHEBaseForCheese {
    public ChargedUltraMegaCheeseItem(Properties properties) {
        super(properties, 6.0F);
  }

    @Override
    protected void applyBonusEffects(Level level, LivingEntity entity) {            
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(entity.getX(), entity.getY(), entity.getZ());
                level.addFreshEntity(lightning);
            }           
            entity.addEffect(new MobEffectInstance(MobEffects.WITHER, -1, 9, false, false));
  }
}