package com.example.desafio1dsm_l

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etNombre = findViewById<EditText>(R.id.etNombreEstudiante)
        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val etNota3 = findViewById<EditText>(R.id.etNota3)
        val etNota4 = findViewById<EditText>(R.id.etNota4)
        val etNota5 = findViewById<EditText>(R.id.etNota5)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularPromedio)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoPromedio)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val str1 = etNota1.text.toString().trim()
            val str2 = etNota2.text.toString().trim()
            val str3 = etNota3.text.toString().trim()
            val str4 = etNota4.text.toString().trim()
            val str5 = etNota5.text.toString().trim()

            // 1. EN ESTE APARTADO Validamos los campos Vacíos
            if (nombre.isEmpty() || str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty() || str5.isEmpty()) {
                Toast.makeText(this, "Por Favor Completa Todos Los Campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val n1 = str1.toDoubleOrNull()
            val n2 = str2.toDoubleOrNull()
            val n3 = str3.toDoubleOrNull()
            val n4 = str4.toDoubleOrNull()
            val n5 = str5.toDoubleOrNull()

            if (n1 == null || n2 == null || n3 == null || n4 == null || n5 == null) {
                Toast.makeText(this, "Ingresa Notas Válidas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Validar rango de notas (0.00 a 10.00)
            if (n1 !in 0.0..10.0 || n2 !in 0.0..10.0 || n3 !in 0.0..10.0 || n4 !in 0.0..10.0 || n5 !in 0.0..10.0) {
                Toast.makeText(this, "Las Notas Deben Estar Entre 0.00 y 10.00", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. Cálculo del promedio ponderado (20% cada nota)
            val promedio = (n1 * 0.20) + (n2 * 0.20) + (n3 * 0.20) + (n4 * 0.20) + (n5 * 0.20)
            val estado = if (promedio >= 6.0) "APROBADO" else "REPROBADO"

            // 4. Mostrar resultado
            val resultadoTexto = "Estudiante: $nombre\n" +
                    "Promedio Final: ${String.format("%.2f", promedio)}\n" +
                    "Estado: $estado"

            tvResultado.text = resultadoTexto
        }
    }
}