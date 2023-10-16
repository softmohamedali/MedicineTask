package com.example.mytask.data.repo

import com.example.mytask.data.local.entitys.toUserEntity
import com.example.mytask.data.remote.RemoteDataSource
import com.example.mytask.domain.abstractions.LocalDataSource
import com.example.mytask.domain.abstractions.MedicineApi
import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.models.User
import com.example.mytask.domain.models.other.UserProplems
import kotlinx.coroutines.flow.Flow


//here to make repo single source of truth
//if we have some cooperative between local and remote for example cashing and paging

class RepoImp (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: MedicineApi
): Repo {

    override suspend fun getUsers(): Flow<List<User>> {
        return localDataSource.getUsers()
    }

    override suspend fun addUser(user: User) {
        localDataSource.addUser(user.toUserEntity())
    }

    override suspend fun getUserMedicines(): UserProplems {
        return remoteDataSource.getUserMedicines()
    }

}