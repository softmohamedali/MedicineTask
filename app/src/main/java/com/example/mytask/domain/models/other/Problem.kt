package com.example.mytask.domain.models.other

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class Problem(
    @SerialName("Asthma")
    val Asthma: List<Asthma> = listOf(),
    @SerialName("Diabetes")
    val Diabetes: List<Diabete> = listOf()
)