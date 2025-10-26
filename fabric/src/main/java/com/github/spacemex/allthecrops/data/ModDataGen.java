package com.github.spacemex.allthecrops.data;

import com.github.spacemex.allthecrops.Allthecrops;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGen  implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        Allthecrops.init();


        pack.addProvider(Recipes::new);
        pack.addProvider(Models::new);
        pack.addProvider(BlockTagProvider::new);
        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(Loottables::new);
    }
}
