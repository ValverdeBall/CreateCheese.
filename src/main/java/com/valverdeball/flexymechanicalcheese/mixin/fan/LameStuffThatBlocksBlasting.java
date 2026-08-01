package com.valverdeball.flexymechanicalcheese.mixin.fan;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.valverdeball.flexymechanicalcheese.everythingthatstartswithmod.ModItems;

@Mixin(AllFanProcessingTypes.BlastingType.class)
public class LameStuffThatBlocksBlasting {

  @Inject(method = "canProcess", at = @At("HEAD"),cancellable = true)
  private void blockDragonCheeseBlasting(ItemStack stack, Level level, CallbackInfoReturnable<Boolean> cir) {
    if (stack.is(ModItems.RAW_DRAGON_CHEESE.get())) {
      cir.setReturnValue(false);
    }
  }
}