package com.example.mvvmjetpackcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvvmjetpackcompose.ui.screens.accountscreen.AccountScreen
import com.example.mvvmjetpackcompose.ui.screens.chatscreen.ChatScreen
import com.example.mvvmjetpackcompose.ui.screens.homescreen.HomeScreen
import com.example.mvvmjetpackcompose.ui.screens.splashscreen.CreateSplashScreen
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.CreateMainScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.SplashScreen.route) {
            CreateSplashScreen() {

            }
        }

    }


}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            CreateMainScreen()
        }
        composable(BottomNavItem.Chat.screen_route) {
            ChatScreen()
        }
        composable(BottomNavItem.Account.screen_route) {
            AccountScreen()
        }

    }
}