package com.all4drive.shop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.all4drive.shop.StartScreen
import com.all4drive.shop.view.auth.Auth

@Composable
fun NavGraph(
    navHostController: NavHostController,
    navController: NavController
) {
    NavHost(navController = navHostController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Login.route) {
            Auth(true, navController)
        }
        composable(NavigationItem.Registration.route) {
            Auth(false, navController)
        }
        composable(NavigationItem.Main.route) {
            StartScreen()
        }
    }
}