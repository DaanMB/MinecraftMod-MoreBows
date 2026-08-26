package io.github.daandolfijn.morebows.loot;

import io.github.daandolfijn.morebows.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider){
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/elder_guardian"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1f))
                    .when(LootItemRandomChanceCondition.randomChance(0.33f))
                    .add(LootItem.lootTableItem(ModItems.GUARDIAN_BOW))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("chests/abandoned_mineshaft"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1f))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f))
                    .add(LootItem.lootTableItem(ModItems.SPIDER_BOW))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("chests/bastion_other"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1f))
                    .when(LootItemRandomChanceCondition.randomChance(0.5f))
                    .add(LootItem.lootTableItem(ModItems.BASALT_BOW))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)).build());
            builder.pool(poolBuilder.build());
        }
    }
}
