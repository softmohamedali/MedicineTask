package com.example.mytask.domain.abstractions

import com.example.mytask.domain.models.User
import com.example.mytask.domain.models.other.UserProplems
import kotlinx.coroutines.flow.Flow

interface Repo {
    suspend fun getUsers(): Flow<List<User>>
    suspend fun addUser(user: User)
    suspend fun getUserMedicines(): UserProplems
}