package net.azisaba.spicyAzisabaBot.structures

import kotlinx.serialization.json.JsonObject
import net.azisaba.spicyAzisabaBot.util.getString

data class CVELangValueEntry(
    val lang: String,
    val value: String,
) {
    companion object {
        fun read(obj: JsonObject): CVELangValueEntry {
            val lang = obj.getString("lang")!!
            val value = obj.getString("value")!!
            return CVELangValueEntry(lang, value)
        }
    }
}
