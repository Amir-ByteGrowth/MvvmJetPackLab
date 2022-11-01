package com.example.mvvmjetpackcompose.ui.screens.homesamplingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.mvvmjetpackcompose.navigation.HomeSampleCollectionClicks

@Composable
fun HomeSampleScreen(homeSampleCollectionClicks: HomeSampleCollectionClicks) {
    Scaffold(
        topBar = { HomeSampleScreenAppBar(homeSampleCollectionClicks = homeSampleCollectionClicks) },
        content = { HomeSampleContent() })

}

@Composable
fun HomeSampleContent(modifier: Modifier = Modifier) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp)

                .height(150.dp)
        ) {
            Text(
                text = "Choose an option to upload prescription",
                style = TextStyle.Default.copy(color = Color.Gray)
            )

            Row(modifier = modifier.padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.cameraround),
                    contentDescription = "",
                    modifier = modifier
                        .clickable() {}
                        .clip(RoundedCornerShape(80))

                        .size(50.dp)
                        .clickable {

                        }
                )
                Spacer(modifier = modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.cameraround),
                    contentDescription = "",
                    modifier = modifier
                        .size(50.dp)
                        .clickable {

                        }
                )
            }
            Spacer(modifier = modifier.height(20.dp))

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                text = "Enter Details",
                style = TextStyle.Default.copy(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }



        LazyColumn(
            modifier = modifier
                .padding(top = 160.dp, bottom = 70.dp)
                .fillMaxSize()
                .background(color = Color.Transparent),
            state = rememberLazyListState()
        ) {

            item {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
//                        Spacer(modifier = modifier.height(150.dp).background(Color.Transparent))
                        Text(text = "Select patient name")

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                value = "Patient name",
                                onValueChange = {},
                                label = { "Patient name" },
                                modifier = modifier
                                    .weight(1f),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                )
                            )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Mobile number")

                        TextField(
                            value = "Mobile number",
                            onValueChange = {},
                            label = { "Mobile number" },
                            modifier = modifier
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            )
                        )

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Address")

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                value = "Address here",
                                onValueChange = {},
                                label = { "Address here" },
                                modifier = modifier
                                    .weight(1f),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                )
                            )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }


                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Pick existing address")

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                textStyle = TextStyle.Default.copy(textAlign = TextAlign.Start),
                                value = "Existing address",
                                onValueChange = {},
                                label = { "Existing address" },
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(0.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                ),

                                )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }


                    }
                }
            }
            item {
                Column(modifier = modifier.height(300.dp)) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "include tests",
                            style = TextStyle.Default.copy(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )

                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            modifier = modifier
                                .clip(
                                    RoundedCornerShape(0),
                                )
                                .clickable { })
                    }
                }

            }
        }

        Box(
            modifier = modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .align(Alignment.BottomCenter),
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .align(
                        Alignment.BottomEnd
                    ),
            ) {
                Text(text = "SUBMIT")
            }
        }
    }
}


@Composable
fun HomeSampleScreenAppBar(
    modifier: Modifier = Modifier,
    homeSampleCollectionClicks: HomeSampleCollectionClicks
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = modifier.clickable { homeSampleCollectionClicks.navigateBack() })
        Spacer(modifier = modifier.width(15.dp))
        Text(
            text = "Home Sample collection", style = TextStyle.Default.copy(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )

    }
}

@Composable
fun TravellerScreenContent(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 50.dp)
    ) {
        val (main, button) = createRefs()

        LazyColumn(modifier = modifier
            .padding(horizontal = 10.dp)
            .constrainAs(main) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(button.top, margin = 10.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }) {
            item {
                Text(
                    modifier = modifier.padding(start = 10.dp),
                    text = "Enter Details",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            item {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 5.dp)
                ) {
                    Column(modifier = modifier.padding(top = 10.dp)) {
                        Text(text = "Select traveller", modifier = modifier.padding(start = 10.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom,
                            modifier = modifier.padding(end = 5.dp)
                        ) {
                            TextField(
                                value = "Traveller name",
                                onValueChange = {},
                                label = { "Traveller name" },
                                modifier = modifier
                                    .weight(1f),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                )
                            )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Passport number", modifier = modifier.padding(start = 10.dp))

                        TextField(
                            value = "Enter passport number",
                            onValueChange = {},
                            label = { "Passport number" },
                            modifier = modifier
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            )
                        )

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Booking Ref/PNR", modifier = modifier.padding(start = 10.dp))

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                value = "Enter reference here",
                                onValueChange = {},
                                label = { "Enter reference here" },
                                modifier = modifier
                                    .weight(1f),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                )
                            )


                        }


                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Flight number", modifier = modifier.padding(start = 10.dp))

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                textStyle = TextStyle.Default.copy(textAlign = TextAlign.Start),
                                value = "Enter flight number",
                                onValueChange = {},
                                label = { "Enter flight number" },
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(0.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                ),

                                )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Flight Date", modifier = modifier.padding(start = 10.dp))

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                textStyle = TextStyle.Default.copy(textAlign = TextAlign.Start),
                                value = "Enter flight date",
                                onValueChange = {},
                                label = { "Enter flight date" },
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(0.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                ),

                                )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }

                        Spacer(modifier = modifier.height(15.dp))

                        Text(text = "Country", modifier = modifier.padding(start = 10.dp))

                        Row(verticalAlignment = Alignment.Bottom) {
                            TextField(
                                textStyle = TextStyle.Default.copy(textAlign = TextAlign.Start),
                                value = "Enter Country name",
                                onValueChange = {},
                                label = { "Enter Country name" },
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(0.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                ),

                                )

                            Box(
                                modifier = modifier
                                    .size(50.dp)
                                    .clickable(onClick = {
                                    }),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.adduser),
                                    contentDescription = "add User",
                                    modifier = modifier
                                )
                            }

                        }
                    }
                }
            }

        }


        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, margin = 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
                height = Dimension.value(45.dp)
            }, shape = RoundedCornerShape(0)
        ) {
            Text(text = "SUBMIT")
        }


    }
}

@Preview
@Composable
fun PReviewHomeSampleScreen() {
    HomeSampleScreen(homeSampleCollectionClicks = object : HomeSampleCollectionClicks {
        override fun navigateBack() {
            TODO("Not yet implemented")
        }
    })
}