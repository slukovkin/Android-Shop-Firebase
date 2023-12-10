package com.all4drive.shop.models

data class OrderModel(
    var orderCustomer: CustomerModel,
    var orderProduct: List<ProductModel>
)
