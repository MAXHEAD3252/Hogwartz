package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_maid.*

class Maid : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    private lateinit var uid: String
    private var requestmaid : String = "true"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maid)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        cleaningrequest.setOnClickListener(){
            Toast.makeText(this@Maid,"Request Confirmed",Toast.LENGTH_SHORT).show()
            addmaidservice(requestmaid)
        }


        backfromcleaning.setOnClickListener(){
            val c = Intent(this@Maid,MainActivity::class.java)
            startActivity(c)
        }

    }

    private fun addmaidservice(requestfood:String){

        uid =mAuth.currentUser?.uid.toString()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).child("maid request").setValue(requestmaid)
    }
}