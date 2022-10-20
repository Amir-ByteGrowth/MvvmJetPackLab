package com.example.mvvmjetpackcompose.ui.screens.reportsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
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

@Composable
fun ReportsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { ReportsScreenAppBar() },
        modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        content = { ReportsScreenContent() })


}


@Composable
fun ReportsScreenContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(vertical = 20.dp)
            .fillMaxSize(), state = rememberLazyListState()
    ) {
        items(10) {
            ReportsListItem()
        }
    }
}


@Composable
fun ReportsScreenAppBar(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = modifier.clickable {})
        Spacer(modifier = modifier.width(15.dp))
        Text(
            text = "Reports", style = TextStyle.Default.copy(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
        Box(modifier = modifier
            .fillMaxWidth()
            ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Refresh",
                modifier = modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .clickable {}
            )
        }
    }
}

@Composable
fun ReportsListItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(70.dp)
            .padding(start = 2.dp, end = 2.dp, top = 5.dp)
            .fillMaxWidth()
            .clickable { }, shape = RoundedCornerShape(0), elevation = 4.dp
    ) {
        ConstraintLayout {
            val (line, name, forwardIcon) = createRefs()
            Divider(modifier = modifier
                .constrainAs(line) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .width(3.dp)
                .background(Color.Blue)

            )

            Column(modifier = modifier.constrainAs(name) {
                start.linkTo(line.end, margin = 10.dp)
                end.linkTo(forwardIcon.start, margin = 10.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }, horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Amir javeed",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = modifier.height(1.dp))
                Text(text = "29Male", style = TextStyle.Default.copy(color = Color.Gray))

            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "ArrowForward",
                modifier = modifier.constrainAs(forwardIcon) {
                    end.linkTo(parent.end, margin = 5.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReportsScreen() {
    ReportsScreen()
}