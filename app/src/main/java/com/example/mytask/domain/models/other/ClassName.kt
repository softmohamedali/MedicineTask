package com.example.mytask.domain.models.other

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class ClassName(
    val associatedDrug: List<AssociatedDrug> = listOf(),
    @SerialName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug> = listOf()
)
