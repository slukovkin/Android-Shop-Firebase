package com.all4drive.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.all4drive.shop.navigation.NavGraph
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(ScrollState(0), true)
                    .padding(start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                val navController: NavHostController = rememberNavController()
                NavGraph(navHostController = navController, navController = navController)
            }
        }
    }
}


@Composable
fun StartScreen() {
    Text(
        "Добро пожаловать!",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}
