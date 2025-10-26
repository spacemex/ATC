package com.github.spacemex.allthecrops.data;

import com.github.spacemex.allthecrops.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

    }

    private void make3x3(ItemConvertible input, ItemConvertible output, Consumer<RecipeJsonProvider> out) {
        net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder.create(net.minecraft.recipe.book.RecipeCategory.MISC, output)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', input)
                .criterion("has_" + itemPath(input), conditionsFromItem(input))
                .offerTo(out, new net.minecraft.util.Identifier(
                        "allthecrops",
                        itemPath(output) + "_from_3x3_" + itemPath(input)
                ));
    }

    private void unpack9(ItemConvertible blockItem, ItemConvertible outputItem, Consumer<RecipeJsonProvider> out) {
        net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder.create(net.minecraft.recipe.book.RecipeCategory.MISC, outputItem, 9)
                .input(blockItem)
                .criterion("has_" + itemPath(blockItem), conditionsFromItem(blockItem))
                .offerTo(out, new Identifier(
                        "allthecrops",
                        itemPath(outputItem) + "_from_unpacked_" + itemPath(blockItem)
                ));
    }

    private static String itemPath(ItemConvertible ic) {
        return net.minecraft.registry.Registries.ITEM.getId(ic.asItem()).getPath();
    }
}
