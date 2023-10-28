package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_laundry_home_page.*

class Laundry_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laundry_home_page)
        supportActionBar?.hide()

        maidmanager_logout.setOnClickListener(){
            val x = Intent(this@Laundry_home_page,Login_page::class.java)
            startActivity(x)
        }

        card_users_maidmanager.setOnClickListener(){

            val b= Intent(this@Laundry_home_page,User_list::class.java)
            startActivity(b)
        }

    }


    // for the back press
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@Laundry_home_page,"Please press twice to logout", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }
}