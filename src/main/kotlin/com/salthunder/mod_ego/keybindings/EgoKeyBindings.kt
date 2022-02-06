package com.salthunder.mod_ego.keybindings

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.text.LiteralText
import org.lwjgl.glfw.GLFW


object EgoKeyBindings {

    class KeyAction(val keyBinding: KeyBinding, val action: ClientTickEvents.EndTick)
    private val OpenInterface = KeyAction ( KeyBinding(
        "key.ego.open_interface",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.ego.menu"
    )) { client ->
        //TODO open UI
        client.player!!.sendMessage(LiteralText("Key R was pressed!"), false)
    }

    private fun registerKeyAction(keyAction: KeyAction) {
        val keyBinding = KeyBindingHelper.registerKeyBinding(keyAction.keyBinding)
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            while(keyBinding.wasPressed()) {
                keyAction.action.onEndTick(client)
            }
        }
    }

    fun registerKeyBindings() {
        registerKeyAction(OpenInterface)
    }
}