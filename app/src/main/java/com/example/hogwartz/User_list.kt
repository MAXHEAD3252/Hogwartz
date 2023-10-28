package com.example.hogwartz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_user_list.*

class User_list : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        mAuth = FirebaseAuth.getInstance()

        mDbRef = FirebaseDatabase.getInstance().getReference()
        data()
    }
    private fun data(){
        mDbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                show_users.text= snapshot.child("Users").getValue().toString()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@User_list,"unable to fetch data", Toast.LENGTH_SHORT).show()
            } })
    }
    }
