package com.example.mvvmjetpackcompose.navigation

import com.example.mvvmjetpackcompose.constants.Constants.Companion.SPLASH_SCREEN

sealed class Screens(val route:String){
    object SplashScreen : Screens(SPLASH_SCREEN)
}