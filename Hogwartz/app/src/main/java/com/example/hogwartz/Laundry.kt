package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_laundry.*
import java.util.*

class Laundry : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    private lateinit var uid: String
    private var requestlaundry : String = "true"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laundry)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()

        backfromlaundry.setOnClickListener(){
            val n =Intent(this@Laundry,MainActivity::class.java)
            startActivity(n)
        }

        addcloth.setOnClickListener(){
            var b =totalclothes.text.toString().toInt()
            var result = b*5
            totalmoney.text=result.toString()
        }

        laundryrequest.setOnClickListener(){
            Toast.makeText(this@Laundry,"Laundry guy will pick up your clothes from your room",Toast.LENGTH_SHORT).show()
            addfoodservice(requestlaundry)
        }

    }

    private fun addfoodservice(requestlaundry:String){

        uid =mAuth.currentUser?.uid.toString()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).child("laundry request").setValue(requestlaundry)
    }
}