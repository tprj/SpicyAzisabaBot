package net.azisaba.spicyAzisabaBot.structures

import kotlinx.serialization.json.JsonObject
import net.azisaba.spicyAzisabaBot.util.getObjectArray

data class CVEDataReference(
    val referenceData: List<CVEDataReferenceData>,
) {
    companion object {
        fun read(obj: JsonObject): CVEDataReference {
            val referenceData = obj.getObjectArray("reference_data")!!.map { CVEDataReferenceData.read(it) }
            return CVEDataReference(referenceData)
        }
    }
}
