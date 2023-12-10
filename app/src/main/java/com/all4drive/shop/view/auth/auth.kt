package com.all4drive.shop.view.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.all4drive.shop.R
import com.all4drive.shop.components.ButtonText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth(state: Boolean) {
    val login by remember {
        mutableStateOf(state)
    }

    var name by remember {
        mutableStateOf("")
    }
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
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
    ) {
        if (!login) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                TextField(
                    value = name,
                    onValueChange = { value -> name = value },
                    textStyle = TextStyle(fontSize = 25.sp),
                    singleLine = true,
                    label = { Text(stringResource(id = R.string.name)) },
                    placeholder = { Text(stringResource(id = R.string.your_name)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            TextField(
                value = phone,
                onValueChange = { value -> phone = value },
                textStyle = TextStyle(fontSize = 25.sp),
                singleLine = true,
                label = { Text(stringResource(id = R.string.phone)) },
                placeholder = { Text(stringResource(id = R.string.youre_phone)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            TextField(
                value = password,
                onValueChange = { value -> password = value },
                textStyle = TextStyle(fontSize = 25.sp, color = Color.Black),
                singleLine = true,
                label = { Text(stringResource(id = R.string.password)) },
                placeholder = { Text(stringResource(id = R.string.enter_password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }
        if (!login) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                TextField(
                    value = address,
                    onValueChange = { text -> address = text },
                    textStyle = TextStyle(fontSize = 25.sp),
                    singleLine = true,
                    label = { Text(stringResource(R.string.delivery_address)) },
                    placeholder = { Text(stringResource(id = R.string.enter_delivery_address)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        ) {
            if (login) ButtonText(stringResource(R.string.login))
            else ButtonText(stringResource(R.string.registration))
        }
    }
}


@Composable
fun selectRegistrationOrLogin(activityToggle: Boolean): Boolean {
    val registration = stringResource(id = R.string.have_account)
    val login = stringResource(id = R.string.dont_have_account)

    Log.d("MyLog", "Status: $activityToggle")
    var toggle by remember {
        mutableStateOf(activityToggle)
    }
    val content by remember {
        mutableStateOf(if (toggle) login else registration)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = content,
            style = TextStyle(
                color = Color.Blue,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .clickable { toggle = !toggle }
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 10.dp)
        )
    }
    return toggle
}

