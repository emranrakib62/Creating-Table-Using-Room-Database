package com.example.creatingtableusingroomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,UserclickLisener{

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
        super.onResume()
        var userAdapter=UserAdapter()

binding.UserRcv.adapter=userAdapter


        var userDao = UserDatabase.getInstance(this)
            .getUserDao()
        userList=userDao.getAllUser()

        userAdapter.submitList(userList)

    }

    override fun userDelete(user: User) {
        TODO("Not yet implemented")
    }

    override fun userUpdate(user: User) {
        TODO("Not yet implemented")
    }


} 