package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login_page.*

class Login_page : AppCompatActivity() {

    private lateinit var edt_email:EditText
    private lateinit var edt_pass:EditText
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        supportActionBar?.hide()


        edt_email=findViewById(R.id.edt_email_login)
        edt_pass=findViewById(R.id.edt_pass_login)

        mAuth = FirebaseAuth.getInstance()

        back_login.setOnClickListener(){
            val b = Intent(this@Login_page,First_page::class.java)
            startActivity(b)
        }

        btn_login.setOnClickListener(){


            val Email = edt_email.text.toString()
            val Password = edt_pass.text.toString()
            login(Email,Password)
        }


    }

    private fun login(Email: String, Password: String) {

        if (edt_email_login.text.toString().equals("") || edt_pass_login.text.toString()
                .equals(""))
        {
            Toast.makeText(this@Login_page, "Please Enter All Fields", Toast.LENGTH_SHORT).show()
        }
        else if (edt_email_login.text.toString()
                    .equals("admin@gmail.com") || edt_pass_login.text.toString()
                    .equals("admin123"))
            {
                val gotoadmin = Intent(this@Login_page, Admin_home_page::class.java)
                Toast.makeText(this@Login_page, "WELCOME ADMIN", Toast.LENGTH_SHORT).show()
                startActivity(gotoadmin)
            }
        else if (edt_email_login.text.toString()
                        .equals("food@gmail.com") || edt_pass_login.text.toString()
                        .equals("food123")) {
                    val s = Intent(this@Login_page, Food_home_page::class.java)
            Toast.makeText(this@Login_page, "WELCOME FOOD MANAGER", Toast.LENGTH_SHORT).show()
                    startActivity(s)
                }
        else if (edt_email_login.text.toString()
                            .equals("cleaning@gmail.com") || edt_pass_login.text.toString()
                            .equals("cleaning123")) {
                        val w = Intent(this@Login_page, Maid_home_page::class.java)
            Toast.makeText(this@Login_page, "WELCOME CLEANING MANAGER", Toast.LENGTH_SHORT).show()
                        startActivity(w)
                    }
        else if(edt_email_login.text.toString().equals("laundry@gmail.com")||edt_pass_login.text.toString()
                .equals("laundry123")){
            val n = Intent(this@Login_page,Laundry_home_page::class.java)
            Toast.makeText(this@Login_page, "WELCOME LAUNDRY MANAGER", Toast.LENGTH_SHORT).show()
            startActivity(n)
        }
        else if(edt_email_login.text.toString().equals("newspaper@gmail.com")||edt_pass_login.text.toString()
                .equals("newspaper123")){
            val w = Intent(this@Login_page,Newspaper_home_page::class.java)
            Toast.makeText(this@Login_page, "WELCOME NEWSPAPER MANAGER", Toast.LENGTH_SHORT).show()
            startActivity(w)
        }
        else if(edt_email_login.text.toString().equals("milk@gmail.com")||edt_pass_login.text.toString()
                .equals("milk123")){
            val l =Intent(this@Login_page,Milk_home_page::class.java)
            Toast.makeText(this@Login_page, "WELCOME MILK MANAGER", Toast.LENGTH_SHORT).show()
            startActivity(l)
        }
        else{
            mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val goto = Intent(this@Login_page, MainActivity::class.java)
                        Toast.makeText(this@Login_page, "WELCOME", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(goto)
                    } else {
                        Toast.makeText(
                            this@Login_page,
                            "User does not exist",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }//operation
        }//last
                }//fun

    override fun onBackPressed() {
            val i = Intent(this@Login_page,First_page::class.java)
            startActivity(i)
        }
    }//class


