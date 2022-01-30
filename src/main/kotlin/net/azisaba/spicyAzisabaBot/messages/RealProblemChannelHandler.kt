package net.azisaba.spicyAzisabaBot.messages

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.TextChannel

object RealProblemChannelHandler : MessageHandler {
    override fun canProcess(message: Message): Boolean = message.channelId == Snowflake(760438206847123497L)

    override suspend fun handle(message: Message) {
        if (message.author?.isBot != false) return
        val content = message.content.lines().getOrNull(0) ?: return
        if (content.startsWith("^")) return
        (message.channel.fetchChannel() as TextChannel).startPublicThread(content) {
            this.invitable = true
        }
    }
}