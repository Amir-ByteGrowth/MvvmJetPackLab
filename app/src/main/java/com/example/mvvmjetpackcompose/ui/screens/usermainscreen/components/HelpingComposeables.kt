package com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpacerCompose(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(10.dp))
}

@Composable
fun TitleString(title: String) {
    Text(
        text = title,
        style = TextStyle.Default.copy(
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
    )
}