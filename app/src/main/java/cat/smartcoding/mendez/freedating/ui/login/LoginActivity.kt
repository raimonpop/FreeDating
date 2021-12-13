package cat.smartcoding.mendez.freedating.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cat.smartcoding.mendez.freedating.MainActivity
import cat.smartcoding.mendez.freedating.R
import cat.smartcoding.mendez.freedating.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val firebase = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        binding.mbIniciarSesion.setOnClickListener {
            configAuth()
        }
        
    }
    
    private fun configAuth(){
        
        var email = binding.etUsername.text.toString()
        var password = binding.etPassword.text.toString()
        
        firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener { 
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
                
        }.addOnFailureListener {
            Toast.makeText(this, "ha ocurrido algo", Toast.LENGTH_SHORT).show()

        }
    }
}