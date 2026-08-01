package com.valverdeball.flexymechanicalcheese;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import com.valverdeball.flexymechanicalcheese.everythingthatstartswithmod.ModItems;

@Mod(FlexyMechanicalCheese.MODID)
public class FlexyMechanicalCheese {
    public static final String MODID = "flexymechanicalcheese";

    public FlexyMechanicalCheese(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
    }
}

