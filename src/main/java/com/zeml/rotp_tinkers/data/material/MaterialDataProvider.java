package com.zeml.rotp_tinkers.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class MaterialDataProvider extends AbstractMaterialDataProvider {

    public MaterialDataProvider(DataGenerator gen) {
        super(gen);
    }


    @Override
    public String getName() {
        return "Jojo Materials";
    }

    @Override
    protected void addMaterials() {
        addMaterial(JojoMaterialID.meteor, 3,ORDER_COMPAT,false,0x7e6a30);
        addMaterial(JojoMaterialID.stand_arrow,3,ORDER_COMPAT,false,0xdac352);
    }
}
