package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_newspaper_home_page.*

class Newspaper_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newspaper_home_page)
        supportActionBar?.hide()

        newspapermanager_logout.setOnClickListener(){
            val s = Intent(this@Newspaper_home_page,Login_page::class.java)
            startActivity(s)
        }

        card_newspaper_usermain.setOnClickListener(){
            val v =Intent(this@Newspaper_home_page,User_list::class.java)
            startActivity(v)
        }

    }
    // for the back press
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@Newspaper_home_page,"Please press twice to logout", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }

}