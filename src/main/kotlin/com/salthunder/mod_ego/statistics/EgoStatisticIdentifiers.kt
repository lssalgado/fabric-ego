package com.salthunder.mod_ego.statistics

import com.salthunder.mod_ego.Ego.EGO_ID
import net.minecraft.util.Identifier

object EgoStatisticIdentifiers {
    class StatisticIdentifier(val path: String) {
        val identifier = Identifier(EGO_ID, path)
    }
    val EGO_CONSUMPTION = StatisticIdentifier("ego_consumption")
}