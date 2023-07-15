package com.example.mod

import com.example.mod.init.ModBlocks
import com.ultreon.craft.BlockModelRegistry
import com.ultreon.craft.GamePlatform
import com.ultreon.craft.events.BlockEvents
import com.ultreon.craft.events.WorldEvents
import com.ultreon.craft.registry.Registries
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger

object Main : ModInitializer {
    const val MOD_ID = "examplemod"
    val logger: Logger = GamePlatform.instance.getLogger("ExampleMod")

    override fun onInitialize() {
        logger.info("Mod got initialized!")

        ModBlocks.register()
        BlockModelRegistry.registerDefault(ModBlocks.example)

        BlockEvents.SET_BLOCK.listen { world, pos, block ->
            if (block.isAir) return@listen

            world[pos] = Registries.BLOCK.values().random()
        }
    }

}