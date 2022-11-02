package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.SharedViewModel
import com.example.mvvmjetpackcompose.data.models.TestListModel
import com.example.mvvmjetpackcompose.navigation.AllTestScreenClicks
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.addtocartbottomsheet.RelationShipEnableDialog

@Composable
fun TestsListScreen(
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    allTestScreenClicks: AllTestScreenClicks
) {



    Scaffold(topBar = {
        TestsListAppBar(
            allTestScreenClicks = allTestScreenClicks,
            sharedViewModel = sharedViewModel
        )
    },
        modifier = modifier
            .background(color = colorResource(R.color.background))
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp),
        content = {
            MainContent(allTestScreenClicks = allTestScreenClicks)
        },
        backgroundColor = colorResource(R.color.background)
    )
}

@Composable
fun MainContent(modifier: Modifier = Modifier, allTestScreenClicks: AllTestScreenClicks) {
    var searchStr by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 8.dp)) {
        TestListsScreenSearchBar(searchString = searchStr, onTextChange = { searchStr = it })
        Spacer(modifier = modifier.height(10.dp))
        AllTestsListContent(allTestScreenClicks = allTestScreenClicks, searchString = searchStr)

    }
}


@Composable
fun AllTestsListContent(
    testListViewModel: TestListViewModel = hiltViewModel(),
    allTestScreenClicks: AllTestScreenClicks, searchString: String
) {
    LazyColumn(modifier = Modifier.padding(bottom = 1.dp)) {
        items(testListViewModel.testListModel) {
            if (it.testName.contains(searchString, true))
                TestListItem(
                    testListModel = it,
                    allTestScreenClicks = allTestScreenClicks
                )
        }
    }
}


@Composable
fun TestListsScreenSearchBar(
    modifier: Modifier = Modifier,
    searchString: String,
    onTextChange: (String) -> Unit
) {
    Card(
        modifier = modifier, elevation = 5.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                modifier = modifier.size(22.dp)
            )
            Spacer(modifier = modifier.width(15.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(bottom = 5.dp)
            ) {
                TextField(
                    singleLine = true,
                    value = searchString,
                    onValueChange = { onTextChange(it) },
                    modifier = modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                    textStyle = TextStyle.Default.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    placeholder = {
                        Text(
                            text = "Search here",
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }
                )


            }

        }
    }
}

@Composable
fun TestsListAppBar(
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    allTestScreenClicks: AllTestScreenClicks
) {
//    var itemVal = 0
//    if (sharedViewModel.itemsInCart.value != null) {
//        itemVal = sharedViewModel.itemsInCart.value!!
//    }
    val itemsInCart by sharedViewModel.itemsInCart.observeAsState()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxHeight()) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = modifier.clickable {
                    allTestScreenClicks.navigateBack()
                })
            Spacer(modifier = modifier.width(15.dp))
            Text(
                text = "All Tests", style = TextStyle.Default.copy(
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
                    onClick = { allTestScreenClicks.navigateToMyCartScreen() })
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
fun TestListItem(
    modifier: Modifier = Modifier,
    testListModel: TestListModel,
    allTestScreenClicks: AllTestScreenClicks,
    testListViewModel: TestListViewModel = hiltViewModel()
) {

    var showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        RelationShipEnableDialog(
            relationShipEnableModels = testListViewModel.relationShipEnableModels,
            setShowDialog = { showDialog.value = false },
            onItemClick = { item1, item2 ->
                testListViewModel.relationShipEnableModels[item2].enabled = item1
            })
    }



    Card(elevation = 0.dp, modifier = modifier.padding(top = 10.dp, bottom = 2.dp),) {
        Column(modifier = modifier.padding(horizontal = 15.dp, vertical = 12.dp)) {
            Text(
                text = testListModel.testName, style = TextStyle.Default.copy(
                    color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 13.sp
                )

            )
            Divider()
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = testListModel.testInclude, style = TextStyle.Default.copy(
                    color = Color.Gray.copy(alpha = 0.5f), fontSize = 12.sp
                )
            )

            Text(
                text = testListModel.testType, style = TextStyle.Default.copy(
                    color = Color.Gray.copy(alpha = 0.5f), fontSize = 12.sp
                )
            )

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = testListModel.recommendedFor, style = TextStyle(fontSize = 12.sp))
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(

                    text = testListModel.price, style = TextStyle.Default.copy(
                        color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 12.sp
                    )
                )
                Row(modifier = modifier.align(Alignment.CenterEnd)) {
                    Button(onClick = { allTestScreenClicks.navigateToTestDetailScreen() }) {
                        Text(text = "DETAIL", style = TextStyle.Default.copy(fontSize = 13.sp))
                    }
                    Spacer(modifier = modifier.width(7.dp))
                    OutlinedButton(
                        onClick = { showDialog.value = true },
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
    TestListItem(
        testListModel = TestListModel("", "", "", "", ""),
        allTestScreenClicks = object : AllTestScreenClicks {
            override fun navigateToTestDetailScreen() {

            }

            override fun navigateToMyCartScreen() {

            }

            override fun navigateBack() {

            }
        }
    )
}