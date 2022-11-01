package com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.TestModel
import com.example.mvvmjetpackcompose.navigation.HomeScreenClicks


@Composable
fun TestsList(testNameList: List<TestModel>, homeScreenClicks: HomeScreenClicks, type: String) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        itemsIndexed(testNameList) { index, item ->
            ItemCard(testModel = item, onItemClick = {

                if (type == "Tests") {
                    homeScreenClicks.navigateToTestsListScreen(index)
                } else if (type == "Services") {
                    homeScreenClicks.navigateToOurServicesScreens(index)
                }

//                if (it.name == "All") {
//                    homeScreenClicks.navigateToAllTestScreen()
//                } else if (it.name == "Home Sampling") {
//                    homeScreenClicks.navigateToMedicinesScreen()
//                }
            })

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(testModel: TestModel, modifier: Modifier = Modifier, onItemClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(5.dp),

        modifier = modifier
            .size(100.dp),
        onClick = onItemClick
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(testModel.icon),
                    contentDescription = "desc",
                    modifier = modifier.size(70.dp)
                )
                Text(
                    text = testModel.name,
                    style = TextStyle.Default.copy(color = Color.Gray, fontSize = 12.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCardPreview() {
    ItemCard(TestModel(R.drawable.iconkidney, "Kidney"), onItemClick = {})
}