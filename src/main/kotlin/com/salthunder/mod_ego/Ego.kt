package com.salthunder.mod_ego

import com.salthunder.mod_ego.items.EgoPieces
import com.salthunder.mod_ego.items.FirstEgo
import com.salthunder.mod_ego.statistics.EgoStatisticIdentifiers
import com.salthunder.mod_ego.statuseffects.SpeedEffect
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.stat.StatFormatter
import net.minecraft.stat.Stats
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


@Suppress("UNUSED")
object Ego : ModInitializer {
    const val EGO_ID = "mod_ego"

    private val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(EGO_ID, "general")) { ItemStack(Blocks.COBBLESTONE) }
    val FOOD_GROUP: ItemGroup = FabricItemGroupBuilder.build(Identifier(EGO_ID, "foods")) { ItemStack(Items.BOWL) }

    private val EGO_SPEED = FirstEgo(FabricItemSettings().group(ITEM_GROUP))

    private val SPEED = SpeedEffect()

    override fun onInitialize() {
        println("Example mod has been initialized.")
        registerStatistics()
        registerItems()
        registerTools()
        registerPieces()
        registerStatus()
    }

    private fun registerStatisticIdentifier(statisticIdentifier: EgoStatisticIdentifiers.StatisticIdentifier) {
        Registry.register(Registry.CUSTOM_STAT, statisticIdentifier.path, statisticIdentifier.identifier)
    }

    private fun registerStatistics() {
        registerStatisticIdentifier(EgoStatisticIdentifiers.EGO_CONSUMPTION)
        Stats.CUSTOM.getOrCreateStat(EgoStatisticIdentifiers.EGO_CONSUMPTION.identifier, StatFormatter.DEFAULT)
    }

    private fun registerStatus() {
        Registry.register(Registry.STATUS_EFFECT, Identifier("ego", "speed"), SPEED)
    }

    private fun registerPieces() {
        Registry.register(
            Registry.ITEM,
            Identifier("ego", "zombie_ego"),
            EgoPieces.ZOMBIE_EGO
        )
    }

    private fun registerTools() {

    }

    private fun registerItems() {
        Registry.register(Registry.ITEM, Identifier("ego", "speed_item"), EGO_SPEED)
    }
}