package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator
import com.all4drive.shop.utils.passwordHashGenerator

class Customer(var name: String, val email: String, password: String) {
    val id = idGenerator()
    var password = passwordHashGenerator(password)
 }
