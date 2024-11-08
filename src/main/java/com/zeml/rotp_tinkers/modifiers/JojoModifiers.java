package com.zeml.rotp_tinkers.modifiers;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.modifiers.trait.MeteorModifier;
import com.zeml.rotp_tinkers.modifiers.trait.StandArrowModifier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class JojoModifiers {
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, JojoMod.MOD_ID);

    public static final RegistryObject<StandArrowModifier> ARROW = MODIFIERS.register("stand_arrow", StandArrowModifier::new);

    public static final RegistryObject<MeteorModifier> METEOR = MODIFIERS.register("meteor", MeteorModifier::new);

}
