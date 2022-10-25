package com.example.mvvmjetpackcompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvvmjetpackcompose.SharedViewModel
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

        var sharedViewModel: SharedViewModel = SharedViewModel()
        Log.d("MyName", sharedViewModel.otpVerifyingDataSharing.toString())

        composable(BottomNavItem.Home.screen_route) {

            CreateMainScreen(
                homeScreenClicks = object : HomeScreenClicks {
                    override fun navigateToAllTestScreen() {
                        sharedViewModel.otpVerifyingDataSharing = 1
                        navController.navigate(Screens.AllTests.route)

                    }

                    override fun navigateToMedicinesScreen() {
                        sharedViewModel.otpVerifyingDataSharing = 2
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

                    override fun navigateBack() {
                        navController.popBackStack()
                    }

                    override fun navigateToCartScreen() {
                        navController.navigate(Screens.MyCartScreen.route)
                    }


                }, sharedViewModel = sharedViewModel
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

                    override fun navigateBack() {
                        navController.popBackStack()
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

                override fun navigateBack() {
                    navController.popBackStack()
                }
            })
        }

        composable(Screens.TestDetailScreen.route) {
            TestDetailScreen()
        }

        composable(Screens.MyCartScreen.route) {
            MyCartScreen(myCartScreenClicks = object : MyCartScreenClicks {
                override fun navigateBack() {
                    navController.popBackStack()
                }
            })
        }

        composable(Screens.ServicesScreens.route) {
            ServicesScreens(servicesScreenClicks = object : ServicesScreenClicks {
                override fun navigateBack() {
                    navController.popBackStack()
                }

            })
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
            HomeSampleScreen(homeSampleCollectionClicks = object : HomeSampleCollectionClicks {
                override fun navigateBack() {
                    navController.popBackStack()
                }

            })
        }

    }
}

