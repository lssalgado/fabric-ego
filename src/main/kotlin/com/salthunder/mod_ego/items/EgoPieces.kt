package com.salthunder.mod_ego.items

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

object EgoPieces {
    val ZOMBIE_EGO = PieceOfEgo(EgoFoodComponents.ZOMBIE_EGO) { livingEntity ->
        if (livingEntity is ServerPlayerEntity) {
            //TODO add statistic
            livingEntity.sendMessage(Text.of("Extra action :D"), false)
        }
    }
}