package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_credits.*

class Credits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
        supportActionBar?.hide()

        backfromcredits.setOnClickListener(){

            val f = Intent(this@Credits,MainActivity::class.java)
            startActivity(f)
        }
        linkedin_icon.setOnClickListener(){
            val l =Intent(this@Credits,Linkedin::class.java)
            startActivity(l)
        }
        insta_icon.setOnClickListener(){
            val i =Intent(this@Credits,Insta::class.java)
            startActivity(i)
        }

    }
}