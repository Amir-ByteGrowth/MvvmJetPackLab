package com.example.mvvmjetpackcompose.ui.screens.genericscreenscomponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenericScreenComp(
    appBar: @Composable() () -> Unit,
    content: @Composable() () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { appBar() },
        modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        content = { content() })
}