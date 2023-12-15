package com.all4drive.shop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.all4drive.shop.StartScreen
import com.all4drive.shop.view.admin.AdminPanel
import com.all4drive.shop.view.admin.ProductList
import com.all4drive.shop.view.auth.Auth

@Composable
fun NavGraph(
    navHostController: NavHostController,
    navController: NavController
) {
    NavHost(navController = navHostController, startDestination = RouteNavigation.Admin.route) {
        composable(RouteNavigation.Login.route) {
            Auth(true, navController)
        }
        composable(RouteNavigation.Registration.route) {
            Auth(false, navController)
        }
        composable(RouteNavigation.Main.route) {
            StartScreen()
        }
        composable(RouteNavigation.Admin.route) {
            AdminPanel()
        }
        composable(RouteNavigation.AdminProductList.route) {
            ProductList()
        }
    }
}