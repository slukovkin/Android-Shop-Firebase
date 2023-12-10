package com.all4drive.shop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RouteNavigation(
    navController: NavController
)  {
    val routes = listOf<NavigationItem>(
        NavigationItem.Login,
        NavigationItem.Registration,
        NavigationItem.Main
    )
}