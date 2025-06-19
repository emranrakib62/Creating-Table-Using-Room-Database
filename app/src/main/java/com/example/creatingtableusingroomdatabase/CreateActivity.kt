package com.example.creatingtableusingroomdatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.creatingtableusingroomdatabase.databinding.ActivityCreateBinding
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class CreateActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDao=UserDatabase.getInstance(this)
            .getUserDao()


binding.submitbutton.setOnClickListener {
    val name=binding.name.text.toString()
    val age=binding.age.text.toString()
    val email =binding.email.text.toString()
    val user=User(0,name,age.toInt(),email)


    userDao.userInsert(user)
}



    }
}