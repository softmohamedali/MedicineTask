package com.example.mytask.data.remote

import android.util.Log
import com.example.mytask.core.utils.Constants.myJson
import com.example.mytask.domain.abstractions.MedicineApi
import com.example.mytask.domain.models.other.UserProplems
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Singleton
class RemoteDataSource():MedicineApi {
    override suspend fun getUserMedicines(): UserProplems {
        val format = Json { ignoreUnknownKeys = true }
        val result=format.decodeFromString(UserProplems.serializer(), myJson)
        return result
    }
}