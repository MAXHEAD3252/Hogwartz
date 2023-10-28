package com.example.hogwartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ActionMenuView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // action bar toggle variable
    lateinit var toggle :ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gotoprofile.setOnClickListener(){
            val gotoprofile = Intent(this@MainActivity,Profile_page::class.java)
            startActivity(gotoprofile)
        }
        card_food_usermain.setOnClickListener(){
            val q = Intent(this@MainActivity,Food::class.java)
            startActivity(q)
        }
        card_maid_usermain.setOnClickListener(){
            val h = Intent(this@MainActivity,Maid::class.java)
            startActivity(h)
        }
        card_laundry_usermain.setOnClickListener(){
            val l = Intent(this@MainActivity,Laundry::class.java)
            startActivity(l)
        }
        card_help_usermain.setOnClickListener(){
            val h = Intent(this@MainActivity,Help::class.java)
            startActivity(h)
        }
        card_newspaper_usermain.setOnClickListener(){
            val u =Intent(this@MainActivity,Newspaper::class.java)
            startActivity(u)
        }
        card_milk_usermain.setOnClickListener(){

            val y = Intent(this@MainActivity,Milk::class.java)
            startActivity(y)
        }

        //-----------------------------------------------------------------------------

        // for the navigation bar
        val drawerLayout :DrawerLayout = findViewById(R.id.drawerlayout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        toggle= ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {
            val v  = Intent(this@MainActivity,Credits::class.java)
            val g = Intent(this@MainActivity,Login_page::class.java)
            when(it.itemId){
                R.id.nav_logout -> startActivity(g)
                R.id.nav_credits ->startActivity(v)
            }
            true
        }
    }
    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    //------------------------------------------------------------------------------
    // for the back press
    //
    var counter: Int =0
    override fun onBackPressed() {
        counter++
        if(counter==1) {
            Toast.makeText(this@MainActivity,"Please press twice to logout",Toast.LENGTH_SHORT).show()
        }else{
            val i = Intent(this@MainActivity,Login_page::class.java)
            startActivity(i)
        }
    }
}