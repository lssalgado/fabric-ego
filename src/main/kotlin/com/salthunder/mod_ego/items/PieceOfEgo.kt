package com.salthunder.mod_ego.items

import com.salthunder.mod_ego.Ego.FOOD_GROUP
import com.salthunder.mod_ego.statistics.increaseConsumption
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World

class PieceOfEgo(
    foodComponent: FoodComponent,
    private val value: Int,
    maxCount: Int = 16,
    private val extraEffects: (LivingEntity) -> Unit
) : Item(FabricItemSettings().food(foodComponent).group(FOOD_GROUP).maxCount(maxCount)) {
    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        if (user is ServerPlayerEntity) {
            increaseConsumption(user, value)
            extraEffects(user)
        }
        return super.finishUsing(stack, world, user)
    }
}