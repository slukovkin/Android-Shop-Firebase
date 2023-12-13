package com.all4drive.shop.database

import android.util.Log
import com.all4drive.shop.Entity.Customer
import com.all4drive.shop.models.CustomerModel
import com.all4drive.shop.utils.passwordHashGenerator
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
            }

            // TODO не возвращается найенный пользователь

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return userList
    }

    fun login(phone: String, password: String, table: String): CustomerModel? {

        var user: CustomerModel? = null
        val passwordHash = passwordHashGenerator(password)
        val dbRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(table)
        dbRef.orderByChild("phone").equalTo(phone)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children) {
                        val userData = data.getValue(CustomerModel::class.java)
                        if (userData?.password == passwordHash) {
                            Log.d("MyLog", "Пользователь: ${userData.name}  найден в БД")
                            user = userData
                        } else {
                            Log.d("MyLog", "Пользователь не найден в БД")
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        Log.d("MyLog", "Пользователь: ${user?.name} с телефоном ${user?.phone} найден в БД")
        return user
    }


    fun createUser(name: String, phone: String, password: String, address: String, table: String) {
        val db: DatabaseReference = Firebase.database.reference
        val user = Customer(name, phone, password, address)
        db.child(table).child(user.id).setValue(user)
    }
}
