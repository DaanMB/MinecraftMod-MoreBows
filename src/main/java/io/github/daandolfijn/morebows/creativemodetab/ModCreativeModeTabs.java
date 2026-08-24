package io.github.daandolfijn.morebows.creativemodetab;

import io.github.daandolfijn.morebows.MoreBows;
import io.github.daandolfijn.morebows.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab MOREBOWS_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreBows.MOD_ID, "morebows_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PALE_ORB))
                    .title(Component.translatable("creativemodetab.morebows.morebows_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PALE_ORB);
                        output.accept(ModItems.BASALT_ORB);
                        output.accept(ModItems.PALE_BOW);
                        output.accept(ModItems.BASALT_BOW);
                    })
                    .build());

    public static void registerModCreativeModeTabs() {
        MoreBows.LOGGER.info("Registering Creative Mode Tabs fore " + MoreBows.MOD_ID);
    }
}
