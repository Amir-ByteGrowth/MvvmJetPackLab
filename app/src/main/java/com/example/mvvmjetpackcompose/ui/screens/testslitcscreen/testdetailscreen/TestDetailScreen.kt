package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen.testdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.SharedViewModel
import com.example.mvvmjetpackcompose.data.models.TestListModel
import com.example.mvvmjetpackcompose.navigation.TestDetailScreenClicks


var icludedTestList = listOf(
    "Hb",
    "WBC Count(TLC)",
    "DLC",
    "Total RBC",
    "Platelet Count",
    "HCT",
    "MCV",
    "MCHC",
    "RDW CV%",
    "MPV fi", "Total RBC",
    "Platelet Count",
)

@Composable
fun TestDetailScreen(
    modifier: Modifier = Modifier,
    testDetailScreenClicks: TestDetailScreenClicks, sharedViewModel: SharedViewModel
) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.background),
        topBar = {
            TestsDetailAppBar(
                testDetailScreenClicks = testDetailScreenClicks,
                sharedViewModel = sharedViewModel
            )
        },
        modifier = modifier
            .background(color = colorResource(id = R.color.background))
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp),
        content = {
            Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 0.dp)) {
                TestDetailItem(
                    testListModel = TestListModel(
                        "Blood C/E (Complete, CBC)",
                        "",
                        "Complete blood examination",
                        "Recommended for: Male,Female",
                        "650 PKR"
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                ConstraintLayout(
                    modifier = modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 10.dp)
                ) {
// Create references for the composables to constrain
                    val (lazyCol, button) = createRefs()
                    var indexClicked by remember {
                        mutableStateOf(-1)
                    }
                    LazyColumn(modifier = modifier
                        .scrollable(
                            state = rememberScrollState(),
                            orientation = Orientation.Vertical
                        )
                        .constrainAs(lazyCol) {
                            bottom.linkTo(button.top, margin = 16.dp)
                            top.linkTo(parent.top, margin = 15.dp)
                            height = Dimension.fillToConstraints
                        }


                    ) {

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



                        itemsIndexed(icludedTestList) { index, item ->
                            TestNameItem(
                                testName = item,
                                isSelected = index == indexClicked,
                                onItemClick = { indexClicked = index })
                        }


                    }
                    Button(
                        shape = RoundedCornerShape(0),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        onClick = { testDetailScreenClicks.addToCart() },
                        modifier = modifier
                            .fillMaxWidth()

                            .padding(horizontal = 0.dp)
                            .padding(bottom = 20.dp)
                            .height(48.dp)
                            .constrainAs(button) {
                                bottom.linkTo(parent.bottom, margin = 10.dp)
                            }) {
                        Text(
                            text = "ADD TO CART",
                            style = TextStyle.Default.copy(color = Color.White)
                        )
                    }

                }

            }
        })
}


@Composable
fun TestsDetailAppBar(
    modifier: Modifier = Modifier,
    testDetailScreenClicks: TestDetailScreenClicks,
    sharedViewModel: SharedViewModel
) {

    val itemsInCart by sharedViewModel.itemsInCart.observeAsState()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxHeight()) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = modifier.clickable { testDetailScreenClicks.navigateBack() })
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
                Text(text = itemsInCart.toString(), color = Color.White, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun TestDetailItem(modifier: Modifier = Modifier, testListModel: TestListModel) {
    Card(
        elevation = 1.dp,
        modifier = modifier.padding(top = 1.dp, bottom = 2.dp, start = 2.dp, end = 2.dp),
        shape = RoundedCornerShape(0)
    ) {
        Column(
            modifier = modifier.padding(
                start = 15.dp,
                end = 15.dp,
                top = 15.dp,
                bottom = 10.dp
            )
        ) {
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
            Spacer(modifier = modifier.height(4.dp))

            OutlinedButton(onClick = { /*TODO*/ }, modifier = modifier.height(33.dp)) {
                Text(text = testListModel.recommendedFor, style = TextStyle(fontSize = 12.sp))
            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {

                Button(
                    onClick = { },
                    modifier = modifier
                        .align(Alignment.CenterEnd)
                        .background(color = Color.Blue)
                        .height(33.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(
                        text = testListModel.price,
                        style = TextStyle(fontSize = 12.sp, color = Color.White)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreTestDetailScreen() {
    TestDetailScreen(testDetailScreenClicks = object : TestDetailScreenClicks {
        override fun addToCart() {
            TODO("Not yet implemented")
        }

        override fun navigateBack() {
            TODO("Not yet implemented")
        }

        override fun navigateToCartScreen() {
            TODO("Not yet implemented")
        }
    }, sharedViewModel = hiltViewModel())
}

@Composable
fun TestNameItem(
    testName: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(modifier = modifier.clickable(onClick = { onItemClick() })) {
        Text(

            text = testName,
            style = TextStyle.Default.copy(color = if (isSelected) Color.White else Color.DarkGray),
            modifier = modifier
                .background(if (isSelected) colorResource(id = R.color.yellow_brown_test_name_back) else Color.White)
                .fillMaxWidth()
                .height(43.dp)
                .padding(vertical = 10.dp, horizontal = 15.dp),

            )
        Divider()

    }
}
