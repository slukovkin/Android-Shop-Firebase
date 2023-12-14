package com.all4drive.shop.database

import android.util.Log
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class Db {
    private val auth = Firebase.auth

    fun login(email: String, password: String, table: String, navController: NavController) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("MyLog", "User: ${user?.email}")
                    navController.navigate("main")
                } else {
                    // If sign in fails, display a message to the user.
//                    Log.d("MyLog", "UserWithEmail: ", it.exception)
                    val errorMessage = it.exception?.message
                    Log.d("MyLog", "UserWithEmail: $errorMessage")
                }
            }
            .addOnFailureListener {
//                Log.w("MyLog", "createUserWithEmail:failure", it)
                Log.d("MyLog", "Failure")
            }
    }


    fun createUser(email: String, password: String, table: String, navController: NavController) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("MyLog", "Completed. User: ${user?.email}")
                    navController.navigate("login")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("MyLog", "createUserWithEmail:failure", it.exception)
                }
            }
            .addOnFailureListener {
                Log.d("MyLog", "Failure")
            }
    }
}
