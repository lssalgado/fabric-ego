package com.salthunder.mod_ego.items

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

object EgoFoodComponents {

    private fun egoBuilder() = FoodComponent.Builder().alwaysEdible().snack()

    val ZOMBIE_EGO = egoBuilder()
        .hunger(1) //TODO review
        .saturationModifier(0.8F) //TODO review
        .statusEffect(
            StatusEffectInstance(
                StatusEffects.STRENGTH, //TODO Smite StatusEffect
                100,
                0
            ),
            1.0F
        )
        .build()
}