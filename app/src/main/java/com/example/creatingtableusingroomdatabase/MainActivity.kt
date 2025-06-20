package com.example.creatingtableusingroomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var userList:List<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.insertbutn.setOnClickListener {
           startActivity(Intent(this@MainActivity,CreateActivity::class.java))



        }

    }

    override fun onResume() {

        var userDao = UserDatabase.getInstance(this)
            .getUserDao()
        userList=userDao.getAllUser()

        super.onResume()
    }


} 