package io.github.daandolfijn.morebows;

import io.github.daandolfijn.morebows.datagen.ModItemTagsProvider;
import io.github.daandolfijn.morebows.datagen.ModReciepeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import io.github.daandolfijn.morebows.datagen.ModModelProvider;

public class MoreBowsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModReciepeProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
    }
}