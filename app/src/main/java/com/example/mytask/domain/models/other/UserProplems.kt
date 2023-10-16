package com.example.mytask.domain.models.other

import kotlinx.serialization.Serializable

@Serializable
data class UserProplems(
    val problems: List<Problem> = listOf()
)