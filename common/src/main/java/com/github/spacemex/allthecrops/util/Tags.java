package com.github.spacemex.allthecrops.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Tags {
    public static class Blocks {
        public static TagKey<Block> createFabricTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c",name));
        }

        @Deprecated(since = "1.20.4",forRemoval = false)
        public static TagKey<Block> createForgeTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("forge",name));
        }
    }
    public static class Items {
        public static TagKey<Item> createFabricTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c",name));
        }

        @Deprecated(since = "1.20.4",forRemoval = false)
        public static TagKey<Item> createForgeTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("forge",name));
        }
    }
}
