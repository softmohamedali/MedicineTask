package com.example.mytask.presentation.navigation

sealed class Screens(
     var route:String
) {
    object Login: Screens("login")
    object Main: Screens("main")
    object Details:Screens("Details/{med}"){
        fun passAndNavToDetails(med:String):String{
            return "Details/${med}"
        }
    }
}