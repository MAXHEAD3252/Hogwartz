package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_milk_home_page.*

class Milk_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_milk_home_page)
        supportActionBar?.hide()

        milkmanager_logout.setOnClickListener(){
            val o =Intent(this@Milk_home_page,Login_page::class.java)
            startActivity(o)
        }

        card_users_milkmanager.setOnClickListener(){
            val j =Intent(this@Milk_home_page,User_list::class.java)
            startActivity(j)
        }
    }

    // for the back press
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@Milk_home_page,"Please press twice to logout", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }

}