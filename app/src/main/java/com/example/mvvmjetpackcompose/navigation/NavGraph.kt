package com.example.mvvmjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvvmjetpackcompose.ui.screens.accountscreen.AccountScreen
import com.example.mvvmjetpackcompose.ui.screens.chatscreen.ChatScreen
import com.example.mvvmjetpackcompose.ui.screens.homesamplingscreen.HomeSampleScreen
import com.example.mvvmjetpackcompose.ui.screens.locationsscreen.LocationsScreen
import com.example.mvvmjetpackcompose.ui.screens.managerelationship.ManageRelationShipsScreen
import com.example.mvvmjetpackcompose.ui.screens.mycartscreen.MyCartScreen
import com.example.mvvmjetpackcompose.ui.screens.reportsscreen.ReportsScreen
import com.example.mvvmjetpackcompose.ui.screens.servicesscreens.ServicesScreens
import com.example.mvvmjetpackcompose.ui.screens.testslitcscreen.TestsListScreen
import com.example.mvvmjetpackcompose.ui.screens.testslitcscreen.testdetailscreen.TestDetailScreen
import com.example.mvvmjetpackcompose.ui.screens.travellerdetailsscreen.TravellerDetailScreen
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.CreateMainScreen


@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {

            CreateMainScreen(
                homeScreenClicks = object : HomeScreenClicks {
                    override fun navigateToAllTestScreen() {
                        navController.navigate(Screens.AllTests.route)
                    }

                    override fun navigateToMedicinesScreen() {
                        navController.navigate(Screens.ServicesScreens.route)
                    }

                    override fun navigateToReportScreen() {
                        navController.navigate(Screens.ReportsScreen.route)
                    }

                    override fun navigateToTravellerRequest() {
                        navController.navigate(Screens.TravellerRequestScreen.route)
                    }

                    override fun navigationToLocationScreen() {
                        navController.navigate(Screens.LocationsScreen.route)
                    }

                    override fun navigateToHomeSampleScreen() {
                        navController.navigate(Screens.HomeSampleScreen.route)
                    }


                }
            )
        }
        composable(BottomNavItem.Chat.screen_route) {

            ChatScreen()
        }
        composable(BottomNavItem.Account.screen_route) {

            AccountScreen(
                clicks = object : AccountScreenClicks {
                    override fun navigateToManageScreen() {
                        navController.navigate(Screens.ManageScreens.route)
                    }
                }
            )
        }

        composable(Screens.ManageScreens.route) {
            ManageRelationShipsScreen()
        }

        composable(Screens.AllTests.route) {
            TestsListScreen(allTestScreenClicks = object : AllTestScreenClicks {
                override fun navigateToTestDetailScreen() {
                    navController.navigate(Screens.TestDetailScreen.route)
                }

                override fun navigateToMyCartScreen() {
                    navController.navigate(Screens.MyCartScreen.route)
                }
            })
        }

        composable(Screens.TestDetailScreen.route) {
            TestDetailScreen()
        }

        composable(Screens.MyCartScreen.route) {
            MyCartScreen()
        }

        composable(Screens.ServicesScreens.route) {
            ServicesScreens()
        }

        composable(Screens.ReportsScreen.route) {
            ReportsScreen()
        }


        composable(Screens.TravellerRequestScreen.route) {
            TravellerDetailScreen()
        }

        composable(Screens.LocationsScreen.route) {
            LocationsScreen()
        }

        composable(Screens.HomeSampleScreen.route) {
            HomeSampleScreen()
        }

    }
}