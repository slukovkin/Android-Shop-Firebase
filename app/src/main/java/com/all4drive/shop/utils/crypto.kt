package com.all4drive.shop.utils

import java.security.MessageDigest
import java.util.Locale

fun passwordHashGenerator(password: String): String {
    val digits = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
    return with(StringBuilder()) {
        digits.forEach { append(String.format("%02X", it)) }
        toString().lowercase(Locale.US)
    }
}
