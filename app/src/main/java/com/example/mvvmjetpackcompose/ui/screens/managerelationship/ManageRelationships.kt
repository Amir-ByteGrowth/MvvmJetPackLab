package com.example.mvvmjetpackcompose.ui.screens.managerelationship

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.RelationModel

@Composable
fun ManageRelationShipsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { RelationShipAppBar() },
        modifier = modifier.padding(start = 20.dp, bottom = 20.dp),
        content = { RelationShipManagementContent() }
    )
}

@Composable
fun RelationShipAppBar(modifier: Modifier = Modifier) {
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
                .clickable { }, contentAlignment = Alignment.Center
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