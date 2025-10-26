package com.github.spacemex.allthecrops.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.ArrayList;
import java.util.List;

import static com.github.spacemex.allthecrops.Allthecrops.MOD_ID;

public class ItemRegistry {

    private static final List<RegistrySupplier<Item>> compactable = new ArrayList<>();
    private static final List<RegistrySupplier<Item>> all_items = new ArrayList<>();
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(MOD_ID, RegistryKeys.ITEM);

    private static RegistrySupplier<Item> registerAliased(String id, RegistrySupplier<Block> block,boolean isCompactable){// todo
        RegistrySupplier<Item> item = ITEMS.register(id,()-> new AliasedBlockItem(block.get(), new Item.Settings()));
        return item;
    }

    public static void init() {
        ITEMS.register();
    }
}
