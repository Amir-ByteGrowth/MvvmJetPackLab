package com.example.mvvmjetpackcompose.ui.screens.chatscreen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.mvvmjetpackcompose.R

@Composable
fun ChatScreen() {
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .fillMaxSize()
            .clickable {
                val u = Uri.parse("tel:" + "03067274669")

                // Create the intent and set the data for the
                // intent as the phone number.
                val i = Intent(Intent.ACTION_DIAL, u)
                try {

                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    startActivity(context, i, null)
                } catch (s: SecurityException) {

                    // show() method display the toast with
                    // exception message.
                    Toast
                        .makeText(context, "An error occurred", Toast.LENGTH_LONG)
                        .show()
                }
            }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Chat Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }

    }
}