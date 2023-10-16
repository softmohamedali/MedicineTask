package com.example.mytask.domain.models.other

import kotlinx.serialization.Serializable

@Serializable

data class Medication(
    val medicationsClasses: List<MedicationsClasse> = listOf()
)