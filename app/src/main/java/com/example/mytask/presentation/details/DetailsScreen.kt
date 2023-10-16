package com.example.mytask.presentation.details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mytask.domain.models.other.AssociatedDrug
import com.example.mytask.presentation.details.componenet.DetailsView
import com.example.mytask.presentation.login_screen.componenet.LoginView


@Composable
fun DetailsScreen(
    associatedDrug: AssociatedDrug
) {



    DetailsView(associatedDrug =associatedDrug )

}