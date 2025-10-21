package com.github.spacemex.allthecrops.forge;

import com.github.spacemex.allthecrops.Allthecrops;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Allthecrops.MOD_ID)
public final class AllthecropsForge {
    public AllthecropsForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Allthecrops.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Allthecrops.init();
    }
}
