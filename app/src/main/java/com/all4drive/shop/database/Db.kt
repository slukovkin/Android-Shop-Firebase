package com.all4drive.shop.database

import android.util.Log
import android.widget.Toast
import com.all4drive.shop.Entity.Customer
import com.all4drive.shop.models.CustomerModel
import com.all4drive.shop.utils.passwordHashGenerator
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class Db {
    private val auth = Firebase.auth

    fun login(email: String, password: String, table: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("MyLog", "User: ${user?.email}")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("MyLog", "UserWithEmail: ", it.exception)
                }
            }
            .addOnFailureListener {
                Log.w("MyLog", "createUserWithEmail:failure", it)
                Log.d("MyLog", "Failure")
            }
    }


    fun createUser(email: String, password: String, table: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("MyLog", "Completed. User: ${user?.email}")
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
