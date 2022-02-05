package com.salthunder.mod_ego.items

import com.salthunder.mod_ego.ModName.FOOD_GROUP
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World

class PieceOfEgo(foodComponent: FoodComponent, private val extraEffects: (LivingEntity) -> Unit): Item(FabricItemSettings().food(foodComponent).group(FOOD_GROUP)) {
    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        if (user is ServerPlayerEntity) {
            extraEffects(user)
        }
        return super.finishUsing(stack, world, user)
    }
}