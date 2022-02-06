package com.salthunder.mod_ego.items

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

object EgoPieces {
    val ZOMBIE_EGO = PieceOfEgo(EgoFoodComponents.ZOMBIE_EGO, 1) { livingEntity ->
        if (livingEntity is ServerPlayerEntity) {
            livingEntity.sendMessage(Text.of("Extra action :D"), false)
        }
    }
}