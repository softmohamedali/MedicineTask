package com.example.mytask.presentation.login_screen.componenet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytask.presentation.my_comonents.LoadingLayer


@Composable
fun LoginView(
    email:String,
    isEmailError:Boolean,
    emailError:String?,
    password:String,
    ispasswordError:Boolean,
    passwordError:String?,
    isLoading:Boolean,
    isSucsses:Boolean,
    isError: String?,
    onEmailChange:(String)-> Unit,
    onPasswordChange:(String)-> Unit,
    onLoginClick:()->Unit,
){
    val stateScrollable= rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(stateScrollable)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
        ) {


            Text(text = "Log In",style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
            )
            )
            Spacer(modifier = Modifier.height(30.dp))
            MyTextField(
                value =email, label ="Enter your Email",
                onValueChange = {
                    onEmailChange(it)
                },
                isError = isEmailError,
                error = emailError,
                keybordoption = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextField(
                value =password,
                label ="Enter Your Password",
                onValueChange = {
                    onPasswordChange(it)
                },
                isError = ispasswordError,
                error = passwordError
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log In")
            }
            Spacer(modifier = Modifier.height(50.dp))

        }
        if (isSucsses){

        }
        if (isLoading){
            LoadingLayer()
        }
        if (isError!=null){

        }
    }
}