package com.zeml.rotp_tinkers.data.material;

import com.github.standobyte.jojo.JojoMod;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class JojoMaterialID {

    public static final MaterialId meteor   = id("meteor");
    public static final MaterialId stand_arrow = id("stand_arrow");




    private static MaterialId id(String string) {
        return new MaterialId(JojoMod.MOD_ID, string);
    }


}
