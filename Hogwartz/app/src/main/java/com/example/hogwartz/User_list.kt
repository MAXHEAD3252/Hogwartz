package com.example.hogwartz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_user_list.*
import kotlinx.android.synthetic.main.user_item.*

class User_list : AppCompatActivity() {


    private lateinit var mDbRef : DatabaseReference

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Data>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)


        userRecyclerView = findViewById(R.id.userlist_recyclerview)

        userRecyclerView.layoutManager = LinearLayoutManager(this )
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<Data>()
        getUserData()


    }

    private fun getUserData() {
        mDbRef = FirebaseDatabase.getInstance().getReference("Users")

        mDbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(usersnapshot in snapshot.children) {

                        val user = usersnapshot.getValue(Data::class.java)
                        /*  if(!userArrayList.contains(user))
                        {userArrayList.add(user!!)}

                    */
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter = MyAdapter(userArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@User_list,"unable to get data",Toast.LENGTH_SHORT).show()
            }
        })


    }
}
