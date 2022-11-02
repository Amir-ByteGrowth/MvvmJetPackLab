package com.example.mvvmjetpackcompose.navigation

interface AccountScreenClicks : BackClick {
    fun navigateToManageScreen()
}

interface HomeScreenClicks : BackClick, AddCartClick {


    fun navigateToReportScreen()
    fun navigateToTravellerRequest()
    fun navigationToLocationScreen()
    fun navigateToHomeSampleScreen()

    fun navigateToTestsListScreen(typeId: Int)
    fun navigateToOurServicesScreens(typeId: Int)


}

interface AllTestScreenClicks : BackClick {
    fun navigateToTestDetailScreen()
    fun navigateToMyCartScreen()
}

interface BackClick {
    fun navigateBack()
}

interface AddCartClick {
    fun navigateToCartScreen()

}

interface HomeSampleCollectionClicks : BackClick {}
interface ServicesScreenClicks : BackClick {}
interface MyCartScreenClicks : BackClick {}

interface TestDetailScreenClicks : BackClick,AddCartClick {
    fun addToCart()
}