package com.example.mvvmjetpackcompose.ui.screens.managerelationship

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.mvvmjetpackcompose.R

var relationShipsList = listOf(
    "Self",
    "Spouse",
    "Child",
    "Father",
    "GrandParent",
    "Sibling",
    "Friend",
    "Son",
    "Neighbour",
    "Colleague",
    "Others"
)

@Composable
fun RelationShipDialog(
    value: String,
    setShowDialog: (Boolean) -> Unit,
    setValue: (String) -> Unit, modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,

            ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                items(relationShipsList) { it ->
                    RelationShipItem(it, value == it)
                }
            }
        }
    }
}

@Composable
fun RelationShipItem(title: String, isSelected: Boolean, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .clickable {}
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle.Default.copy(color = Color.Black, fontWeight = FontWeight.Bold)
        )
        if (isSelected) {
            Icon(painter = painterResource(id = R.drawable.icon), contentDescription = "amir")
        }
    }
}