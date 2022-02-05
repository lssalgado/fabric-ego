package com.salthunder.mod_ego

import com.salthunder.mod_ego.items.FirstEgo
import com.salthunder.mod_ego.items.HasteEgo
import com.salthunder.mod_ego.statuseffects.SpeedEffect
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.event.player.AttackBlockCallback
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.registry.Registry
import net.minecraft.world.World


@Suppress("UNUSED")
object ModName : ModInitializer {
    private const val mod_ego = "mod_ego"

    val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(mod_ego, "general")) { ItemStack(Blocks.COBBLESTONE) }
    val OTHER_GROUP = FabricItemGroupBuilder.build(Identifier(mod_ego, "other")) { ItemStack(Items.BOWL) }

    val EGO_SPEED = FirstEgo(FabricItemSettings().group(ITEM_GROUP))
    val EGO_HASTE = HasteEgo(FabricItemSettings().group(ITEM_GROUP))

    val SPEED = SpeedEffect()

    override fun onInitialize() {
        println("Example mod has been initialized.")
        Registry.register(Registry.ITEM, Identifier("ego", "speed_item"), EGO_SPEED)
        Registry.register(Registry.ITEM, Identifier("ego", "haste_item"), EGO_HASTE)
        Registry.register(Registry.STATUS_EFFECT, Identifier("ego", "speed"), SPEED)

        AttackBlockCallback.EVENT.register(AttackBlockCallback { player, world, hand, pos, direction ->
            val state = world.getBlockState(pos)

            state.block.


            ActionResult.PASS
        })
    }
}