package com.all4drive.shop.Entity

import java.security.MessageDigest
import java.util.Locale
import java.util.UUID


class User(email: String, password: String) {
    val id = UUID.randomUUID().toString()
    val email = email
    val password = getHashPassword(password)

    private fun getHashPassword(pass: String) :String {
        val digestByte = MessageDigest.getInstance("SHA256").digest(pass.toByteArray())
        return with(StringBuilder()) {
            digestByte.forEach { b -> append(String.format("%02X", b)) }
            toString().lowercase(Locale.US)
        }
    }
 }