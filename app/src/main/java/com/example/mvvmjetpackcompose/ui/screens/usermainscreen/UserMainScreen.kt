package com.example.mvvmjetpackcompose.ui.screens.usermainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.splashactivity.ui.theme.MvvmJetPackComposeTheme

@Composable
fun CreateMainScreen() {
    MvvmJetPackComposeTheme {
        Scaffold(
            topBar = { AppBar() },
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Column {
                ImageSlider()
            }
        }
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
                indication = rememberRipple(bounded = false), // You can also change the color and radius of the ripple
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