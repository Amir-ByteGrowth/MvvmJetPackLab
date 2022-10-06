package com.example.mvvmjetpackcompose.ui.screens.usermainscreen

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.splashactivity.ui.theme.MvvmJetPackComposeTheme
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components.*

@Composable
fun CreateMainScreen() {

    MvvmJetPackComposeTheme {
        HomeScreen()
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.chugtailab_new),
            contentDescription = "topIcon",
            modifier.size(width = 146.dp, height = 55.dp)
        )

        Box(modifier = modifier
            .align(Alignment.TopEnd)
            .fillMaxHeight()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true), // You can also change the color and radius of the ripple
                onClick = {}
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.iconscart),
                contentDescription = "icons", tint = Color.Blue, modifier = modifier.align(
                    Alignment.BottomStart
                )
            )

            Box(
                modifier
                    .size(25.dp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(100))
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "9", color = Color.White, fontSize = 13.sp)
            }
        }
    }

}

@Composable
fun HomeScreen(userMainViewModel: UserMainViewModel = hiltViewModel()) {
    Scaffold(
        topBar = { AppBar() },
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 45.dp)
    ) {
        val modifier = Modifier
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxSize()
        ) {
            item { ImageSlider() }
//                SpacerCompose(modifier)
            item { TitleString("Search Tests") }
            item { Spacer(modifier = modifier.height(10.dp)) }
            item { TestsList(userMainViewModel.testsList) }
            item { Spacer(modifier = modifier.height(13.dp)) }
            item { TitleString("Chughtai Care") }
            item { Spacer(modifier = modifier.height(1.dp)) }
            item { ChugtaiServicesList(userMainViewModel.chughtaiServicesList) }

            item { Spacer(modifier = modifier.height(13.dp)) }
            item { TitleString("Our Services") }
            item { Spacer(modifier = modifier.height(10.dp)) }
            item { TestsList(userMainViewModel.chughtaiServicesList) }
            item { Spacer(modifier = modifier.height(10.dp)) }


        }
    }
}