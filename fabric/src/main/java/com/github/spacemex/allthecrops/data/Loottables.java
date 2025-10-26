package com.github.spacemex.allthecrops.data;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class Loottables extends FabricBlockLootTableProvider {
    protected Loottables(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
    }

    private BlockStatePropertyLootCondition.Builder simpleBuilder(RegistrySupplier<Block> block){
        return BlockStatePropertyLootCondition.builder(block.get())
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
    }
}
