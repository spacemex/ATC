package com.github.spacemex.allthecrops.blocks.custom.crops;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class CustomCropBlock extends CropBlock {
    public static final IntProperty AGE = Properties.AGE_7;
    private final RegistrySupplier<Item> seed;
    public CustomCropBlock(RegistrySupplier<Item> seed, Settings settings) {
        super(settings);
        this.seed = seed;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return this.seed.get();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
