package com.pokeskies.cobbledollarsplaceholders

import com.pokeskies.cobbledollarsplaceholders.placeholders.PlaceholderManager
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.server.MinecraftServer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CobbleDollarsPlaceholders : ModInitializer {
    companion object {
        lateinit var INSTANCE: CobbleDollarsPlaceholders

        var MOD_ID = "cobbledollarsplaceholders"
        var MOD_NAME = "CobbleDollarsPlaceholders"

        val LOGGER: Logger = LogManager.getLogger(MOD_ID)
    }

    lateinit var placeholderManager: PlaceholderManager
    lateinit var server: MinecraftServer

    override fun onInitialize() {
        INSTANCE = this

        this.placeholderManager = PlaceholderManager()

        ServerLifecycleEvents.SERVER_STARTING.register(ServerLifecycleEvents.ServerStarting { server: MinecraftServer ->
            this.server = server
        })
        ServerLifecycleEvents.SERVER_STARTED.register(ServerLifecycleEvents.ServerStarted { server: MinecraftServer ->
            placeholderManager.registerPlaceholders()
        })
    }
}
