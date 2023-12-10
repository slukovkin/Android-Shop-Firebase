package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator

class Cart{
    val id = idGenerator()
    val products = mutableListOf<Product>()
}