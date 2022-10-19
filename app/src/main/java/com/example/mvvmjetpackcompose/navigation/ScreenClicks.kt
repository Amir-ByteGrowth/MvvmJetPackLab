package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks {
    fun navigateToManageScreen()
}

interface HomeScreenClicks {
    fun navigateToAllTestScreen()

}

interface AllTestScreenClicks {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}