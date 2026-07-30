package com.flexymechanicalcheese;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(FlexyMechanicalCheese.MODID)
public class FlexyMechanicalCheese {
    public static final String MODID = "flexymechanicalcheese";

    public FlexyMechanicalCheese(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
    }
}

