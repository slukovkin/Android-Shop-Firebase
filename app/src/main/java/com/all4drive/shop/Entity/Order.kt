package com.all4drive.shop.Entity

class Order {
    val orderCustomer = mutableMapOf<Customer, List<Product>>()
}