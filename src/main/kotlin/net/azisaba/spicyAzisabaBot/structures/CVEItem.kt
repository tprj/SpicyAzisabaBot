package net.azisaba.spicyAzisabaBot.structures

import kotlinx.serialization.json.JsonObject
import net.azisaba.spicyAzisabaBot.util.getObject
import net.azisaba.spicyAzisabaBot.util.getString

data class CVEItem(
    val configurations: CVEItemConfigurations,
    val cve: CVEData,
    val impact: CVEItemImpact,
    val lastModifiedDate: String,
    val publishedDate: String,
) {
    companion object {
        fun read(obj: JsonObject): CVEItem {
            val configurations = CVEItemConfigurations.read(obj.getObject("configurations")!!)
            val cve = CVEData.read(obj.getObject("cve")!!)
            val impact = CVEItemImpact.read(obj.getObject("impact")!!)
            val lastModifiedDate = obj.getString("lastModifiedDate")!!
            val publishedDate = obj.getString("publishedDate")!!
            return CVEItem(configurations, cve, impact, lastModifiedDate, publishedDate)
        }
    }
}
