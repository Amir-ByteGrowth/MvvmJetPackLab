package com.example.mvvmjetpackcompose.navigation

import com.example.mvvmjetpackcompose.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.hometab, "Home")
    object Chat : BottomNavItem("Chat", R.drawable.settingstab, "Chat")
    object Account : BottomNavItem("Account", R.drawable.settingstab, "Account")
}