package com.example.mytask.domain.usecases

import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.models.ResultState
import com.example.mytask.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


class GetUsersUseCase constructor (
    private val repo: Repo
){
    suspend operator fun invoke(): Flow<ResultState<List<User>>> {
        return flow {
            emit(ResultState.IsLoading)
            try{
                repo.getUsers().collect{
                    emit(ResultState.IsSucsses(it))
                }
            }catch (e: IOException){
                emit(ResultState.IsError(msg = "IO Exception ${e.message}"))
            }catch (e:Exception){
                emit(ResultState.IsError(msg = "Exception ${e.message}"))
            }
        }
    }
}