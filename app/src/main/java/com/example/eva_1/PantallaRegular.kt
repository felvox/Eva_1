    package com.example.eva_1

    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import android.content.Intent

    class PantallaRegular : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pantalla_regular)

            val salarioBrutoEditText = findViewById<EditText>(R.id.salarioBrutoEditText)
            val calcularButton = findViewById<Button>(R.id.calcularButton)
            val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
            val volverButton = findViewById<Button>(R.id.volverButton)

            calcularButton.setOnClickListener {
                val salarioBruto = salarioBrutoEditText.text.toString().toDoubleOrNull() ?: 0.0
                val salarioNeto = calcularSalarioNetoRegular(salarioBruto)
                resultadoTextView.text = getString(R.string.salario_neto_resultado, salarioNeto)
            }

            volverButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        private fun calcularSalarioNetoRegular(salarioBruto: Double): Double {
            val porcentajeRetencion = 0.20 // 20% para empleados regulares
            return salarioBruto * (1 - porcentajeRetencion)
        }
    }
