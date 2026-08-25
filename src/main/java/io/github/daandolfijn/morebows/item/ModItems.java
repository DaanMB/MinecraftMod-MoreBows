package io.github.daandolfijn.morebows.item;

import io.github.daandolfijn.morebows.MoreBows;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item PALE_ORB = registerItem("pale_orb", Item::new);
    public static final Item BASALT_ORB = registerItem("basalt_orb", Item::new);
    public static final Item SPIDER_ORB = registerItem("spider_orb", Item::new);
    public static final Item GUARDIAN_ORB = registerItem("guardian_orb", Item::new);

    public static final Item PALE_BOW = registerItem("pale_bow",
            properties -> new PaleBowItem(properties.durability(1000)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.morebows.pale_bow"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });
    public static final Item BASALT_BOW = registerItem("basalt_bow",
            properties -> new BowItem(properties.durability(1000)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.morebows.basalt_bow"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });
    public static final Item SPIDER_BOW = registerItem("spider_bow",
            properties -> new BowItem(properties.durability(1000)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.morebows.spider_bow"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });
    public static final Item GUARDIAN_BOW = registerItem("guardian_bow",
            properties -> new GuardianBowItem(properties.durability(1000)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.morebows.guardian_bow"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });
    public static final Item SUPER_BOW = registerItem("super_bow",
            properties -> new SuperBowItem(properties.durability(1000)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.morebows.super_bow"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreBows.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreBows.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MoreBows.LOGGER.info("Registering Mod Items for " + MoreBows.MOD_ID);
    }
}
