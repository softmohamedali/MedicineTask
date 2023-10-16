package com.example.mytask.presentation.main_screen

import com.example.mytask.domain.models.other.AssociatedDrug
import com.example.mytask.domain.models.other.Medication
import com.example.mytask.domain.models.other.Problem

data class MainScreenState(
    val isLogin:Boolean=true,
    val loading:Boolean=false,
    val success:Boolean=false,
    val error:String?=null,
    val listMedicine: List<AssociatedDrug> = listOf(),
    val userName:String=""
)
