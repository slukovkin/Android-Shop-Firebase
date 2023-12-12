package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator
import com.all4drive.shop.utils.passwordHashGenerator

class Customer(val name: String, val phone: String, password: String, val address: String) {
    val id = idGenerator()
    var password = passwordHashGenerator(password)
 }
