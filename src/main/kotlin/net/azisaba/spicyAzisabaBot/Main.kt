@file:JvmName("MainKt")
package net.azisaba.spicyAzisabaBot

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.event.guild.MemberJoinEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import net.azisaba.spicyAzisabaBot.messages.AddRolesMessageHandler
import net.azisaba.spicyAzisabaBot.messages.CVEMessageHandler
import net.azisaba.spicyAzisabaBot.messages.CountRoleMembersMessageHandler
import net.azisaba.spicyAzisabaBot.messages.CreateMessageHandler
import net.azisaba.spicyAzisabaBot.messages.EditMessageHandler
import net.azisaba.spicyAzisabaBot.messages.RealProblemChannelHandler
import net.azisaba.spicyAzisabaBot.messages.StatsMessageHandler
import net.azisaba.spicyAzisabaBot.messages.VoteMessageHandler

private val messageHandlers = listOf(
    CVEMessageHandler,
    StatsMessageHandler,
    CountRoleMembersMessageHandler,
)

@OptIn(PrivilegedIntent::class)
suspend fun main() {
    val client = Kord(System.getenv("BOT_TOKEN"))

    client.on<MessageCreateEvent> {
        val handler = messageHandlers.findLast { it.canProcess(message) } ?: return@on
        handler.handle(message)
    }

    client.on<ReadyEvent> {
        println("Logged in!")
    }

    client.login { this.intents = Intents(Intent.GuildMembers, Intent.GuildMessages) }
}
