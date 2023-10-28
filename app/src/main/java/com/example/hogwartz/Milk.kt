package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_milk.*
import kotlinx.android.synthetic.main.activity_milk.view.*

class Milk : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    private lateinit var uid: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_milk)
        supportActionBar?.hide()


        mAuth = FirebaseAuth.getInstance()

        btn_request_milk.setOnClickListener(){
            Toast.makeText(this@Milk,"request Confirmed", Toast.LENGTH_SHORT).show()
            if(litres.text.toString().equals("")||which.text.toString().equals("")){
                Toast.makeText(this@Milk,"Please fill all fields",Toast.LENGTH_SHORT).show()
            }else{
              val Litres = litres.text.toString()
              val Which = which.text.toString()
            addmilkservice(Litres,Which)
        }}

        backfrommilk.setOnClickListener(){
            val e = Intent(this@Milk,MainActivity::class.java)
            startActivity(e)
        }


    }

    private fun addmilkservice(l:String,w:String){

        uid =mAuth.currentUser?.uid.toString()
        mDbRef= FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).child("milk request").child("which").setValue(w)
        mDbRef.child("Users").child(uid).child("milk request").child("litres").setValue(l)
    }
    }
