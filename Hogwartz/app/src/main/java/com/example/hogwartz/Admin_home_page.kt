package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_home_page.*
import kotlinx.android.synthetic.main.activity_user_list.*

class Admin_home_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home_page)


        card_users_admin.setOnClickListener() {
            val f = Intent(this@Admin_home_page, User_list::class.java)
            Toast.makeText(this,"user list",Toast.LENGTH_SHORT).show()
            startActivity(f)
        }

        admin_logout.setOnClickListener() {
            val j = Intent(this@Admin_home_page, Login_page::class.java)
            startActivity(j)
        }
        edt_user.setOnClickListener(){
            val j = Intent(this@Admin_home_page,Admin_edt_user::class.java)
            startActivity(j)
        }
    }
    // for the back press
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@Admin_home_page,"Please press twice to logout", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }


}