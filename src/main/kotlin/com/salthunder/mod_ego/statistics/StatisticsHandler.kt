package com.salthunder.mod_ego.statistics

import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import kotlin.math.floor
import kotlin.math.log
import kotlin.math.roundToInt

fun increaseConsumption(user: ServerPlayerEntity, value: Int) {
    user.increaseStat(EgoStatisticIdentifiers.EGO_CONSUMPTION.identifier, value)
    val consumed =
        user.statHandler.getStat(Stats.CUSTOM, EgoStatisticIdentifiers.EGO_CONSUMPTION.identifier)
    val egoPoints = user.statHandler.getStat(Stats.CUSTOM, EgoStatisticIdentifiers.EGO_POINTS.identifier)
    user.sendMessage(Text.of("Consumed: '$consumed'"), false)
    val awardedPoints = calcAwardedPoints(consumed, egoPoints)
    if (awardedPoints > 0) {
        updateUnspentEgo(user, awardedPoints)
    }
}

fun calcAwardedPoints(consumed: Int, egoPoints: Int): Int {
    val expectedPoints: Int = floor(log(consumed.toDouble(), 1.7)).roundToInt()
    return expectedPoints - egoPoints
}

fun updateUnspentEgo(user: ServerPlayerEntity, value: Int) {
    user.sendMessage(Text.of("updating UnspentEgo -> '$value'"), false)

    user.increaseStat(EgoStatisticIdentifiers.EGO_POINTS_UNSPENT.identifier, value)
    if (value > 0) {
        updateEgoPoints(user, value)
    }
}

fun updateSpentEgo(user: ServerPlayerEntity, value: Int) {
    user.sendMessage(Text.of("updating SpentEgo -> '$value'"), false)
    updateUnspentEgo(user, value * -1)
    user.increaseStat(EgoStatisticIdentifiers.EGO_POINTS_SPENT.identifier, value)
}

fun updateEgoPoints(user: ServerPlayerEntity, value: Int) {
    user.sendMessage(Text.of("updating EgoPoints -> '$value'"), false)
    user.giveItemStack(ItemStack({ Items.GOLDEN_APPLE }, value))
    user.increaseStat(EgoStatisticIdentifiers.EGO_POINTS.identifier, value)
    updateSpentEgo(user, value)
}
