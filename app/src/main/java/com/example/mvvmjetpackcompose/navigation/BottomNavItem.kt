package com.example.mvvmjetpackcompose.navigation

import com.example.mvvmjetpackcompose.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.cllogo, "Home")
    object Chat : BottomNavItem("My Network", R.drawable.chat, "Chat")
    object Account : BottomNavItem("Post", R.drawable.settingstab, "Account")
}