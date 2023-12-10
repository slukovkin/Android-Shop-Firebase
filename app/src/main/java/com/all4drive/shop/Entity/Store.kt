package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator

class Store(
    val title: String
) {
    val id = idGenerator()
    val productsList = mutableListOf<Product>()
}