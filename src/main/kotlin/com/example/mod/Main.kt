package com.example.mod

import com.example.mod.init.ModBlocks
import com.ultreon.craft.BlockModelRegistry
import com.ultreon.craft.GamePlatform
import com.ultreon.craft.entity.Player
import com.ultreon.craft.events.LifecycleEvents
import com.ultreon.libs.collections.v0.util.ArrayUtils
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger

object Main : ModInitializer {
    const val MOD_ID = "examplemod"
    val logger: Logger = GamePlatform.instance.getLogger("ExampleMod")

    override fun onInitialize() {
        logger.info("Mod got initialized!")

        ModBlocks.register()
        BlockModelRegistry.registerDefault(ModBlocks.example)

        LifecycleEvents.GAME_LOADED.listen {
            Player.allowed = ArrayUtils.add(Player.allowed, ModBlocks.example.get())
        }
    }
}