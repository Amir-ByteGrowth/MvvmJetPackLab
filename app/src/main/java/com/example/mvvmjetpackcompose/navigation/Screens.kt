package com.example.mvvmjetpackcompose.navigation

import com.example.mvvmjetpackcompose.constants.Constants.Companion.ALL_TESTS
import com.example.mvvmjetpackcompose.constants.Constants.Companion.MANAGE_RELATIONS
import com.example.mvvmjetpackcompose.constants.Constants.Companion.SPLASH_SCREEN
import com.example.mvvmjetpackcompose.constants.Constants.Companion.TEST_DETAIL

sealed class Screens(val route: String) {
    object SplashScreen : Screens(SPLASH_SCREEN)
    object ManageScreens : Screens(MANAGE_RELATIONS)
    object AllTests : Screens(ALL_TESTS)
    object TestDetailScreen : Screens(TEST_DETAIL)
}