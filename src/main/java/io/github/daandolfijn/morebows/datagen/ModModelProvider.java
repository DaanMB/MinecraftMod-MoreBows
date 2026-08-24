package io.github.daandolfijn.morebows.datagen;

import io.github.daandolfijn.morebows.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.PALE_ORB, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.createFlatItemModel(ModItems.PALE_BOW, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ModItems.PALE_BOW);
    }
}
