package com.valverdeball.flexymechanicalcheese;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("flexymechanicalcheese");
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "flexymechanicalcheese");

    public static final DeferredItem<Item> INCOMPLETE_CHEESE = ITEMS.register("incomplete_cheese", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CHEESE_BASE = ITEMS.register("cheese_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PRESSED_CHEESE_BASE = ITEMS.register("pressed_cheese_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUPER_CHEESE_RAW = ITEMS.register("super_cheese_raw", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> ULTRA_MEGA_CHEESE = ITEMS.register("ultra_mega_cheese", () -> 
            new UltraMegaCheeseItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(0.1F)
                            .alwaysEdible()
                            .build()
                    )
            )
    );

    public static final DeferredItem<Item> DRAGON_CHEESE_SHARD = ITEMS.register("dragon_cheese_shard", () -> new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            tooltipComponents.add(Component.translatable("tooltip.flexymechanicalcheese.dragon_cheese_shard"));
            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
    });

    public static final DeferredItem<Item> RAW_DRAGON_CHEESE = ITEMS.register("raw_dragon_cheese", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRAGON_CHEESE = ITEMS.register("dragon_cheese", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHARGED_DRAGON_CHEESE = ITEMS.register("charged_dragon_cheese", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHARGED_DRAGON_CHEESE_WITH_BREATH = ITEMS.register("charged_dragon_cheese_with_breath", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> CHARGED_ULTRA_MEGA_CHEESE = ITEMS.register("charged_ultra_mega_cheese", () -> 
            new ChargedUltraMegaCheeseItem(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationModifier(0.2F)
                            .alwaysEdible()
                            .build()
                    )
            )
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHEESE_TAB = CREATIVE_TABS.register("cheese_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.flexymechanicalcheese.cheese_tab"))
            .icon(() -> new ItemStack(CHARGED_ULTRA_MEGA_CHEESE.get()))
            .displayItems((parameters, output) -> {
                output.accept(INCOMPLETE_CHEESE.get());
                output.accept(CHEESE_BASE.get());
                output.accept(PRESSED_CHEESE_BASE.get());
                output.accept(SUPER_CHEESE_RAW.get());
                output.accept(ULTRA_MEGA_CHEESE.get());
                output.accept(DRAGON_CHEESE_SHARD.get());
                output.accept(RAW_DRAGON_CHEESE.get());
                output.accept(DRAGON_CHEESE.get());
                output.accept(CHARGED_DRAGON_CHEESE.get());
                output.accept(CHARGED_DRAGON_CHEESE_WITH_BREATH.get());
                output.accept(CHARGED_ULTRA_MEGA_CHEESE.get());
            }).build());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_TABS.register(eventBus);
    }
}
