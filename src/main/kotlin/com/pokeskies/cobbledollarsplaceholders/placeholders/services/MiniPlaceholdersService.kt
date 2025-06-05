package com.pokeskies.cobbledollarsplaceholders.placeholders.services

import com.pokeskies.cobbledollarsplaceholders.placeholders.IPlaceholderService
import com.pokeskies.cobbledollarsplaceholders.utils.Utils
import fr.harmex.cobbledollars.common.utils.extensions.getCobbleDollars
import io.github.miniplaceholders.api.Expansion
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.tag.Tag
import net.minecraft.server.level.ServerPlayer

class MiniPlaceholdersService : IPlaceholderService {
    init {
        Utils.printInfo("MiniPlaceholders mod found! Registering placeholders...")
    }

    override fun registerPlaceholders() {
        val builder = Expansion.builder("cobbledollars")
            .filter(ServerPlayer::class.java)
            .audiencePlaceholder("balance") { audience, queue, _ ->
                val player = audience as ServerPlayer

                return@audiencePlaceholder Tag.inserting(Component.text(player.getCobbleDollars().toString()))
            }

        builder.build().register()
    }
}
