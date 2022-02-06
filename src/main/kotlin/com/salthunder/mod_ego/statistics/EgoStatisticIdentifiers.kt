package com.salthunder.mod_ego.statistics

import com.salthunder.mod_ego.Ego.EGO_ID
import net.minecraft.stat.StatFormatter
import net.minecraft.stat.Stats
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object EgoStatisticIdentifiers {

    class StatisticIdentifier(val path: String) {
        val identifier = Identifier(EGO_ID, path)
    }

    val EGO_CONSUMPTION = StatisticIdentifier("ego_consumption")
    val EGO_POINTS = StatisticIdentifier("ego_points")
    val EGO_POINTS_SPENT = StatisticIdentifier("ego_points_spent")
    val EGO_POINTS_UNSPENT = StatisticIdentifier("ego_points_unspent")

    private fun registerStatisticIdentifier(statisticIdentifier: StatisticIdentifier) {
        Registry.register(Registry.CUSTOM_STAT, statisticIdentifier.path, statisticIdentifier.identifier)
    }

    private fun createStat(statisticIdentifier: StatisticIdentifier) {
        Stats.CUSTOM.getOrCreateStat(statisticIdentifier.identifier, StatFormatter.DEFAULT)
    }

    private fun registerStatistics(statisticIdentifier: StatisticIdentifier) {
        registerStatisticIdentifier(statisticIdentifier)
        createStat(statisticIdentifier)
    }

    fun register() {
        registerStatistics(EGO_CONSUMPTION)
        registerStatistics(EGO_POINTS)
        registerStatistics(EGO_POINTS_SPENT)
        registerStatistics(EGO_POINTS_UNSPENT)
    }
}