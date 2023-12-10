package com.all4drive.shop.database

import android.util.Log
import com.all4drive.shop.Entity.Customer
import com.all4drive.shop.models.CustomerModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class Db {
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

    fun createUser(name: String, email: String, password: String, table: String) {
        val db: DatabaseReference = Firebase.database.reference
        val user = Customer(name, email, password)
        db.child(table).child(user.id).setValue(user)
    }

}