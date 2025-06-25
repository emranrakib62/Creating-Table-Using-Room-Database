package com.example.creatingtableusingroomdatabase

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,UserclickLisener{

    lateinit var binding: ActivityMainBinding
    lateinit var userList:List<User>
    lateinit var  userDao:UserDao
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
        var mainActivity:UserclickLisener=MainActivity()
        var userAdapter=UserAdapter(mainActivity)

binding.UserRcv.adapter=userAdapter


        userDao = UserDatabase.getInstance(this)
            .getUserDao()
        userList=userDao.getAllUser()

        userAdapter.submitList(userList)

    }

    override fun userDelete(user: User) {
Log .i("TAG","UserDelete:  ${user.userid}")
userDao.userDelete(user)
    //Toast.makeText(this@MainActivity,"delete Clicked",Toast.LENGTH_LONG).show()

    }

    override fun userUpdate(user: User) {
        var intent =Intent(this,CreateActivity::class.java)
        intent.putExtra("key","value")


        //Toast.makeText(this@MainActivity,"update Clicked",Toast.LENGTH_LONG).show()
        Log .i("TAG","UserUpdate:  ${user.userid}")
    }
    }


