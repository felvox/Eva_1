package com.example.eva_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class PantallaHonorario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorariosUI()
        }
    }
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaHonorariosUI() {
    var salarioBruto by remember { mutableStateOf("") }
    var salarioNeto by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = salarioBruto,
            onValueChange = { salarioBruto = it },
            label = { Text("Salario Bruto") }
        )
        Button(
            onClick = { salarioNeto = calcularSalarioNetoHonorario(salarioBruto.toDoubleOrNull() ?: 0.0).toString() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Calcular")
        }
        Text("Salario Neto: $salarioNeto", modifier = Modifier.padding(top = 16.dp))
        Button(
            onClick = { contexto.startActivity(Intent(contexto, MainActivity::class.java)) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Volver")
        }
    }
}

fun calcularSalarioNetoHonorario(salarioBruto: Double): Double {
    val porcentajeRetencion = 0.13
    return salarioBruto * (1 - porcentajeRetencion)
}
