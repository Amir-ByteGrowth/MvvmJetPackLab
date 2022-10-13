package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.R

@Composable
fun TestsListScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TestsListAppBar() },
        modifier = modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp),
        content = {
            Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 8.dp)) {
                TestListsScreenSearchBar()
                TestListItem()
            }
        })
}

@Composable
fun TestListsScreenSearchBar(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(55.dp), elevation = 5.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Spacer(modifier = modifier.width(15.dp))
            TextField(
                singleLine = true,
                value = "Search",
                onValueChange = { "Search.." },
                modifier = modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                textStyle = TextStyle.Default.copy(fontSize = 13.sp)
            )
        }
    }
}


@Composable
fun TestsListAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxHeight()) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = modifier.clickable {})
            Spacer(modifier = modifier.width(15.dp))
            Text(
                text = "All Tests",
                style = TextStyle.Default.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }

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
fun TestListItem(modifier: Modifier = Modifier) {
    Card(elevation = 5.dp) {
        Column(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Text(
                text = "Blood C/F (Complete, CBC)",
                style = TextStyle.Default.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

            )
            Divider()
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = "Includes 11 Tests",
                style = TextStyle.Default.copy(
                    color = Color.Gray.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            )

            Text(
                text = "Computer blood examination",
                style = TextStyle.Default.copy(
                    color = Color.Gray.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            )

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Recommended for both: Male,Female")
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp), contentAlignment = Alignment.CenterStart
            ) {
                Text(

                    text = "750 PKR",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold, fontSize = 12.sp
                    )
                )
                Row(modifier = modifier.align(Alignment.CenterEnd)) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "DETAIL")
                    }
                    Spacer(modifier = modifier.width(7.dp))
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier.width(50.dp),

                        ) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTestListItem() {
    TestListItem()
}