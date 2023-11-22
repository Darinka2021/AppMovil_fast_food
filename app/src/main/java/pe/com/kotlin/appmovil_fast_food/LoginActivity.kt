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

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.et_email)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val registrar = findViewById<TextView>(R.id.tv_havent_account)
        registrar.text = Html.fromHtml(getString(R.string.login_havent_account))
        registrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (email.isBlank() && password.isBlank()) {
                showError("Rellene todos los campos")
                return@setOnClickListener
            }

            if (email.contains(" ") || !isValidEmail(email)) {
                showError("Correo electrónico no válido")
                return@setOnClickListener
            }

            if (password.contains(" ") || password.length < 6) {
                showError("La contraseña no es válida o muy corta")
                return@setOnClickListener
            }

            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ComandaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(emailRegex.toRegex())
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
