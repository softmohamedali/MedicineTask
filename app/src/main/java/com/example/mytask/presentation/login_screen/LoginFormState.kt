package com.example.mytask.presentation.login_screen

data class LoginFormState(
    val email:String="",
    val emailError:String?=null,
    val password:String="",
    val passwordError:String?=null,
    val success:Boolean=false,
    val error:String?=null,
    val isLoading:Boolean=false

)
