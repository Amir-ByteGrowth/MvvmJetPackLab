package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen.testdetailscreen

import android.content.ClipData.Item
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.TestListModel
import com.example.mvvmjetpackcompose.navigation.AllTestScreenClicks

@Composable
fun TestDetailScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TestsDetailAppBar() },
        modifier = modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp),
        content = {
            Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 8.dp)) {
                TestDetailItem(
                    testListModel = TestListModel(
                        "Blood C/E (Complete, CBC",
                        "",
                        "Complete blood examination",
                        "Recommended for: Male,Female",
                        "650 PKR"
                    )
                )
                ConstraintLayout(
                    modifier = modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
// Create references for the composables to constrain
                    val (lazyCol, button) = createRefs()

                    LazyColumn(modifier = modifier
                        .constrainAs(lazyCol) {
                            bottom.linkTo(button.top, margin = 16.dp)
                            top.linkTo(parent.top, margin = 15.dp)
                            height = Dimension.fillToConstraints
                        }) {

                        item {
                            Column {
                                Text(
                                    text = "Include 11 tests",
                                    style = TextStyle.Default.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                )
                                Spacer(modifier = modifier.height(5.dp))

                                Divider(
                                    color = Color.DarkGray,
                                    modifier = modifier.shadow(elevation = 1.dp)
                                )
                                Spacer(modifier = modifier.height(10.dp))
                            }

                        }

                        items(10) {
                            TestNameItem(testName = "Test# $it")
                        }


                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxWidth()

                            .padding(horizontal = 20.dp)
                            .padding(bottom = 30.dp)
                            .height(48.dp)
                            .constrainAs(button) {
                                bottom.linkTo(parent.bottom, margin = 10.dp)
                            }) {
                        Text(text = "ADD TO CART")
                    }

                }

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

@Composable
fun TestDetailItem(modifier: Modifier = Modifier, testListModel: TestListModel) {
    Card(elevation = 5.dp, modifier = modifier.padding(top = 10.dp, bottom = 2.dp)) {
        Column(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Text(
                text = testListModel.testName, style = TextStyle.Default.copy(
                    color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 15.sp
                )

            )
            Divider()
            Spacer(modifier = modifier.height(5.dp))

            Text(
                text = testListModel.testType, style = TextStyle.Default.copy(
                    color = Color.Gray.copy(alpha = 0.5f), fontSize = 12.sp
                )
            )

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(
                    text = testListModel.recommendedFor,
                    style = TextStyle.Default.copy(color = Color.Black)
                )
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {

                Button(
                    onClick = { },
                    modifier = modifier.align(Alignment.CenterEnd),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = testListModel.price)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreTestDetailScreen() {
    TestDetailScreen()
}

@Composable
fun TestNameItem(testName: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = testName,
            style = TextStyle.Default.copy(color = Color.DarkGray),
            modifier = modifier
                .height(40.dp)
                .padding(vertical = 10.dp),

            )
        Divider()

    }
}
