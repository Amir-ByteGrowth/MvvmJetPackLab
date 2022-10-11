package com.example.mvvmjetpackcompose.ui.screens.managerelationship

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.RelationModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ManageRelationShipsScreen(modifier: Modifier = Modifier) {
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetContent()
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = colorResource(id = R.color.white),
        // scrimColor = Color.Red,  // Color for the fade background when you open/close the drawer
    ) {
        Scaffold(
            topBar = { RelationShipAppBar(scope = scope, state = modalBottomSheetState) },
            modifier = modifier.padding(start = 20.dp, bottom = 20.dp),
            content = { RelationShipManagementContent() }
        )
//        { padding ->  // We need to pass scaffold's inner padding to content. That's why we use Box.
//            Box(modifier = Modifier.padding(padding)) {
//                ModalBottomSheetMainScreen(scope = scope, state = modalBottomSheetState)
//            }
//        }
    }
}


//@Composable
//fun ManageRelationShipsScreen(modifier: Modifier = Modifier) {
//    Scaffold(
//
//        modifier = modifier.padding(start = 20.dp, bottom = 20.dp),
//        content = { RelationShipManagementContent() }
//    )
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RelationShipAppBar(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    state: ModalBottomSheetState
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            modifier = modifier.clickable { })
        Text(
            text = "Manage Relationships",
            style = TextStyle.Default.copy(
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 19.sp
            )
        )

        Box(
            modifier = modifier
                .size(50.dp)
                .clickable(onClick = {
                    scope.launch {
                            state.show()
                        }

                }),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.adduser),
                contentDescription = "add User",
                modifier = modifier
            )
        }

    }
}

@Composable
fun RelationShipManagementContent(
    relationShipManagementViewModel: RelationShipManagementViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(state = rememberLazyListState(), modifier = modifier.padding(end = 20.dp)) {
        items(relationShipManagementViewModel.relationShipList) {
            CardRelationItem(relationModel = it)
        }
    }
}


@Composable
fun CardRelationItem(modifier: Modifier = Modifier, relationModel: RelationModel) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 6.dp)
            .clickable { }, elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(vertical = 10.dp, horizontal = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = relationModel.name,
                    style = TextStyle.Default.copy(fontSize = 17.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = modifier.width(10.dp))
                Box(modifier = modifier.fillMaxHeight()) {
                    Text(
                        text = relationModel.relation,
                        modifier = modifier.align(Alignment.BottomStart),
                        style = TextStyle.Default.copy(fontSize = 12.sp)
                    )
                }

            }

            Box(modifier = modifier.size(50.dp), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.annotation),
                    modifier = modifier.size(30.dp),
                    contentDescription = "Annotation"
                )
            }

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(show: () -> Unit) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "Hello from sheet")
            }
        }, sheetPeekHeight = 0.dp
    ) {
        Button(onClick = {
            coroutineScope.launch {

                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                    bottomSheetScaffoldState.bottomSheetState.expand()
                } else {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        }) {
            Text(text = "Expand/Collapse Bottom Sheet")
        }
    }
}