package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks {
    fun navigateToManageScreen()
}

interface HomeScreenClicks {
    fun navigateToAllTestScreen()
    fun navigateToMedicinesScreen()

}

interface AllTestScreenClicks {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}