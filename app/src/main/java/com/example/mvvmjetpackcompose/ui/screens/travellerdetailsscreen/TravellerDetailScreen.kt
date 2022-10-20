package com.example.mvvmjetpackcompose.ui.screens.travellerdetailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun TravellerDetailScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = { TravellerScreenAppBar() }, content = { TravellerScreenContent() })

//    GenericScreenComp(appBar = { TravellerScreenAppBar() }, content = { TravellerScreenContent() })
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

                        Row(verticalAlignment = Alignment.Bottom, modifier = modifier.padding(end = 5.dp)) {
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


@Composable
fun TravellerScreenAppBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = modifier.clickable {})
        Spacer(modifier = modifier.width(15.dp))
        Text(
            text = "Traveller Details", style = TextStyle.Default.copy(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
    }
}

@Preview
@Composable
fun PreviewTravellerDetailScreen() {
    TravellerDetailScreen()
}