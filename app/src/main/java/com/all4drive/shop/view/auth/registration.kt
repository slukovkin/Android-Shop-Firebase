@file:OptIn(ExperimentalMaterial3Api::class)

package com.all4drive.shop.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.all4drive.shop.components.ButtonText
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun Registration() {

    var phone by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var address by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            TextField(
                value = phone,
                onValueChange = { value -> phone = value },
                textStyle = TextStyle(fontSize = 25.sp),
                singleLine = true,
                label = { Text("Телефон") },
                placeholder = { Text("Введите номер телефона") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            TextField(
                value = password,
                onValueChange = { value -> password = value },
                textStyle = TextStyle(fontSize = 25.sp, color = Color.Black),
                singleLine = true,
                label = { Text(text = "Пароль") },
                placeholder = { Text("Введите пароль") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            TextField(
                value = address,
                onValueChange = { text -> address = text },
                textStyle = TextStyle(fontSize = 25.sp),
                singleLine = true,
                label = { Text("Адрес доставки") },
                placeholder = { Text("Введите адрес доставки") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .padding(bottom = 10.dp)
        ) {
            ButtonText("Регистрация")
        }
    }
}
