package com.example.graduation2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_inputnum.*

//private lateinit var database: DatabaseReference
// ...database = Firebase.database.reference

class Inputnum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputnum)


        //데이터 쓰기
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        okbtn.setOnClickListener {
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val value = dataSnapshot.getValue(String::class.java)
                    Log.d(TAG, "Value is: $value")

                    myRef.child("users").get().addOnSuccessListener {
                        Log.i("firebase", "Got value ${it.value}")
                    }.addOnFailureListener{
                        Log.e("firebase", "Error getting data", it)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })

        }
    }
}