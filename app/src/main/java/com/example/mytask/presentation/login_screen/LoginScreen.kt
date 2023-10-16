package com.example.mytask.presentation.login_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mytask.presentation.login_screen.componenet.LoginView
import com.example.mytask.presentation.navigation.Screens


@Composable
fun LoginScreen(
    navController: NavHostController,
    logInViewModel: LoginViewModel = hiltViewModel(),
) {

    val state =logInViewModel.state
    //this technic made ui testing easy

    LaunchedEffect(key1 = state, block ={
        if (state.success){
            navController.popBackStack()
            navController.navigate(Screens.Main.route)
        }
    } )
    LoginView(
        email = state.email,
        password = state.password,
        isLoading = state.isLoading,
        isError = state.error,
        isSucsses = state.success,
        isEmailError =state.emailError!=null ,
        emailError = state.emailError,
        ispasswordError = state.passwordError!=null,
        passwordError = state.passwordError,
        onPasswordChange = {
            logInViewModel.state=state.copy(password = it)
        },
        onEmailChange = {
            logInViewModel.state=state.copy(email = it)
        },
        onLoginClick = {
                       logInViewModel.login()
        },
    )


}