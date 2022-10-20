package com.example.mvvmjetpackcompose.ui.screens.servicesscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.mvvmjetpackcompose.R

@Composable
fun ServicesScreens(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { ServicesAppBar(appBarTitle = "Medicines") },
        content = { ServicesContent() }
    )
}


@Composable
fun ServicesContent(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
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
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
            text = "Enter Details",
            style = TextStyle.Default.copy(
                color = Color.Black,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            )
        )

        Card(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
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

                Box(
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(top = 10.dp)
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
    }
}

@Composable
fun ServicesAppBar(modifier: Modifier = Modifier, appBarTitle: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = modifier.clickable {})
        Spacer(modifier = modifier.width(15.dp))
        Text(
            text = "Home Sampling", style = TextStyle.Default.copy(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )

        )
    }
}

@Preview
@Composable
fun PreviewServicesScreens() {
    ServicesScreens()
}
