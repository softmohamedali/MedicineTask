package com.example.mytask.domain.usecases

import android.util.Log
import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.models.ResultState
import com.example.mytask.domain.models.other.UserProplems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetUserMedicineUseCase constructor (
    private val repo: Repo
){
    suspend operator fun invoke(): Flow<ResultState<UserProplems>> {
        return flow {
            emit(ResultState.IsLoading)
            try{
                val result=repo.getUserMedicines()
                emit(ResultState.IsSucsses(result))
            }catch (e: IOException){
                Log.d("exception",e.message.toString())
                emit(ResultState.IsError(msg = "IO Exception ${e.message}"))
            }catch (e:Exception){
                Log.d("exception",e.message.toString())
                emit(ResultState.IsError(msg = "Exception ${e.message}"))
            }
        }
    }
}