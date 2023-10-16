package com.example.mytask.presentation.main_screen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytask.domain.models.other.AssociatedDrug
import com.example.mytask.presentation.my_comonents.Center
import com.example.mytask.presentation.my_comonents.LoadingLayer

@Composable
fun MainView(
    todayDate:String,
    userName:String,
    onLogOutClick:()->Unit,
    isLoading:Boolean,
    error:String?,
    medicines:List<AssociatedDrug>,
    onMedicineClick:(AssociatedDrug)->Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("welcome") },
            )
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                ) {
                    Text(
                        text = "Today : ${todayDate} welcome :${userName}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    LazyColumn(modifier = Modifier.fillMaxSize().weight(1f)) {
                        items(
                            count =medicines.size,
                            key = { it }
                        ) {
                            MedicineItem(
                                associatedDrug = medicines[it],
                                onItemClick = {
                                    onMedicineClick(medicines[it])
                                }
                            )
                        }

                    }
                }
                if (medicines.isEmpty()) {
                    Center {
                        Text(
                            text = "No Items yet",
                            fontSize = 25.sp
                        )
                    }

                }else if (error!=null){
                    Center {
                        Text(
                            text = error,
                            fontSize = 25.sp
                        )
                    }
                }
                if (isLoading){
                    LoadingLayer()
                }
            }
        }
    )

}