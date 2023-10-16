package com.example.mytask.presentation.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytask.domain.models.ResultState
import com.example.mytask.domain.models.User
import com.example.mytask.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase
) : ViewModel() {


    var state by mutableStateOf(LoginFormState())

    fun login() {
        viewModelScope.launch {
            loginInIo(
                User(
                    email = state.email,
                    password = state.password,
                )
            ).collect {
                when {
                    it is ResultState.IsSucsses -> {
                        state = state.copy(
                            success = true,
                            error = null,
                            isLoading = false,
                        )
                    }

                    it is ResultState.IsError -> {
                        state = state.copy(
                            error = it.message,
                            isLoading = false,
                            success = false
                        )
                    }

                    it is ResultState.IsLoading -> {
                        state = state.copy(
                            error = null,
                            isLoading = true,
                            success = false
                        )
                    }
                }
            }
        }

    }

    suspend fun loginInIo(user: User) = withContext(Dispatchers.IO) {
        loginUseCase(user)
    }
}