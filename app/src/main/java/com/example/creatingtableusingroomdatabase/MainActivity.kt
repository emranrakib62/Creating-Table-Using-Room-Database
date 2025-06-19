import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.creatingtableusingroomdatabase.User
import com.example.creatingtableusingroomdatabase.UserDatabase
import com.example.creatingtableusingroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDao = UserDatabase.getInstance(this).getUserDao()

        binding.insertbutn.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            val mobile = binding.etMobile.text.toString()

            if (name.isNotEmpty() && mobile.isNotEmpty()) {
                val user = User(0, name, age, mobile)
                userDao.userInsert(user)
            }
        }
    }
}
