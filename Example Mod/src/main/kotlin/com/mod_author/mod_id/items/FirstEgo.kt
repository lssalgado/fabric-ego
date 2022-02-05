package com.mod_author.mod_id.items

import com.mod_author.mod_id.statuseffects.SpeedEffect
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffectUtil
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stat
import net.minecraft.stat.StatType
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import java.util.*

class FirstEgo(settings: Settings): Item(settings) {



    override fun use(world: World?, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {

        if (hand == Hand.MAIN_HAND) {
            user.sendMessage(Text.of("Hand = '${hand.toString()}'"), false)
            user.addStatusEffect(
                StatusEffectInstance(SpeedEffect(), 3000, 5)
            )
            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
        } else {
            user.sendMessage(Text.of("Hand = '${hand.toString()}'"), false)
            user.addStatusEffect(
                StatusEffectInstance(StatusEffects.SPEED, 3000, 5)
            )
            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
            user.sendMessage(Text.of("MS = '${user.movementSpeed}'"), false)
        }
        return TypedActionResult.success(user.getStackInHand(hand))
    }
}