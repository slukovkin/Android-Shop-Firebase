package com.all4drive.shop.Entity

import com.all4drive.shop.models.CategoryModel
import com.all4drive.shop.utils.crossCodeGenerator
import com.all4drive.shop.utils.idGenerator

class Product(
    val prodCode : Int,
    val prodArticle: String,
    val prodTitle: String,
    var prodQty: Double,
    var prodPrice: Double,
    var prodCategory: CategoryModel,
) {
    val id = idGenerator()
    val proCross = crossCodeGenerator(prodCode)
}
