package com.all4drive.shop

import java.security.MessageDigest
import java.util.Locale
import java.util.UUID


class User(_email: String, _password: String) {
    val id = UUID.randomUUID().toString()
    val email = _email
    val password = getHashPassword(_password)

    private fun getHashPassword(pass: String) :String {
        val digestByte = MessageDigest.getInstance("SHA256").digest(pass.toByteArray())
        return with(StringBuilder()) {
            digestByte.forEach { b -> append(String.format("%02X", b)) }
            toString().lowercase(Locale.US)
        }
    }
//
//    fun getUserInfo() :String {
//        return "User ID: $id, Email: $email, Password: $password"
//    }
 }