package com.example.mvvmjetpackcompose.ui.screens.mycartscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mvvmjetpackcompose.navigation.MyCartScreenClicks

@Composable
fun MyCartScreen(modifier: Modifier = Modifier, myCartScreenClicks: MyCartScreenClicks) {
    Scaffold(
        topBar = { MyCartAppBar(myCartScreenClicks = myCartScreenClicks) },
        modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        content = { MyCartContent() }
    )
}

@Composable
fun MyCartAppBar(modifier: Modifier = Modifier, myCartScreenClicks: MyCartScreenClicks) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = modifier.clickable { myCartScreenClicks.navigateBack() })
        Spacer(modifier = modifier.width(15.dp))
        Text(
            text = "My Cart", style = TextStyle.Default.copy(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
    }
}

@Composable
fun MyCartContent(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp)
    ) {
        val (list, totalPrice, proceedToCheckOut) = createRefs()
        LazyColumn(modifier = modifier.constrainAs(list) {
            top.linkTo(parent.top, margin = 10.dp)
            bottom.linkTo(totalPrice.top, margin = 10.dp)
            start.linkTo(parent.start, margin = 10.dp)
            end.linkTo(parent.end, margin = 10.dp)
            height = Dimension.fillToConstraints

        }) {

            items(10) {
                MyCartListItem()
            }

        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 10.dp)
                .constrainAs(totalPrice) {
                    bottom.linkTo(proceedToCheckOut.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                }) {
            Row(
                modifier = modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total Test 2", color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = "440 PKR", color = Color.Black, fontWeight = FontWeight.Bold)
            }

        }

        Button(
            shape = RoundedCornerShape(0),
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .height(45.dp)
                .constrainAs(proceedToCheckOut) {
                    bottom.linkTo(parent.bottom, margin = 15.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    width = Dimension.fillToConstraints
                }) {
            Text(text = "PROCEED TO CHECKOUT")
        }
    }
}

@Composable
fun MyCartListItem(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Patient 1",
            style = TextStyle.Default.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = modifier.height(10.dp))

        Card {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Serum Vitamin B12", style = TextStyle.Default.copy(color = Color.Gray))
                Row {
                    Text(text = "2200 PKR", color = Color.Black)
                    Spacer(modifier = modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Negative",
                        modifier = modifier.clickable { })
                }
            }
        }

        Spacer(modifier = modifier.height(15.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {
    MyCartScreen(myCartScreenClicks = object : MyCartScreenClicks {
        override fun navigateBack() {

        }
    })
}