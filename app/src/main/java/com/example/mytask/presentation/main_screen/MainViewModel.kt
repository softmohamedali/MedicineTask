package com.example.mytask.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytask.domain.models.ResultState
import com.example.mytask.domain.models.other.AssociatedDrug
import com.example.mytask.domain.models.other.Problem
import com.example.mytask.domain.models.other.UserProplems
import com.example.mytask.domain.usecases.GetUserMedicineUseCase
import com.example.mytask.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserMedicineUseCase : GetUserMedicineUseCase
) : ViewModel() {

    var state by mutableStateOf(MainScreenState())

    init {
        isUserLogin()
    }

    private fun isUserLogin() {
        viewModelScope.launch {
            getUserUseCaseInIO().collect {
                when {
                    it is ResultState.IsSucsses -> {
                        if (!it.data!!.isEmpty()) {
                            state=state.copy(
                                isLogin = true,
                                error = null,
                                loading = false,
                                userName = it.data[0].email
                            )
                            getMedicens()
                        }else{
                            state=state.copy(
                                isLogin = false)
                        }
                    }

                    it is ResultState.IsError -> {
                        state = state.copy(
                            error = it.message,
                            loading = false,
                        )
                    }

                    it is ResultState.IsLoading -> {
                        state = state.copy(
                            error = null,
                            loading = true,
                        )
                    }
                }
            }
        }
    }

    private fun getMedicens() {
        viewModelScope.launch {
            getUserMedicineUseCaseInIO().collect{
                when {
                    it is ResultState.IsSucsses -> {
                        state = state.copy(
                            error = null,
                            loading = false,
                            success = true,
                        )
                        handleProplemData(it.data!!.problems)
                    }

                    it is ResultState.IsError -> {
                        state = state.copy(
                            error = it.message,
                            loading = false,
                            success = false
                        )
                    }

                    it is ResultState.IsLoading -> {
                        state = state.copy(
                            error = null,
                            loading = true,
                            success = false
                        )
                    }
                }
            }
        }
    }


    private fun handleProplemData(proplems: List<Problem>) {
        val medications= mutableListOf<AssociatedDrug>()
//        val listone=proplems[0].Diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0]
//        val list2=proplems[0].Diabetes[0].medications[0].medicationsClasses[0].className2[0].associatedDrug2[0]
//        this more dynamic that if we have more than class 1 or 2
        for (proplem in proplems){
            for (diaetes in proplem.Diabetes){
                for (medication in diaetes.medications){
                    for (myclass in medication.medicationsClasses){
                        for (nameclass in myclass.className){
                            for (associatedDrug in nameclass.associatedDrug){
                                medications.add(associatedDrug)
                            }
                            for (associatedDrug in nameclass.associatedDrug2){
                                medications.add(associatedDrug)
                            }
                        }
                        for (nameclass in myclass.className2){
                            for (associatedDrug in nameclass.associatedDrug){
                                medications.add(associatedDrug)
                            }
                            for (associatedDrug in nameclass.associatedDrug2){
                                medications.add(associatedDrug)
                            }
                        }
                    }
                }
            }
        }
        state=state.copy(listMedicine =medications)
    }

    private suspend fun getUserUseCaseInIO() = withContext(Dispatchers.IO) {
        getUsersUseCase()
    }

    private suspend fun getUserMedicineUseCaseInIO() = withContext(Dispatchers.IO) {
        getUserMedicineUseCase()
    }

}