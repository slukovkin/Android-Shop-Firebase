package com.all4drive.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.all4drive.shop.navigation.NavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 48.dp, start = 8.dp, end = 8.dp),
            ) {
                StartNavigation()
            }
        }
    }
}

@Composable
fun StartNavigation() {
    val navController: NavHostController = rememberNavController()
    NavGraph(navHostController = navController, navController = navController)
}


@Composable
fun StartScreen() {
    Text(
        "Вы зашли с приложение!",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun CreateUserToDbButtonComponent(
    titleButton: String,
    name: String,
    email: String,
    password: String,
    table: String
) {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = titleButton,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun GetUsersFromDbButtonComponent(titleButton: String, table: String) {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = titleButton,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}

