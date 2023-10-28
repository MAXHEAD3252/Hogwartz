package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_food.*

class Food : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef :DatabaseReference
    private lateinit var uid: String
    private var requestfood : String = "true"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        supportActionBar?.hide()


        mAuth = FirebaseAuth.getInstance()

        btn_request_food.setOnClickListener(){
            Toast.makeText(this@Food,"request Confirmed",Toast.LENGTH_SHORT).show()
            addfoodservice(requestfood)
        }

        gobackhome.setOnClickListener(){
            val l = Intent(this@Food,MainActivity::class.java)
            startActivity(l)
        }

    }

    private fun addfoodservice(requestfood:String){

        uid =mAuth.currentUser?.uid.toString()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).child("food request").setValue(requestfood)
    }
}