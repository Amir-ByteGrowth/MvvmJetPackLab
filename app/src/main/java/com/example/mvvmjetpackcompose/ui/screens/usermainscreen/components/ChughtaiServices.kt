package com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmjetpackcompose.data.models.TestModel
import com.example.mvvmjetpackcompose.navigation.HomeScreenClicks

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChugtaiServicesList(testNameList: List<TestModel>, homeScreenClicks: HomeScreenClicks) {
    LazyVerticalGrid(

        cells = GridCells.Adaptive(100.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp),
        modifier = Modifier.height(230.dp)
    ) {
        items(testNameList) {
            ItemCard(testModel = it, onItemClick = {
                if (it.name == "View Report") {
                    homeScreenClicks.navigateToReportScreen()
                }else if (it.name == "Travel Request"){
                    homeScreenClicks.navigateToTravellerRequest()
                }else if (it.name == "Locations"){
                    homeScreenClicks.navigationToLocationScreen()
                }else if (it.name == "Home Sampling"){
                    homeScreenClicks.navigateToHomeSampleScreen()
                }

            })
        }
    }
}



