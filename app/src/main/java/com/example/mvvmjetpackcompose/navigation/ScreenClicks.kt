package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks:BackClick {
    fun navigateToManageScreen()
}

interface HomeScreenClicks :BackClick,AddCartClick{
    fun navigateToAllTestScreen()
    fun navigateToMedicinesScreen()

    fun navigateToReportScreen()
    fun navigateToTravellerRequest()
    fun navigationToLocationScreen()
    fun navigateToHomeSampleScreen()

}

interface AllTestScreenClicks:BackClick {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}

interface BackClick{
    fun navigateBack()
}
interface AddCartClick{
    fun navigateToCartScreen()
}

interface HomeSampleCollectionClicks:BackClick{}
interface ServicesScreenClicks:BackClick{}
interface MyCartScreenClicks:BackClick{}