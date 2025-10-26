package com.github.spacemex.allthecrops.registry;

import com.github.spacemex.allthecrops.blocks.custom.crops.CustomBush;
import com.github.spacemex.allthecrops.blocks.custom.crops.CustomCropBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.ArrayList;
import java.util.List;

import static com.github.spacemex.allthecrops.Allthecrops.MOD_ID;

public class BlockRegistry {
    private static final List<RegistrySupplier<Block>> crops = new ArrayList<>();
    private static final List<RegistrySupplier<Block>> bushes = new ArrayList<>();
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(MOD_ID, RegistryKeys.BLOCK);


    private static RegistrySupplier<Block> registerCrop(String id, RegistrySupplier<Item> seed){
        RegistrySupplier<Block> block = BLOCKS.register(id,()-> new CustomCropBlock(seed, AbstractBlock.Settings.copy(Blocks.WHEAT)));
        crops.add(block);
        return block;
    }
    private static RegistrySupplier<Block> registerBush(String id, RegistrySupplier<Item> berry){
        RegistrySupplier<Block> block = BLOCKS.register(id,()-> new CustomBush(berry, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
        bushes.add(block);
        return block;
    }

    @SuppressWarnings("unchecked")
    private <T extends Block> RegistrySupplier<T> register(String id) {
        RegistrySupplier<T> block = BLOCKS.register(id, () -> (T) new Block(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK)));
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Settings()));
        return block;
    }

    // BlockRegistry.java
    public static List<RegistrySupplier<Block>> getCrops() { return crops; }
    public static List<RegistrySupplier<Block>> getBushes() { return bushes; }

    public static void init() {
        BLOCKS.register();
    }
}
