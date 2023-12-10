package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator

class Category(
    val title: String
) {
    val id = idGenerator()
}