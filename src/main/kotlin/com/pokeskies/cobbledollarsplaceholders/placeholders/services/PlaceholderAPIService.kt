package com.pokeskies.cobbledollarsplaceholders.placeholders.services

import com.pokeskies.cobbledollarsplaceholders.placeholders.IPlaceholderService
import com.pokeskies.cobbledollarsplaceholders.utils.Utils
import eu.pb4.placeholders.api.PlaceholderResult
import eu.pb4.placeholders.api.Placeholders
import fr.harmex.cobbledollars.common.utils.extensions.getCobbleDollars
import net.minecraft.resources.ResourceLocation

class PlaceholderAPIService : IPlaceholderService {
    init {
        Utils.printInfo("PlaceholderAPI mod found! Registering placeholders...")
    }

    override fun registerPlaceholders() {
        Placeholders.register(ResourceLocation.fromNamespaceAndPath("cobbledollars", "balance")) { ctx, arg ->
            if (!ctx.hasPlayer()) PlaceholderResult.invalid("No player!")
            PlaceholderResult.value(ctx.player!!.getCobbleDollars().toString())
        }
    }
}
