package com.example.creatingtableusingroomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user = User(0, "Hasan", 32, "01862240062")
        var userDao = UserDatabase.getInstance(this).getUserDao()

        binding.insertbutn.setOnClickListener {
            userDao.userInsert(user)

        }





    }
}
