package com.salthunder.mod_ego

import com.salthunder.mod_ego.items.EgoPieces
import com.salthunder.mod_ego.items.FirstEgo
import com.salthunder.mod_ego.statuseffects.SpeedEffect
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


@Suppress("UNUSED")
object ModName : ModInitializer {
    private const val mod_ego = "mod_ego"

    private val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(mod_ego, "general")) { ItemStack(Blocks.COBBLESTONE) }
    val FOOD_GROUP: ItemGroup = FabricItemGroupBuilder.build(Identifier(mod_ego, "foods")) { ItemStack(Items.BOWL) }

    private val EGO_SPEED = FirstEgo(FabricItemSettings().group(ITEM_GROUP))

    private val SPEED = SpeedEffect()

    override fun onInitialize() {
        println("Example mod has been initialized.")
        registerItems()
        registerTools()
        registerPieces()
        registerStatus()
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