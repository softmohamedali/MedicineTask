package com.example.mytask.data.local

import com.example.mytask.data.local.entitys.UserEntity
import com.example.mytask.data.local.entitys.toUser
import com.example.mytask.domain.abstractions.LocalDataSource
import com.example.mytask.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class LocalDataSourceImp(
    private val myDao: MyDao
) : LocalDataSource {

    override suspend fun getUsers(): Flow<List<User>> = flow {
        myDao.getUsers().collect {
            emit(it.map { it.toUser() })
        }
    }

    override suspend fun addUser(userEntity: UserEntity) = myDao.insertUser(userEntity)


}