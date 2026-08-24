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
                List<ItemLike> BOWS_SMELTABLE = List.of(ModItems.PALE_BOW);
                oreSmelting(BOWS_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.PALE_ORB, 0.25F, 200, "morebows");

                shapeless(RecipeCategory.COMBAT, ModItems.PALE_BOW)
                        .requires(Items.BOW)
                        .requires(ModItems.PALE_ORB)
                        .unlockedBy(getHasName(ModItems.PALE_ORB), has(ModItems.PALE_ORB))
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
