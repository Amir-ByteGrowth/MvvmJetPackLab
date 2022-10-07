package com.example.mvvmjetpackcompose.ui.screens.accountscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.TestModel
import com.example.mvvmjetpackcompose.navigation.AccountScreenClicks
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.UserMainViewModel
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components.TitleString
import com.example.mvvmjetpackcompose.ui.screens.usermainscreen.components.TitleStringHeader

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    userMainViewModel: UserMainViewModel = hiltViewModel(),clicks: AccountScreenClicks
) {
    var settingsList = userMainViewModel.settingsList

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        TitleStringHeader(title = "Settings")
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(top = 20.dp, bottom = 10.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.cameraround),
                    modifier = modifier.size(70.dp),
                    contentDescription = "Camera"
                )
                Spacer(modifier = modifier.width(10.dp))
                Text(text = "03067274669")
            }
            Button(
                onClick = { clicks.navigateToManageScreen() },
                modifier = modifier
                    .align(Alignment.BottomEnd)
                    .height(45.dp)
            ) {
                Text(text = "Manage", style = TextStyle(fontSize = 17.sp))
            }


        }
        Spacer(modifier = modifier.height(10.dp))
        Divider()
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[0])
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[1])
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[2])
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[3])
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[4])
        Spacer(modifier = modifier.height(10.dp))
        ItemSettingListItem(testModel = settingsList[5])
        Spacer(modifier = modifier.height(40.dp))

        CreateSettingsBottom()
    }
}

@Composable
fun CreateSettingsBottom(modifier: Modifier = Modifier) {
    Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth()){
        Image(
            painter = painterResource(id = R.drawable.cameraround),
            modifier = modifier.size(30.dp).clickable {  },
            contentDescription = " "
        )
        Image(
            painter = painterResource(id = R.drawable.cameraround),
            modifier = modifier.size(30.dp).clickable {  },
            contentDescription = " "
        )
        Image(
            painter = painterResource(id = R.drawable.cameraround),
            modifier = modifier.size(30.dp).clickable {  },
            contentDescription = " "
        )
        Image(
            painter = painterResource(id = R.drawable.cameraround),
            modifier = modifier.size(30.dp).clickable {  },
            contentDescription = " "
        )
        Image(
            painter = painterResource(id = R.drawable.cameraround),
            modifier = modifier.size(30.dp).clickable {  },
            contentDescription = " "
        )

    }
}


@Composable
fun ItemSettingListItem(modifier: Modifier = Modifier, testModel: TestModel) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 8.dp, vertical = 15.dp)
        ) {
            Icon(painter = painterResource(id = testModel.icon), contentDescription = "des")
            Spacer(modifier = modifier.width(10.dp))
            Text(text = testModel.name, style = TextStyle(fontWeight = FontWeight.Bold))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewITem() {
    CreateSettingsBottom()
}