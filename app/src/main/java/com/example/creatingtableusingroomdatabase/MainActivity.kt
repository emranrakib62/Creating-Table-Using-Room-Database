package com.example.creatingtableusingroomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user = User(0, "Rakib", 32, "01862240062")


        var userDao = UserDatabase.getInstance(this)
            .getUserDao()

        binding.insertbutn.setOnClickListener {
           startActivity(Intent(this@MainActivity,CreateActivity::class.java))

            //userDao.userInsert(user)

        }
binding.getallbutn.setOnClickListener {
    var userList:List<User> = userDao.getAllUser()
    userList.forEach{
        Log.i("tag","${it.userid}:${it.name}\n")
    }
}




    }
} 