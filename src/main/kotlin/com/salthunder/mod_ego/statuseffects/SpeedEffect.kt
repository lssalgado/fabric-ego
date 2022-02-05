package com.salthunder.mod_ego.statuseffects

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text

class SpeedEffect : StatusEffect(StatusEffectCategory.BENEFICIAL, 0x141213) {

    init {
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "380cf1e0-50a6-4f91-a861-558350993f94", 0.2, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)

    }

    var counter = 0

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return counter == 0
    }

    override fun applyUpdateEffect(entity: LivingEntity?, amplifier: Int) {
        counter++
        if (entity is PlayerEntity) {
            entity.sendMessage(Text.of("Ms: '${entity.movementSpeed}'"), false)
            entity.movementSpeed *= 5
        }
    }
}