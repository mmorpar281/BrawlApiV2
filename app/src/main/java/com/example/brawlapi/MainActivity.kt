package com.example.brawlapi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        val btn = findViewById<Button>(R.id.btn)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        btn.setOnClickListener{
            if(etNombre.text.isEmpty()){
                Toast.makeText(this, "Error: Se necesita informacion en el editext", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, CreditActivity::class.java)
                intent.putExtra("NAME", etNombre.text.toString())
                startActivity(intent)
            }
        }
    }
}