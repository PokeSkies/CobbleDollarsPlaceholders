package com.pokeskies.cobbledollarsplaceholders.placeholders.services

import com.pokeskies.cobbledollarsplaceholders.CobbleDollarsPlaceholders
import com.pokeskies.cobbledollarsplaceholders.placeholders.IPlaceholderService
import com.pokeskies.cobbledollarsplaceholders.utils.Utils
import fr.harmex.cobbledollars.common.utils.extensions.getCobbleDollars
import net.impactdev.impactor.api.Impactor
import net.impactdev.impactor.api.platform.sources.PlatformSource
import net.impactdev.impactor.api.text.placeholders.PlaceholderService
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component

class ImpactorPlaceholderService : IPlaceholderService {
    init {
        Utils.printInfo("Impactor mod found! Registering placeholders...")
    }

    override fun registerPlaceholders() {
        val service = Impactor.instance().services().provide(PlaceholderService::class.java)

        service.register(
            Key.key("cobbledollars", "balance")
        ) { viewer, ctx ->
            val player: PlatformSource = ctx.request(PlatformSource::class.java).orElse(viewer)

            return@register Component.text(
                CobbleDollarsPlaceholders.INSTANCE.server.playerList.getPlayer(player.uuid())?.getCobbleDollars().toString(),
            )
        }
    }
}
