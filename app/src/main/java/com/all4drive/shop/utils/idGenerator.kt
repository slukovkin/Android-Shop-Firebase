package com.all4drive.shop.utils

import java.util.UUID

fun idGenerator(): String {
    return UUID.randomUUID().toString()
}