package com.example.mod.init

import com.example.mod.Main
import com.ultreon.craft.block.Block
import com.ultreon.craft.registry.Registries
import com.ultreon.libs.registries.v0.DelayedRegister

object ModBlocks {
    private val register = DelayedRegister.create(Main.MOD_ID, Registries.BLOCK)

    val example = register.register("example", ::Block)

    fun register() {
        register.register()
    }
}