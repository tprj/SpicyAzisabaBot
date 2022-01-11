package net.azisaba.spicyAzisabaBot.messages

import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.Message
import dev.kord.rest.builder.message.EmbedBuilder

class VoteMessageHandler: MessageHandler {
    override fun canProcess(message: Message): Boolean = message.content == "/vote"

    override suspend fun handle(message: Message) {
        val embeds = mutableListOf<EmbedBuilder>()
        val builder = EmbedBuilder()
        builder.title = "投票URL"
        builder.url = "https://www.azisaba.net/"
        builder.description = "毎日しよう!!!!"
        builder.field("Japan Minecraft Servers") {
            "https://minecraft.jp/servers/azisaba.net"
        }
        builder.field("monocraft") {
            "https://monocraft.net/servers/xWBVrf1nqB2P0LxlMm2v"
        }
        embeds.add(builder)
        message.channel.createMessage {
            this.embeds.addAll(embeds)
        }
    }
}
