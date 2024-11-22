package com.example.brawlapi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_credit)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val nombre = intent.getStringExtra("USERNAME") ?: getString(R.string.usuar)
        val mensaje = getString(R.string.creditostitulo, R.string.usuar)
        val tvCreditos = findViewById<TextView>(R.id.tvCreditos)
        tvCreditos.text = mensaje

        val boton = findViewById<Button>(R.id.btnContact)
        boton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("tuemail@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email))
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar correo..."))
        }
    }
}