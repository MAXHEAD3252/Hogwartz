package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_food_home_page.*

class Food_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_home_page)
        supportActionBar?.hide()

        foodmanager_logout.setOnClickListener(){
            val b = Intent(this@Food_home_page,Login_page::class.java)
            startActivity(b)
        }
        card_users_foodmanager.setOnClickListener(){

            val x = Intent(this@Food_home_page,User_list::class.java)
            startActivity(x)

        }
    }



    // for the back press
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@Food_home_page,"Please press twice to logout", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }


}