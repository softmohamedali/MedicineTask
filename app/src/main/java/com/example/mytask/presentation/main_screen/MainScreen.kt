package com.example.mytask.presentation.main_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mytask.core.utils.DateTimeFormatted
import com.example.mytask.domain.models.other.tojson
import com.example.mytask.presentation.main_screen.component.MainView
import com.example.mytask.presentation.main_screen.component.MedicineItem
import com.example.mytask.presentation.navigation.Screens


@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
)  {

    val state=mainViewModel.state

    LaunchedEffect(key1 = state.isLogin){
        if (!state.isLogin){
            navController.popBackStack()
            navController.navigate(Screens.Login.route)
        }
    }

    MainView(
        todayDate=DateTimeFormatted.getCurrentTodayDate(),
        userName = state.userName,
        onLogOutClick = {

        },
        isLoading =state.loading ,
        error =state.error ,
        medicines =state.listMedicine ,
        onMedicineClick = {
            navController.navigate(Screens.Details.passAndNavToDetails(it.tojson()))
        }
    )

}