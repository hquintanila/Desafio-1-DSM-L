package com.example.desafio1dsm_l

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
    val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
    val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)

    btnEjercicio1.setOnClickListener {
        val intent = Intent(this, Ejercicio1Activity::class.java)
        startActivity(intent)
    }

    btnEjercicio2.setOnClickListener {
        val intent = Intent(this, Ejercicio2Activity::class.java)
        startActivity(intent)
    }

    btnEjercicio3.setOnClickListener {
        val intent = Intent(this, Ejercicio3Activity::class.java)
        startActivity(intent)
    }
  }
}