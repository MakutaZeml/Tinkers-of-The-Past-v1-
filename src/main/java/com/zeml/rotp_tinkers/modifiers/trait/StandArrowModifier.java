package com.zeml.rotp_tinkers.modifiers.trait;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.init.ModEnchantments;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.item.StandArrowItem;
import com.github.standobyte.jojo.potion.StandVirusEffect;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandArrowHandler;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.github.standobyte.jojo.util.general.GeneralUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.TranslationTextComponent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import static com.github.standobyte.jojo.item.StandArrowItem.giveStandFromArrow;

public class StandArrowModifier extends Modifier {
    public StandArrowModifier() {
        super(0x7e6a30);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();


        LivingEntity livingEntity = (LivingEntity) target;


        if (livingEntity.hasEffect(ModStatusEffects.STAND_VIRUS.get())) {
            return 0;
        }

        if (livingEntity instanceof StandEntity) {
            return 0;
        }
        else if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            boolean state = GeneralUtil.orElseFalse(IStandPower.getStandPowerOptional(livingEntity), standCap -> {
                if (standCap.hasPower()) {
                    target.addEffect(new EffectInstance(ModStatusEffects.STAND_VIRUS.get(),20,level));
                    return false;
                }

                if (player.abilities.instabuild) { // instantly give a stand in creative
                    StandType<?> stand = StandUtil.randomStand(player, player.getRandom());
                    return giveStandFromArrow(player, standCap, stand);
                }
                else {
                    int virusEffectDuration = StandVirusEffect.getEffectDurationToApply(player);
                    if (virusEffectDuration > 0) {
                        int inhibitionLevel = level;
                        int effectLevel = StandVirusEffect.getEffectLevelToApply(inhibitionLevel);
                        player.addEffect(new EffectInstance(ModStatusEffects.STAND_VIRUS.get(),
                                virusEffectDuration, effectLevel, false, false, true));
                    }
                    else { // instantly give a stand if there was no stand virus effect given
                        StandType<?> stand = StandUtil.randomStand(player, player.getRandom());
                        return giveStandFromArrow(player, standCap, stand);
                    }

                }

                return true;
            });
        }


        return 0;
    }
}
