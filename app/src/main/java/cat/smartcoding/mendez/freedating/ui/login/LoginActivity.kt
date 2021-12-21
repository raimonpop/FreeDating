package cat.smartcoding.mendez.freedating.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cat.smartcoding.mendez.freedating.MainActivity
import cat.smartcoding.mendez.freedating.R
import cat.smartcoding.mendez.freedating.databinding.ActivityLoginBinding
import cat.smartcoding.mendez.freedating.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val firebase = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        visibility(true)
        isLoged()
        binding.mbIniciarSesion.setOnClickListener {
            if(validFields()) {
                visibility(false)
                configAuth()
            }
        }

        binding.mbRegistrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isLoged(){
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null){
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            onBackPressed()
        }
    }
    
    private fun configAuth(){
        
        var email = binding.etUsername.text.toString()
        var password = binding.etPassword.text.toString()

        
        firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
        visibility(true)
            if (it.isSuccessful){

                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                onBackPressed()
            }else{
                Toast.makeText(this, "Ha ocurrido algo", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            visibility(true)
            Toast.makeText(this, "Ha ocurrido algo", Toast.LENGTH_SHORT).show()

        }
    }

    private fun validFields(): Boolean{
        var isValid = true

        if(binding.etUsername.text.isNullOrEmpty()){
            binding.etUsername.run {
                error = "Campo requerido"
                requestFocus()
            }
            isValid = false
        }else if(binding.etPassword.text.isNullOrEmpty()){
            binding.etPassword.run {
                error = "Campo requerido"
                requestFocus()
            }
            isValid = false
        }


        return isValid

    }

    private fun visibility(enable:Boolean){
        binding.mbIniciarSesion.isEnabled = enable
        binding.mbRegistrar.isEnabled = enable
        binding.llProgress.visibility = if (!enable) View.VISIBLE else View.GONE
    }

}