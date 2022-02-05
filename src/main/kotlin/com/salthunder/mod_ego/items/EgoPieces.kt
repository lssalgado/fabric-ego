package com.salthunder.mod_ego.items

import com.salthunder.mod_ego.statistics.EgoStatisticIdentifiers
import net.minecraft.item.ItemStack
import net.minecraft.item.Items.GOLDEN_APPLE
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.Text

object EgoPieces {
    val ZOMBIE_EGO = PieceOfEgo(EgoFoodComponents.ZOMBIE_EGO, 1) { livingEntity ->
        if (livingEntity is ServerPlayerEntity) {
            livingEntity.sendMessage(Text.of("Extra action :D"), false)

            /**TODO move to [PieceOfEgo] and improve this code*/
            val consumed =
                livingEntity.statHandler.getStat(Stats.CUSTOM, EgoStatisticIdentifiers.EGO_CONSUMPTION.identifier)
            livingEntity.sendMessage(Text.of("Consumed: '$consumed'"), false)
            if (consumed % 5 == 0) {
                livingEntity.giveItemStack(ItemStack({ GOLDEN_APPLE }, 1))
            }
        }
    }
}