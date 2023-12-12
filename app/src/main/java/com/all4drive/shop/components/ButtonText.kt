package com.all4drive.shop.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.all4drive.shop.database.Db

@Composable
fun ButtonText(
    text: String,
    phone: String,
    password: String,
    name: String = "",
    address: String = ""
) {
    val db = Db()

    Button(
        onClick = {
            if (name != "") {
                db.createUser(name, phone, password, address, "users")
            } else {
                db.login(phone, password, "users")
            }
        },
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    )
    {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}