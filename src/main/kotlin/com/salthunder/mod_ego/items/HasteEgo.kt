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

class HasteEgo(settings: Settings) : Item(settings) {


    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val modifier = if (hand == Hand.MAIN_HAND) 0.2 else {
            user.sendMessage(Text.of("Haste: '${user.attributes.getValue(EntityAttributes.GENERIC_ATTACK_SPEED)}'"), false)
            user.addStatusEffect(
                StatusEffectInstance(StatusEffects.HASTE, 3000, 1)
            )
            user.getBlockBreakingSpeed()
            user.sendMessage(Text.of("Haste: '${user.attributes.getValue(EntityAttributes.GENERIC_ATTACK_SPEED)}'"), false)
            -0.2
        }

        val multimapBuilder = ImmutableMultimap.builder<EntityAttribute, EntityAttributeModifier>()

        multimapBuilder.put(
            EntityAttributes.GENERIC_ATTACK_SPEED,
            EntityAttributeModifier("HAAAAASTE", modifier, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
        )

        user.attributes.addTemporaryModifiers(multimapBuilder.build())

        user.sendMessage(Text.of("Haste: '${user.attributes.getValue(EntityAttributes.GENERIC_ATTACK_SPEED)}'"), false)

        return TypedActionResult.success(user.getStackInHand(hand))
    }
}