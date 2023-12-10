package com.all4drive.shop.Entity

import com.all4drive.shop.utils.idGenerator
import com.all4drive.shop.utils.passwordHashGenerator

class Customer(val phone: String, password: String) {
    val id = idGenerator()
    val password = passwordHashGenerator(password)
 }