package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks {
    fun navigateToManageScreen()
}

interface HomeScreenClicks {
    fun navigateToAllTestScreen()
    fun navigateToMedicinesScreen()

    fun navigateToReportScreen()
    fun navigateToTravellerRequest()

}

interface AllTestScreenClicks {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}