package com.all4drive.shop.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.all4drive.shop.database.Db
import com.all4drive.shop.models.CustomerModel

@Composable
fun ButtonText(
    text: String,
    email: String,
    password: String,
    name: String = "",
) {
    val db = Db()
    var user: CustomerModel? = null

    var result by remember {
        mutableStateOf(user)
    }

    Button(
        onClick = {
            if (name != "") {
                db.createUser(email, password, "users")
            } else {
                db.login(email, password, "users")
            }
        },
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    )
    {
        Text(
            if (result != null) {
                result?.name.toString()
            } else {
                text
            },
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}