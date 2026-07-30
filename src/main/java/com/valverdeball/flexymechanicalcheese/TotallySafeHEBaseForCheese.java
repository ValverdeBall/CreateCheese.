package com.valverdeball.flexymechanicalcheese;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class TotallySafeHEBaseForCheese extends Item {
  private final float explosionPower;

  public TotallySafeHEBaseForCheese(Properties properties, float explosionPower) {
    super(properties);
    this.explosionPower = explosionPower;
  }

  @Override
  public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
    if (!level.isClientSide) {
      level.explode(null, entity.getX(), entity.getY(), entity.getZ(), explosionPower, true, Level.ExplosionInteraction.TNT);
      applyBonusEffects(level, entity);
    }
    if (entity instanceof Player player && !player.getAbilities().instabuild) {
      stack.shrink(1);
    }
    return stack;
  }

  protected void applyBonusEffects(Level level, LivingEntity entity) {
    // default: no extra effects
  }
}