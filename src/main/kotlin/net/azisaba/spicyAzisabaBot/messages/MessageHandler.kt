package net.azisaba.spicyAzisabaBot.messages

import dev.kord.core.entity.Message

interface MessageHandler {
    fun canProcess(message: Message): Boolean
    suspend fun handle(message: Message)
}
