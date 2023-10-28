package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_edt_user.*

class Admin_edt_user : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_edt_user)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()

        remove.setOnClickListener() {
            val edtremoveuid = edt_uid_remove.text.toString()
            if (edt_uid_remove.text.toString().equals("")) {
                Toast.makeText(this@Admin_edt_user, "Please enter the uid", Toast.LENGTH_SHORT).show()
            } else {
                removeuid(edtremoveuid)
            }
        }
        backfromedituser.setOnClickListener() {
            val d = Intent(this@Admin_edt_user, Admin_home_page::class.java)
            startActivity(d)
        }
    }

    private fun removeuid(edtremoveuid: String) {
        mDbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mDbRef.child("Users").child(edtremoveuid).ref.removeValue()
                Toast.makeText(this@Admin_edt_user, "User Removed", Toast.LENGTH_SHORT).show()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user, "unable to fetch data", Toast.LENGTH_SHORT).show()
            } })
    }//remove user

}
    /*
    private fun removefood(edtremovefood: String){
        mDbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val get = mDbRef.child("Users").child(edtremovefood).ref.get()
                Toast.makeText(this@Admin_edt_user,"$get Food Request Removed", Toast.LENGTH_SHORT).show()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user,"Unable to fetch data", Toast.LENGTH_SHORT).show()
            }
        })}
    private fun removelaundry(edtremove: String){
        mDbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mDbRef.child("Users").child(edtremove).child("laundry request").ref.removeValue()
                Toast.makeText(this@Admin_edt_user,"laundry Request Removed", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user,"Unable to fetch data", Toast.LENGTH_SHORT).show()
            }
        })}
    private fun removemaid(edtremove: String){
        mDbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mDbRef.child("Users").child(edtremove).child("maid request").ref.removeValue()
                Toast.makeText(this@Admin_edt_user,"Maid Request Removed", Toast.LENGTH_SHORT).show()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user,"Unable to fetch data", Toast.LENGTH_SHORT).show()
            }
        })}

    private fun removemilk(edtremove: String){
        mDbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mDbRef.child("Users").child(edtremove).child("milk request").ref.removeValue()
                Toast.makeText(this@Admin_edt_user,"Milk Request Removed", Toast.LENGTH_SHORT).show()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user,"Unable to fetch data", Toast.LENGTH_SHORT).show()
            }
        })}
    private fun removenewspaper(edtremove: String){
        mDbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mDbRef.child("Users").child(edtremove).child("newspaper request").ref.removeValue()
                Toast.makeText(this@Admin_edt_user,"Newspaper Request Removed", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Admin_edt_user,"Unable to fetch data", Toast.LENGTH_SHORT).show()
            }
        })}
*/
