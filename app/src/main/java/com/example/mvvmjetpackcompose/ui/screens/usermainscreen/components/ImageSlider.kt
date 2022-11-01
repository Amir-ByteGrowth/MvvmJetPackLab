package com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

var imgList = listOf(R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(modifier: Modifier = Modifier) {

    val slideImage = remember { mutableStateOf(R.drawable.slide1) }
    val state = rememberPagerState()



    HorizontalPager(count = 4, state = state) { page ->

        slideImage.value = imgList[page]
        Box(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(horizontal = 10.dp)
            ) {


                Image(
                    painterResource(slideImage.value),
                    contentDescription = ""
                )
            }
            DotsIndicator(
                totalDots = 4,
                selectedIndex = page,
                selectedColor = Color.Gray,
                unSelectedColor = Color.White, dotSize = 14.dp
            )
        }
    }

    LaunchedEffect(key1 = state.currentPage) {
        delay(3000)
        var newPosition = state.currentPage + 1
        if (newPosition >= 4) newPosition = 0
        // scrolling to the new position.
        state.animateScrollToPage(newPosition)
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