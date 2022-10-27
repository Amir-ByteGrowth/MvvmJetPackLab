package com.example.mvvmjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mvvmjetpackcompose.data.remote.ResourceSealed
import com.example.mvvmjetpackcompose.navigation.BottomNav
import com.example.mvvmjetpackcompose.navigation.BottomNavItem
import com.example.mvvmjetpackcompose.navigation.NavigationGraph
import com.example.mvvmjetpackcompose.ui.FirstViewModel
import com.example.mvvmjetpackcompose.ui.screens.CreatePostsListScreen
import com.example.mvvmjetpackcompose.ui.theme.MvvmJetPackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var sharedViewModel: SharedViewModel = SharedViewModel()

        setContent {
            MvvmJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

//                val navController = rememberNavController()

                val onBack: () -> Unit = {
                    navController.popBackStack()
                }

                val screens = listOf(
                    BottomNavItem.Home, BottomNavItem.Chat, BottomNavItem.Account
                )

                val showBottomBar =
                    navController.currentBackStackEntryAsState().value?.destination?.route in screens.map { it.screen_route }


                Scaffold(bottomBar = { if (showBottomBar) BottomNav(navController = navController) }) {

                    NavigationGraph(navController = navController, sharedViewModel)
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: FirstViewModel = hiltViewModel()) {
//    val firstViewModel: FirstViewModel = hiltViewModel<FirstViewModel>()
    Column {
        CreateHeader(viewModel = viewModel)
        CreateBody(viewModel)
    }


}


@Composable
fun CreateHeader(viewModel: FirstViewModel, modifier: Modifier = Modifier) {

    var nameState = viewModel.userName.collectAsState().value
    Log.d("DataStoreName", nameState)
    var userNameTemp by remember { mutableStateOf(nameState) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        color = Color.Blue,
        contentColor = Color.Red
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Column {
                TextField(
                    value = userNameTemp,
                    onValueChange = { userNameTemp = it },
                    label = {
                        Text(
                            text = "User Name", color = Color.White
                        )
                    },
                    placeholder = { Text(text = "Enter new user name") },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.White,
                        placeholderColor = Color.White,
                        textColor = Color.White,
                    )
                )

                Button(onClick = {

                    viewModel.setUserName(userNameTemp)
                }) {
                    Text(text = "Change")
                }
            }


            Column {
                Text(
                    text = nameState, style = MaterialTheme.typography.h6.copy(color = Color.White)
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(text = "Logged In As", modifier = modifier.background(color = Color.White))
            }
        }


    }


}

@Composable
fun CreateBody(viewModel: FirstViewModel) {
    when (val state = viewModel.postsData.collectAsState().value) {
        is ResourceSealed.Empty -> Text(
            text = "Empty", modifier = Modifier.padding(16.dp)
        )
        is ResourceSealed.Loading -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
        is ResourceSealed.Error -> Text(
            text = "Error", modifier = Modifier.padding(16.dp)
        )
        is ResourceSealed.Success -> CreatePostsListScreen(list = state.data!!.toList())
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MvvmJetPackComposeTheme {
        Greeting("Android")
    }
}