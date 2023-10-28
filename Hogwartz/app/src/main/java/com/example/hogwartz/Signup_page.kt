package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_signup_page.*


class Signup_page : AppCompatActivity() {

    private lateinit var edt_name_signup :EditText
    private lateinit var edt_gender_signup :EditText
    private lateinit var edt_age_signup :EditText
    private lateinit var edt_mobileno_signup :EditText
    private lateinit var edt_roomno_signup :EditText
    private lateinit var edt_email_signup :EditText
    private lateinit var edt_pass_signup :EditText

    private lateinit var mAuth:FirebaseAuth
    private lateinit var mDbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        supportActionBar?.hide()

        back_signup.setOnClickListener(){
            val ba =Intent(this@Signup_page,First_page::class.java)
            startActivity(ba)
        }

        mAuth = FirebaseAuth.getInstance()

        edt_name_signup=findViewById(R.id.edt_name_signup)
        edt_gender_signup=findViewById(R.id.edt_gender_signup)
        edt_age_signup=findViewById(R.id.edt_age_signup)
        edt_mobileno_signup=findViewById(R.id.edt_mobileno_signup)
        edt_roomno_signup=findViewById(R.id.edt_room_signup)
        edt_email_signup=findViewById(R.id.edt_email_signup)
        edt_pass_signup=findViewById(R.id.edt_pass_signup)


        btn_signup.setOnClickListener(){

            if(edt_name_signup.text.toString().equals("")||edt_gender_signup.text.toString().equals("")||
                edt_age_signup.text.toString().equals("")||edt_mobileno_signup.text.toString().equals("")||
                edt_roomno_signup.text.toString().equals("")||edt_email_signup.text.toString().equals("")||
                edt_pass_signup.text.toString().equals(""))
            {
                Toast.makeText(this@Signup_page,"Please enter all fields",Toast.LENGTH_SHORT).show()
            }
            else if(edt_mobileno_signup.text.length!=10)
            {
                Toast.makeText(this@Signup_page,"Please enter valid mobile no.",Toast.LENGTH_SHORT).show()
            }
            else if(edt_roomno_signup.text.toString().toInt() in 101..150)
            {
                val name = edt_name_signup.text.toString()
                val gender = edt_gender_signup.text.toString()
                val age = edt_age_signup.text.toString().toInt()
                var mobileno = edt_mobileno_signup.text.toString()
                val roomno = edt_roomno_signup.text.toString().toInt()
                val email = edt_email_signup.text.toString()
                val pass = edt_pass_signup.text.toString()
                Signup(name, gender, age, mobileno, roomno, email, pass)
            }
            else{
                Toast.makeText(this@Signup_page,"Please enter valid room no given by admin(101 to 150)",Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun Signup(name :String,gender:String,age:Int,mobileno:String,roomno:Int,email:String,pass:String)
    {

        // logic for creating user
        mAuth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener(this@Signup_page) { task ->
                if (task.isSuccessful) {
                    addUserToDatabase(name,gender,age,mobileno,roomno,email,mAuth.currentUser?.uid!!)
                    Toast.makeText(this,"$name is registered",Toast.LENGTH_SHORT).show()
                    val log = Intent(this@Signup_page,Login_page::class.java)
                    finish()
                    startActivity(log)
                } else {
                    Toast.makeText(this@Signup_page,"Some error occured",Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(name: String,gender: String,age: Int,mobileno: String,roomno: Int,email: String,uid:String)
    {
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("Users").child(uid).setValue(User(name,gender,age,mobileno,roomno,email,uid))
    }
}