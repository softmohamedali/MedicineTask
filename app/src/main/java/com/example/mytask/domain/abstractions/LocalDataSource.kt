package com.example.mytask.domain.abstractions

import com.example.mytask.data.local.entitys.UserEntity
import com.example.mytask.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getUsers():Flow<List<User>>
    suspend fun addUser(userEntity: UserEntity)
}