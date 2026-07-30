package com.flexymechanicalcheese;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = FlexyMechanicalCheese.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onDragonDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof EnderDragon dragon) {
            if (!dragon.level().isClientSide) {
                ItemEntity cheeseShard = new ItemEntity(
                    dragon.level(), 
                    dragon.getX(), 
                    dragon.getY(), 
                    dragon.getZ(), 
                    new ItemStack(ModItems.DRAGON_CHEESE_SHARD.get(), 1)
                );
                dragon.level().addFreshEntity(cheeseShard);
            }
        }
    }
}
