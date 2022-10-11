package com.example.mvvmjetpackcompose.ui.screens.managerelationship

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvmjetpackcompose.R

@Composable
fun BottomSheetContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier.padding(20.dp)) {
        Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logofull),
                contentDescription = "",
                alignment = Alignment.Center
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.padding(top = 10.dp)
        ) {
            TextField(
                value = "First Name",
                onValueChange = {},
                label = { "First Name" },
                modifier = modifier
                    .weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )
            Spacer(modifier = modifier.width(10.dp))
            TextField(
                value = "Last Name",
                onValueChange = {},
                label = { "Last Name" },
                modifier = modifier.weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )


        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.padding(top = 10.dp)
        ) {
            TextField(
                value = "F/H Name",
                onValueChange = {},
                label = { "F/H Name" },
                modifier = modifier
                    .weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )
            Spacer(modifier = modifier.width(10.dp))
            TextField(
                value = "Gender",
                onValueChange = {},
                label = { "Gender" },
                modifier = modifier.weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )


        }
        TextField(
            value = "Mobile number",
            onValueChange = {},
            label = { "Mobile number" },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            ), modifier = modifier.fillMaxWidth()
        )
        TextField(
            value = "Date of birth",
            onValueChange = {},
            label = { "Date of birth" },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            ), modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(20.dp))
        Row(modifier = modifier.height(50.dp)) {
            TextButton(
                onClick = { /*TODO*/ }, modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(text = "Cancel")
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight(), shape = RoundedCornerShape(
                    topStart = 50.dp
                ),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
            ) {
                Text(text = "Add", style = TextStyle.Default.copy(color = Color.White))
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
    }


//    Column {
//        BottomSheetListItem(
//            icon = R.drawable.icon,
//            title = "Share",
//            onItemClick = { title ->
//                Toast.makeText(
//                    context,
//                    title,
//                    Toast.LENGTH_SHORT
//                ).show()
//            })
//        BottomSheetListItem(
//            icon = R.drawable.icon,
//            title = "Get link",
//            onItemClick = { title ->
//                Toast.makeText(
//                    context,
//                    title,
//                    Toast.LENGTH_SHORT
//                ).show()
//            })
//        BottomSheetListItem(
//            icon = R.drawable.icon,
//            title = "Edit name",
//            onItemClick = { title ->
//                Toast.makeText(
//                    context,
//                    title,
//                    Toast.LENGTH_SHORT
//                ).show()
//            })
//        BottomSheetListItem(
//            icon = R.drawable.icon,
//            title = "Delete collection",
//            onItemClick = { title ->
//                Toast.makeText(
//                    context,
//                    title,
//                    Toast.LENGTH_SHORT
//                ).show()
//            })
//    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    BottomSheetContent()
}

@Composable
fun BottomSheetListItem(icon: Int, title: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(title) })
            .height(55.dp)
            .background(color = colorResource(id = R.color.purple_500))
            .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "Share", tint = Color.White)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetListItemPreview() {
    BottomSheetListItem(icon = R.drawable.icon, title = "Share", onItemClick = { })
}