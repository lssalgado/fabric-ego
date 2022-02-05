package com.salthunder.mod_ego

import com.salthunder.mod_ego.items.FirstEgo
import com.salthunder.mod_ego.statuseffects.SpeedEffect
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


@Suppress("UNUSED")
object ModName : ModInitializer {
    private const val mod_ego = "mod_ego"

    val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(mod_ego, "general")) { ItemStack(Blocks.COBBLESTONE) }
    val OTHER_GROUP = FabricItemGroupBuilder.build(Identifier(mod_ego, "other")) { ItemStack(Items.BOWL) }

    val EGO_SPEED = FirstEgo(FabricItemSettings().group(ITEM_GROUP))

    val SPEED = SpeedEffect()

    override fun onInitialize() {
        println("Example mod has been initialized.")
        Registry.register(Registry.ITEM, Identifier("ego", "speed_item"), EGO_SPEED)
        Registry.register(Registry.STATUS_EFFECT, Identifier("ego", "speed"), SPEED)
    }
}