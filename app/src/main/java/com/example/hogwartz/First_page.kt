package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_page.*

class First_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        supportActionBar?.hide()

        btn_login_first.setOnClickListener(){
            val lo = Intent(this@First_page,Login_page::class.java)
            startActivity(lo)
        }
        btn_signup_first.setOnClickListener(){
            val si = Intent(this@First_page,Signup_page::class.java)
            startActivity(si)
        }

    }
}