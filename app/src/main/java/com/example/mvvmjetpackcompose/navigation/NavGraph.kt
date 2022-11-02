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
fun NavigationGraph(navController: NavHostController, sharedViewModel: SharedViewModel) {

    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {


        Log.d("MyName", sharedViewModel.itemsInCart.value.toString())

        composable(BottomNavItem.Home.screen_route) {

            CreateMainScreen(
                homeScreenClicks = object : HomeScreenClicks {


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

                    override fun navigateToTestsListScreen(typeId: Int) {
                        Log.d("Index", typeId.toString())
                        navController.navigate(Screens.AllTests.route)
                    }

                    override fun navigateToOurServicesScreens(typeId: Int) {
                        navController.navigate(Screens.ServicesScreens.route)
                        if (typeId == 0) {
                        } else if (typeId == 1) {
                        } else if (typeId == 1) {
                        } else if (typeId == 1) {
                        }
                    }

                    override fun navigateBack() {
                        navController.popBackStack()
                    }

                    override fun navigateToCartScreen() {
                        navController.navigate(Screens.MyCartScreen.route)
                    }


                }, sharedViewModel = sharedViewModel
            ) { sharedViewModel.addCart() }
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
            }, sharedViewModel = sharedViewModel)
        }

        composable(Screens.TestDetailScreen.route) {
            TestDetailScreen(testDetailScreenClicks = object :TestDetailScreenClicks{
                override fun addToCart() {
                    sharedViewModel.addCart()
                    navController.popBackStack()
                }

                override fun navigateBack() {
                    navController.popBackStack()
                }

                override fun navigateToCartScreen() {
                    navController.navigate(Screens.MyCartScreen.route)
                }

            },sharedViewModel = sharedViewModel)
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

