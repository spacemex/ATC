package com.github.spacemex.allthecrops.data;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;

public class Models extends FabricModelProvider {
    public Models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator bsg) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    private void registerCrop(RegistrySupplier<Block> block, BlockStateModelGenerator bsg) {
        bsg.registerCrop(block.get(), CropBlock.AGE,0,1,2,3,4,5,6,7);
    }
    private void registerBushCrop(RegistrySupplier<Block> bush, BlockStateModelGenerator bsg){
        bsg.blockStateCollector.accept(VariantsBlockStateSupplier.create(bush.get()).coordinate(
                BlockStateVariantMap.create(Properties.AGE_3).register(
                        (s) -> BlockStateVariant.create()
                                .put(VariantSettings.MODEL, bsg.createSubModel(bush.get(),"_stage" + s,
                                        net.minecraft.data.client.Models.CROSS,TextureMap::cross)))
        ));
    }
}
