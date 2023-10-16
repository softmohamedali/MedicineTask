package com.example.mytask.domain.models.other

import com.example.mytask.core.utils.Constants
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable

data class AssociatedDrug(
    val dose: String="",
    val name: String="",
    val strength: String=""
)

fun String.toAssociatedDrug():AssociatedDrug{
    return Json.decodeFromString(this)
}

fun AssociatedDrug.tojson():String{
    return Json.encodeToString(this)
}


