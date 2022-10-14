package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen.testdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.R

@Composable
fun TestDetailScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TestsDetailAppBar() },
        modifier = modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp),
        content = {
            Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 8.dp)) {


            }
        })
}


@Composable
fun TestsDetailAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxHeight()) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = modifier.clickable {})
            Spacer(modifier = modifier.width(15.dp))
            Text(
                text = "Test Detail", style = TextStyle.Default.copy(
                    color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
                )
            )
        }

        Box(
            modifier = modifier
                .align(Alignment.TopEnd)
                .fillMaxHeight()
                .clickable(interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true), // You can also change the color and radius of the ripple
                    onClick = {})
        ) {
            Icon(
                painter = painterResource(id = R.drawable.iconscart),
                contentDescription = "icons",
                tint = Color.Blue,
                modifier = modifier.align(
                    Alignment.BottomStart
                )
            )

            Box(
                modifier
                    .size(25.dp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(100))
                    .background(Color.Blue), contentAlignment = Alignment.Center
            ) {
                Text(text = "9", color = Color.White, fontSize = 13.sp)
            }
        }
    }
}

