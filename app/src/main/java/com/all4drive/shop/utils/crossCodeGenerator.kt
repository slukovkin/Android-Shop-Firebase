package com.all4drive.shop.utils

fun crossCodeGenerator(code: Int): Int {
    if (code != null) {
        return code.toString().substring(0, 5).toInt()
    } else return 0
}