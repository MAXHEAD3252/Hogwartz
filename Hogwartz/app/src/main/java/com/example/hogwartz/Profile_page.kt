package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile_page.*

class Profile_page : AppCompatActivity() {

    private lateinit var uid:String
    private lateinit var user:User
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        uid =mAuth.currentUser?.uid.toString()

        mDbRef = FirebaseDatabase.getInstance().getReference("Users")
        if(uid.isNotEmpty()){
            getUserData()
        }

        back_pro.setOnClickListener {
            val back = Intent(this@Profile_page, MainActivity::class.java)
            startActivity(back)
        }
    }

    private fun getUserData() {
        mDbRef.child(uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                user = snapshot.getValue(User::class.java)!!

                show_name.setText(user.name)
                show_email.setText(user.email)
                show_gender.setText(user.gender)
                show_age.setText(user.age.toString())
                show_mobileno.setText(user.mobileno.toString())
                show_roomno.setText(user.roomno.toString())

            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Profile_page,"unable to fetch data",Toast.LENGTH_SHORT).show()
            } })
    }
}