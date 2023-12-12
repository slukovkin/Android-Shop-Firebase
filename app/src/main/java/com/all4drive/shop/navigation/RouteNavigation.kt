package com.all4drive.shop.navigation

sealed class RouteNavigation(val title: String, val route: String) {
    object Login : RouteNavigation("Login", "login")
    object Registration : RouteNavigation("Registration", "registration")
    object Main : RouteNavigation("Main", "main")
}
