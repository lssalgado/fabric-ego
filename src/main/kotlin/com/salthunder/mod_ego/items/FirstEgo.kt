package com.salthunder.mod_ego.items

import com.google.common.collect.ImmutableMultimap
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class FirstEgo(settings: Settings): Item(settings) {



    override fun use(world: World?, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {

        if (hand == Hand.MAIN_HAND) {
            user.sendMessage(Text.of("Hand = '${hand.toString()}'"), false)
//            user.addStatusEffect(
//                StatusEffectInstance(SpeedEffect(), 3000, 5)
//            )
            val multimapBuilder = ImmutableMultimap.builder<EntityAttribute, EntityAttributeModifier>()

            multimapBuilder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, EntityAttributeModifier("SPEEEEED", 0.2, EntityAttributeModifier.Operation.MULTIPLY_TOTAL))

            user.attributes.addTemporaryModifiers(multimapBuilder.build())

            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
        } else {
            user.sendMessage(Text.of("Hand = '${hand.toString()}'"), false)
            user.addStatusEffect(
                StatusEffectInstance(StatusEffects.SPEED, 3000, 5)
            )
            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
        }
        return TypedActionResult.success(user.getStackInHand(hand))
    }
}