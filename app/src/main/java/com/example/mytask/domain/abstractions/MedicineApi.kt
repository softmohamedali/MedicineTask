package com.example.mytask.domain.abstractions

import com.example.mytask.domain.models.other.UserProplems

interface MedicineApi {
    suspend fun getUserMedicines(): UserProplems
}