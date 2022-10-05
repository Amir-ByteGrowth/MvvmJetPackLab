package com.example.mvvmjetpackcompose.ui.screens.usermainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mvvmjetpackcompose.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider() {
    val slideImage = remember { mutableStateOf(R.drawable.slide1) }
    val state = rememberPagerState()
    HorizontalPager(count = 3, state = state) { page ->
        when (page) {

            0 -> {
                slideImage.value = R.drawable.slide1
            }

            1 -> {
                slideImage.value = R.drawable.slide2
            }

            2 -> {
                slideImage.value = R.drawable.slide3
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                Image(
                    painterResource(slideImage.value),
                    contentDescription = ""
                )
            }
            DotsIndicator(
                totalDots = 3,
                selectedIndex = state.currentPage,
                selectedColor = Color.Gray,
                unSelectedColor = Color.White, dotSize = 14.dp
            )
        }
    }

}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
    dotSize: Dp
) {

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(vertical = 10.dp)

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(dotSize)
                        .clip(CircleShape)
                        .background(selectedColor)

                        .border(
                            border = BorderStroke(1.dp, color = Color.Black),
                            shape = RoundedCornerShape(100)
                        )
                        .padding(horizontal = 10.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(dotSize)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                        .border(
                            border = BorderStroke(1.dp, color = Color.Gray),
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(horizontal = 10.dp)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}