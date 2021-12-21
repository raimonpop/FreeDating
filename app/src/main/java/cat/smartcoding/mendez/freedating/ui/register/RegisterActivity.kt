package cat.smartcoding.mendez.freedating.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import cat.smartcoding.mendez.freedating.R
import cat.smartcoding.mendez.freedating.databinding.ActivityRegisterBinding
import com.google.android.material.navigation.NavigationView

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

     supportFragmentManager.beginTransaction().replace(R.id.content_regist, RegisterDateFragment()).commit()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val navController = findNavController(R.id.registerDateFragment)
        navController.navigateUp()

        return super.onOptionsItemSelected(item)
    }
}