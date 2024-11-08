package com.zeml.rotp_tinkers.modifiers.trait;

import com.github.standobyte.jojo.init.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class MeteorModifier extends Modifier {
    public MeteorModifier() {
        super(0xdac352);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        target.addEffect(new EffectInstance(ModStatusEffects.STAND_VIRUS.get(),40,level));
        return 0;
    }
}
