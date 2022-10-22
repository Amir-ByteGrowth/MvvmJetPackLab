package com.example.mvvmjetpackcompose.ui.screens.locationsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun LocationsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { LocationScreenAppBar() },
        modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        content = { LocationScreenContent() }
    )
}

@Composable
fun LocationScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(30.dp))
        Card(
            modifier = modifier
                .height(55.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(bottom = 3.dp, start = 10.dp, end = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
                Spacer(modifier = modifier.width(10.dp))
                TextField(
                    value = "Search area",
                    onValueChange = { "" },
                    modifier = modifier.fillMaxSize(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )
                )
            }
        }

        Spacer(modifier = modifier.height(15.dp))
        CustomTabs()


    }
}


@Composable
fun CustomTabs(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Maps View", "List View")

    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = Color(0xff1E76DA),
        modifier = Modifier
            .height(40.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(0))
            .padding(1.dp)
            .border(width = 1.dp, color = Color.Black),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index

            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(0))
                    .background(
                        Color(
                            0xff1E76DA
                        )
                    )
                else Modifier
                    .clip(RoundedCornerShape(0))
                    .background(
                        Color.White
                    ),
                selected = selected,
                onClick = { selectedIndex = index },
                text = { Text(text = text, color = if (selected) Color.White else Color.Black) }
            )
        }
    }


    if (selectedIndex == 0) {
        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                position = singapore,
                title = "Singapore",
                snippet = "Marker in Singapore"
            )
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(top = 10.dp)
        ) {
            items(20) {
                LocationListItem()
            }
        }
    }
}


@Composable
fun LocationListItem(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(0),
        modifier = modifier
            .padding(1.dp)
            .clickable { },
        elevation = 4.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Al Masa Building 1st floor near kadri mosques AlSatwa",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,

                        ),
                    modifier = modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Icon(imageVector = Icons.Default.LocationOn, contentDescription = "locations")

            }

            Divider(
                modifier = modifier
                    .padding(top = 10.dp, bottom = 20.dp)
                    .background(color = Color.Black)
            )
            Row {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone")
                Column(modifier = modifier.padding(horizontal = 10.dp)) {
                    Text(text = "0306-7274669")
                    Divider(modifier = modifier.padding(vertical = 10.dp))
                }
            }

            Row {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Phone")
                Column(modifier = modifier.padding(horizontal = 10.dp)) {
                    Text(text = "ranaamir347@gmail.com")
                    Divider(modifier = modifier.padding(vertical = 10.dp))
                }
            }

            Row {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Phone")
                Column(modifier = modifier.padding(horizontal = 10.dp)) {
                    Text(text = "Office no 1908, floor 19 opal tower , near centeral lake tower business bay")
                    Divider(modifier = modifier.padding(vertical = 10.dp))
                }
            }
        }
    }
}


@Composable
fun LocationScreenAppBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()

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

@Preview(showBackground = true)
@Composable
fun PreviewLocationsScreen() {
    LocationListItem()
}