package pe.com.kotlin.appmovil_fast_food

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var fullnameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullnameEditText = findViewById(R.id.et_fullname)
        emailEditText = findViewById(R.id.et_email)
        usernameEditText = findViewById(R.id.et_username)
        passwordEditText = findViewById(R.id.et_password)
        confirmPasswordEditText = findViewById(R.id.et_confirm_password)

        val registerButton = findViewById<Button>(R.id.btn_register)

        registerButton.setOnClickListener {
            val fullname = fullnameEditText.text.toString()
            val email = emailEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            val login = findViewById<TextView>(R.id.tv_have_account)
            login.text = Html.fromHtml(getString(R.string.login_have_account))
            login.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            if (fullname.isBlank() && email.isBlank() && username.isBlank() && password.isBlank()
                && confirmPassword.isBlank()) {
                showError("Rellene todos los campos")
                return@setOnClickListener
            }


            if (fullname.any { it.isDigit() }) {
                showError("El nombre completo no debe contener números")
                fullnameEditText.requestFocus()
                return@setOnClickListener
            }

            if (!email.contains("@") || !email.endsWith(".com")) {
                showError("El correo electrónico no es válido")
                emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (!username.matches(Regex("[a-zA-Z0-9]+")) || username.length > 8) {
                showError("El nombre de usuario debe tener hasta 8 caracteres")
                usernameEditText.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                showError("Las contraseñas no coinciden")
                passwordEditText.requestFocus()
                return@setOnClickListener
            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        }
    }

    private fun showError(message: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Error")
        dialog.setMessage(message)
        dialog.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }
}
