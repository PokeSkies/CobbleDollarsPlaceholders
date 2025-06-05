package com.pokeskies.cobbledollarsplaceholders.utils

import com.pokeskies.cobbledollarsplaceholders.CobbleDollarsPlaceholders

object Utils {
    fun printError(message: String?) {
        CobbleDollarsPlaceholders.LOGGER.error("[${CobbleDollarsPlaceholders.MOD_NAME}] ERROR: $message")
    }

    fun printInfo(message: String?) {
        CobbleDollarsPlaceholders.LOGGER.info("[${CobbleDollarsPlaceholders.MOD_NAME}] $message")
    }
}
