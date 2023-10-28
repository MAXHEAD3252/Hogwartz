package com.example.hogwartz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( private val UserList : ArrayList<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = UserList[position]

        holder.name_user.text = currentItem.name
        holder.gender_user.text = currentItem.gender
        holder.age_user.text = currentItem.age.toString()
        holder.mobileno_user.text = currentItem.mobileno
        holder.roomno_user.text = currentItem.roomno.toString()
        holder.email_user.text = currentItem.email
        holder.uid_user.text = currentItem.uid



    }

    override fun getItemCount(): Int {

        return UserList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name_user : TextView = itemView.findViewById<TextView>(R.id.name_useritem)
        val gender_user : TextView = itemView.findViewById<TextView>(R.id.gender_useritem)
        val age_user : TextView = itemView.findViewById<TextView>(R.id.age_useritem)
        val mobileno_user : TextView = itemView.findViewById<TextView>(R.id.mobileno_useritem)
        val roomno_user : TextView = itemView.findViewById<TextView>(R.id.roomno_useritem)
        val email_user : TextView = itemView.findViewById<TextView>(R.id.email_useritem)
        val uid_user : TextView = itemView.findViewById<TextView> (R.id.uid_useritem)



    }











}