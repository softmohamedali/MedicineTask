package com.example.mytask.domain.usecases

import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.models.ResultState
import com.example.mytask.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


class LoginUseCase constructor (
    val repo: Repo
){
    suspend operator fun invoke(user: User): Flow<ResultState<Any>> {
        return flow {
            emit(ResultState.IsLoading)
            try{
                repo.addUser(user)
                emit(ResultState.IsSucsses(null))
            }catch (e: IOException){
                emit(ResultState.IsError(msg = "IO Exception ${e.message}"))
            }catch (e:Exception){
                emit(ResultState.IsError(msg = "Exception ${e.message}"))
            }
        }
    }
}