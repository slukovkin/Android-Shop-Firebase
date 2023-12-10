package com.all4drive.shop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.all4drive.shop.Entity.Customer
import com.all4drive.shop.models.CustomerModel
import com.all4drive.shop.navigation.NavGraph
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 48.dp, start = 8.dp, end = 8.dp),
            ) {
                StartNavigation()
            }
        }
    }
}

@Composable
fun StartNavigation(){
    val navController: NavHostController = rememberNavController()
    NavGraph(navHostController = navController, navController = navController)
}


@Composable
fun StartScreen() {
    Text("Вы зашли с приложение!",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form() {
//    var userList = ArrayList<UserModel>()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.White)
            .clip(
                RoundedCornerShape(10.dp)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = email,
                onValueChange = { text -> email = text },
                textStyle = TextStyle(fontSize = 25.sp),
                singleLine = true,
                placeholder = { Text("Введите email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(),
            )
        }
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = password,
                onValueChange = { text -> password = text },
                textStyle = TextStyle(fontSize = 25.sp),
                singleLine = true,
                placeholder = { Text("Введите пароль") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(),
            )
        }
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            CreateUserToDbButtonComponent("Сохранить", email, password, "users")
        }
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            GetUsersFromDbButtonComponent(titleButton = "Получить", table = "users")
        }
    }
}


@Composable
fun CreateUserToDbButtonComponent(
    titleButton: String,
    email: String,
    password: String,
    table: String
) {
    Button(onClick = {
        createUser(email, password, table)
    }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)) {
        Text(
            text = titleButton,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun GetUsersFromDbButtonComponent(titleButton: String, table: String) {
    Button(onClick = {
        getUsersAll(table)
    }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)) {
        Text(
            text = titleButton,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}


fun getUsersAll(table: String): ArrayList<CustomerModel> {
    val userList = arrayListOf<CustomerModel>()
    val dbRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(table)
    dbRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            userList.clear()
            if (snapshot.exists()) {
                for (data in snapshot.children) {
                    val userData = data.getValue(CustomerModel::class.java)
                    userList.add(userData!!)
                }
            }
            Log.d("MyLog", "Users: $userList")
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
    return userList
}

fun createUser(email: String, password: String, table: String) {
    val db: DatabaseReference = Firebase.database.reference
    val user = Customer(email, password)
    db.child(table).child(user.id).setValue(user)
}
