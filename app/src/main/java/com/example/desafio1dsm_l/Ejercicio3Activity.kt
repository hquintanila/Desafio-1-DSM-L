package com.example.desafio1dsm_l

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        val etNum1 = findViewById<EditText>(R.id.etNumero1)
        val etNum2 = findViewById<EditText>(R.id.etNumero2)
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMult = findViewById<Button>(R.id.btnMultiplicacion)
        val btnDiv = findViewById<Button>(R.id.btnDivision)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar3)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoCalculadora)

        // Evento para Regresar al Menú Principal (Ahora funciona desde el inicio)
        btnRegresar.setOnClickListener {
            finish()
        }

        // Función para validar e ingresar los Diferentes Datos Ingresados
        fun obtenerNumeros(): Pair<Double, Double>? {
            val str1 = etNum1.text.toString().trim()
            val str2 = etNum2.text.toString().trim()

            if (str1.isEmpty() || str2.isEmpty()) {
                Toast.makeText(this, "Por Favor Ingresa Ambos Numeros", Toast.LENGTH_SHORT).show()
                return null
            }

            val n1 = str1.toDoubleOrNull()
            val n2 = str2.toDoubleOrNull()

            if (n1 == null || n2 == null) {
                Toast.makeText(this, "Ingresa Numeros Validos", Toast.LENGTH_SHORT).show()
                return null
            }

            return Pair(n1, n2)
        }

        // Aqui tenemos el Evento Suma
        btnSuma.setOnClickListener {
            val nums = obtenerNumeros() ?: return@setOnClickListener
            val res = nums.first + nums.second
            tvResultado.text = "Resultado: ${nums.first} + ${nums.second} = $res"
        }

        // Aqui tenemos el Evento Resta
        btnResta.setOnClickListener {
            val nums = obtenerNumeros() ?: return@setOnClickListener
            val res = nums.first - nums.second
            tvResultado.text = "Resultado: ${nums.first} - ${nums.second} = $res"
        }

        // Aqui tenemos el Evento Multiplicación
        btnMult.setOnClickListener {
            val nums = obtenerNumeros() ?: return@setOnClickListener
            val res = nums.first * nums.second
            tvResultado.text = "Resultado: ${nums.first} × ${nums.second} = $res"
        }

        // Aqui tenemos el Evento División
        btnDiv.setOnClickListener {
            val nums = obtenerNumeros() ?: return@setOnClickListener
            if (nums.second == 0.0) {
                Toast.makeText(this, "No Se Puede Dividir Entre Cero", Toast.LENGTH_SHORT).show()
                tvResultado.text = "Error: División Entre Cero"
                return@setOnClickListener
            }
            val res = nums.first / nums.second
            tvResultado.text = "Resultado: ${nums.first} ÷ ${nums.second} = $res"
        }
    }
}