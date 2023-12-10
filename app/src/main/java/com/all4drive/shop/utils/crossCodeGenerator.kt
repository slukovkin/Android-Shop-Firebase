package com.all4drive.shop.utils

fun crossCodeGenerator(code: Int): Int {
    return code.toString().substring(0, 5).toInt()
}
