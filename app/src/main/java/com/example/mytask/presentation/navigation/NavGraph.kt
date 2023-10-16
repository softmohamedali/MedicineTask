package com.example.mytask.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mytask.domain.models.other.AssociatedDrug
import com.example.mytask.domain.models.other.toAssociatedDrug
import com.example.mytask.presentation.details.DetailsScreen
import com.example.mytask.presentation.login_screen.LoginScreen
import com.example.mytask.presentation.main_screen.MainScreen


@ExperimentalAnimationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screens.Main.route)
    {

        composable(route = Screens.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screens.Details.route,
            arguments = arrayListOf(
                navArgument("med") {
                    type = NavType.StringType
                }
            )
        ) {
            val associatedDrug = it.arguments!!.getString("med")?.toAssociatedDrug()

            DetailsScreen(associatedDrug =associatedDrug?: AssociatedDrug() )
        }

    }
}