package com.example.mytask.domain.models.other

import kotlinx.serialization.Serializable

@Serializable

data class Diabete(
    val labs: List<Lab> = listOf(),
    val medications: List<Medication> = listOf()
)