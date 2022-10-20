package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks {
    fun navigateToManageScreen()
}

interface HomeScreenClicks {
    fun navigateToAllTestScreen()
    fun navigateToMedicinesScreen()

    fun navigateToReportScreen()

}

interface AllTestScreenClicks {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}