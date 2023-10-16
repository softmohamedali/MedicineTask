package com.example.mytask.domain.models.other

import kotlinx.serialization.Serializable

@Serializable
data class MedicationsClasse(
    val className: List<ClassName> = listOf(),
    val className2: List<ClassName> = listOf()
)
//data class MedicationsClasse(
//    val className: List<Map<String,List<Map<String,String>>>> = listOf(),
//    val className2: List<Map<String,List<Map<String,String>>>> = listOf()
//)