package com.mod_author.mod_id

import com.mod_author.mod_id.items.FirstEgo
import com.mod_author.mod_id.statuseffects.SpeedEffect
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
    private const val MOD_ID = "mod_id"

    val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(MOD_ID, "general")) { ItemStack(Blocks.COBBLESTONE) }
    val OTHER_GROUP = FabricItemGroupBuilder.build(Identifier(MOD_ID, "other")) { ItemStack(Items.BOWL) }

    val FABRIC_ITEM = Item(FabricItemSettings().group(OTHER_GROUP))
    val FIRST_EGO = FirstEgo(FabricItemSettings().group(ITEM_GROUP))

    val SPEED = SpeedEffect()

    override fun onInitialize() {
        println("Example mod has been initialized.")
        Registry.register(Registry.ITEM, Identifier("tutorial", "fabric_item"), FABRIC_ITEM)
        Registry.register(Registry.ITEM, Identifier("tutorial", "fabric_item2"), FIRST_EGO)
        Registry.register(Registry.STATUS_EFFECT, Identifier("tutorial", "speed"), SPEED)
    }
}