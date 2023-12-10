package com.all4drive.shop.models
data class ProductModel(
    var id: String,
    var code: Int,
    var article: String,
    var title: String,
    var qty: Double,
    var price: Double,
    var category: CategoryModel,
    var cross: Int,
)
