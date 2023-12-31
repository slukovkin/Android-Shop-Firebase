package com.all4drive.shop.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.all4drive.shop.R
import com.all4drive.shop.components.ButtonText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth(status: Boolean, navController: NavController) {

    val loginOrRegistration by remember {
        mutableStateOf(status)
    }
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var isVisiblePassword by remember {
        mutableStateOf(true)
    }

    val iconButtonPasswordToggle = @Composable {
        IconButton(onClick = { isVisiblePassword = !isVisiblePassword }) {
            if (isVisiblePassword) {
                Icon(
                    painter = painterResource(id = R.drawable.password_visibility_off),
                    contentDescription = "Icon"
                )
            } else
                Icon(
                    painter = painterResource(id = R.drawable.password_visibility),
                    contentDescription = "Icon"
                )
        }
    }

    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
    ) {

        if (!loginOrRegistration) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    textStyle = TextStyle(fontSize = 20.sp),
                    singleLine = true,
                    label = { Text(stringResource(id = R.string.name)) },
                    placeholder = { Text(stringResource(id = R.string.your_name)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                value = email,
                onValueChange = { email = it },
                textStyle = TextStyle(fontSize = 20.sp),
                singleLine = true,
                label = { Text(stringResource(id = R.string.email)) },
                placeholder = { Text(stringResource(id = R.string.enter_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                singleLine = true,
                label = { Text(stringResource(id = R.string.password)) },
                placeholder = { Text(stringResource(id = R.string.enter_password)) },
                visualTransformation = if (isVisiblePassword) PasswordVisualTransformation()
                else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = { iconButtonPasswordToggle() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        ) {
            if (validationForm(email, password)) {
                if (loginOrRegistration) {
                    ButtonText(stringResource(R.string.login), email, password, navController)
                } else {
                    ButtonText(
                        stringResource(R.string.registration),
                        email,
                        password,
                        navController,
                        name,
                    )
                }
            } else {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    enabled = false
                ) {
                    Text(
                        if (!loginOrRegistration) {
                            stringResource(
                                R.string.registration
                            )
                        } else {
                            stringResource(R.string.login)
                        },
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 5.dp)
        ) {
            SelectRegistrationOrLogin(status, navController)
        }
    }
}

@Composable
fun SelectRegistrationOrLogin(
    activityToggle: Boolean,
    navController: NavController
) {
    val registration = stringResource(id = R.string.have_account)
    val login = stringResource(id = R.string.dont_have_account)

    val content by remember {
        mutableStateOf(if (activityToggle) login else registration)
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
                .clickable {
                    if (activityToggle) {
                        navController.navigate("registration")
                    } else {
                        navController.navigate("login")
                    }
                }
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        )
    }
}

fun validationForm(email: String, password: String): Boolean {
    return !email.isNullOrEmpty() && password.trim().length >= 6
}
