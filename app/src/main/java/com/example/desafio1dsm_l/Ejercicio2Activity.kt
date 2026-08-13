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

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val etNombre = findViewById<EditText>(R.id.etNombreEmpleado)
        val etSalario = findViewById<EditText>(R.id.etSalarioBase)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularSalario)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoSalario)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar2)
        btnRegresar.setOnClickListener {
            finish()
        }

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val salarioStr = etSalario.text.toString().trim()

            if (nombre.isEmpty() || salarioStr.isEmpty()) {
                Toast.makeText(this, "Por Favor Completa Todos Los Campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val salarioBase = salarioStr.toDoubleOrNull()
            if (salarioBase == null || salarioBase <= 0) {
                Toast.makeText(this, "Ingresa un Salario Base Valido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 1. Cálculo de ISSS (3%, tope Máximo de $30.00)
            val isss = if (salarioBase * 0.03 > 30.0) 30.0 else salarioBase * 0.03

            // 2. Cálculo de AFP (7.25%)
            val afp = salarioBase * 0.0725

            // Salario Disponible sobre el Cual se Calcula La Renta
            val salarioImponible = salarioBase - isss - afp

            // 3. Cálculo de Renta (Tramos ISR El Salvador)
            var renta = 0.0
            if (salarioImponible > 472.00 && salarioImponible <= 895.24) {
                renta = ((salarioImponible - 472.00) * 0.10) + 17.67
            } else if (salarioImponible > 895.24 && salarioImponible <= 2038.10) {
                renta = ((salarioImponible - 895.24) * 0.20) + 60.00
            } else if (salarioImponible > 2038.10) {
                renta = ((salarioImponible - 2038.10) * 0.30) + 288.57
            }

            // 4. Salario Neto Final
            val totalDescuentos = isss + afp + renta
            val salarioNeto = salarioBase - totalDescuentos

            // 5. Mostrar Resultados
            val resultado = "Empleado: $nombre\n\n" +
                    "Salario Base: $${String.format("%.2f", salarioBase)}\n" +
                    "Descuento ISSS (3%): $${String.format("%.2f", isss)}\n" +
                    "Descuento AFP (7.25%): $${String.format("%.2f", afp)}\n" +
                    "Descuento Renta: $${String.format("%.2f", renta)}\n" +
                    "Total Descuentos: $${String.format("%.2f", totalDescuentos)}\n\n" +
                    "Salario Neto: $${String.format("%.2f", salarioNeto)}"

            tvResultado.text = resultado
        }
    }
}