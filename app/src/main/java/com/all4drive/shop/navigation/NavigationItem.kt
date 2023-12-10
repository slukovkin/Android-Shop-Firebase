package com.all4drive.shop.navigation

sealed class NavigationItem(val title: String, val route: String) {
    object Login : NavigationItem("Login", "login")
    object Registration : NavigationItem("Registration", "registration")
    object Main : NavigationItem("Main", "main")
}
