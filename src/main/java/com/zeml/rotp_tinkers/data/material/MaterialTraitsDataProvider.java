package com.zeml.rotp_tinkers.data.material;

import com.zeml.rotp_tinkers.modifiers.JojoModifiers;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

public class MaterialTraitsDataProvider  extends AbstractMaterialTraitDataProvider {

    public MaterialTraitsDataProvider(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }



    @Override
    public String getName() {
        return "Jojo Material Traits";
    }


    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(JojoMaterialID.meteor, JojoModifiers.METEOR.get());
        addDefaultTraits(JojoMaterialID.stand_arrow, JojoModifiers.ARROW.get());
    }
}
