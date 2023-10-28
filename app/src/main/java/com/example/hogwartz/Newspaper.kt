package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_newspaper.*

class Newspaper : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    private lateinit var uid: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newspaper)

        supportActionBar?.hide()


        mAuth = FirebaseAuth.getInstance()

        btn_request_newspaper.setOnClickListener(){
            Toast.makeText(this@Newspaper,"request Confirmed", Toast.LENGTH_SHORT).show()
            if(choose.text.toString().equals("")){
                Toast.makeText(this@Newspaper,"Please enter fields",Toast.LENGTH_SHORT).show()
            }else{
                val c = choose.text.toString()
            addnewspaperservice(c)
        }}

        backfromnewspaper.setOnClickListener(){
            val l = Intent(this@Newspaper,MainActivity::class.java)
            startActivity(l)
        }

    }

    private fun addnewspaperservice(c:String){

        uid =mAuth.currentUser?.uid.toString()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).child("newspaper request").setValue(c)
    }


    }
