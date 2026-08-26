package io.github.daandolfijn.morebows.datagen;

import io.github.daandolfijn.morebows.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModReciepeProvider extends FabricRecipeProvider {
    public ModReciepeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> PALE_BOW_SMELTABLE = List.of(ModItems.PALE_BOW);
                oreSmelting(PALE_BOW_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.PALE_ORB, 0.25F, 200, "morebows");
                List<ItemLike> BASALT_BOW_SMELTABLE = List.of(ModItems.BASALT_BOW);
                oreSmelting(BASALT_BOW_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.BASALT_ORB, 0.25F, 200, "morebows");
                List<ItemLike> SPIDER_BOW_SMELTABLE = List.of(ModItems.SPIDER_BOW);
                oreSmelting(SPIDER_BOW_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SPIDER_ORB, 0.25F, 200, "morebows");
                List<ItemLike> GUARDIAN_BOW_SMELTABLE = List.of(ModItems.GUARDIAN_BOW);
                oreSmelting(GUARDIAN_BOW_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.GUARDIAN_ORB, 0.25F, 200, "morebows");


                shapeless(RecipeCategory.COMBAT, ModItems.SUPER_BOW)
                        .requires(Items.BOW)
                        .requires(ModItems.PALE_ORB)
                        .requires(ModItems.BASALT_ORB)
                        .requires(ModItems.SPIDER_ORB)
                        .requires(ModItems.GUARDIAN_ORB)
                        .unlockedBy(getHasName(ModItems.PALE_ORB), has(ModItems.PALE_ORB))
                        .unlockedBy(getHasName(ModItems.BASALT_ORB), has(ModItems.BASALT_ORB))
                        .unlockedBy(getHasName(ModItems.SPIDER_ORB), has(ModItems.SPIDER_ORB))
                        .unlockedBy(getHasName(ModItems.GUARDIAN_ORB), has(ModItems.GUARDIAN_ORB))
                        .group("morebows")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "MoreBows Recipes";
    }
}
