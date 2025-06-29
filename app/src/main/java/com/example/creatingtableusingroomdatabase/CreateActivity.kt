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
    private var userID=0
    lateinit var userDao: UserDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)




        userDao=UserDatabase.getInstance(this)
            .getUserDao()


if(intent.hasExtra(id_key)){
binding.submitbutton.text= update
userID=intent.getIntExtra(id_key,0)
    binding.name.setText(intent.getStringExtra(name_key))
    binding.age.setText(intent.getStringExtra(age_key))
    binding.email.setText(intent.getStringExtra(mobile_key))
}



binding.submitbutton.setOnClickListener {

    if(binding.submitbutton.text.toString()== update){
        val name=binding.name.text.toString()
        val age=binding.age.text.toString()
        val email =binding.email.text.toString()
        val user=User(userID,name,age.toInt(),email)
        userDao.userUpdate(user)


    }else{
        val name=binding.name.text.toString()
        val age=binding.age.text.toString()
        val email =binding.email.text.toString()
        val user=User(0,name,age.toInt(),email)
        userDao.userInsert(user)
    }



}

    }
    companion object{
        const val id_key="id"
        const val name_key="name"
        const val age_key="age"
        const val update="update"
        const val mobile_key="mobile"
    }

}