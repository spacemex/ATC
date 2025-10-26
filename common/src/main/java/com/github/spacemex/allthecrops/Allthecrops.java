package com.github.spacemex.allthecrops;

import com.github.spacemex.allthecrops.registry.BlockRegistry;
import com.github.spacemex.allthecrops.registry.ItemRegistry;

public final class Allthecrops {
    public static final String MOD_ID = "allthecrops";

    public static void init() {
        ItemRegistry.init();
        BlockRegistry.init();
    }
}
