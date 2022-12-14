package com.example.mvvmjetpackcompose.navigation

import com.example.mvvmjetpackcompose.constants.Constants.Companion.ALL_TESTS
import com.example.mvvmjetpackcompose.constants.Constants.Companion.HOME_SAMPLE_SCREEN
import com.example.mvvmjetpackcompose.constants.Constants.Companion.LOCATIONS_SCREEN
import com.example.mvvmjetpackcompose.constants.Constants.Companion.MANAGE_RELATIONS
import com.example.mvvmjetpackcompose.constants.Constants.Companion.MY_CART
import com.example.mvvmjetpackcompose.constants.Constants.Companion.REPORT_SCREEN
import com.example.mvvmjetpackcompose.constants.Constants.Companion.SERVICES_SCREENS
import com.example.mvvmjetpackcompose.constants.Constants.Companion.SPLASH_SCREEN
import com.example.mvvmjetpackcompose.constants.Constants.Companion.TEST_DETAIL
import com.example.mvvmjetpackcompose.constants.Constants.Companion.TRAVELLER_REQUEST_SCREEN

sealed class Screens(val route: String) {
    object SplashScreen : Screens(SPLASH_SCREEN)
    object ManageScreens : Screens(MANAGE_RELATIONS)
    object AllTests : Screens(ALL_TESTS)
    object TestDetailScreen : Screens(TEST_DETAIL)
    object MyCartScreen : Screens(MY_CART)
    object ServicesScreens : Screens(SERVICES_SCREENS)

    object ReportsScreen : Screens(REPORT_SCREEN)
    object TravellerRequestScreen : Screens(TRAVELLER_REQUEST_SCREEN)
    object LocationsScreen : Screens(LOCATIONS_SCREEN)
    object HomeSampleScreen : Screens(HOME_SAMPLE_SCREEN)
}

