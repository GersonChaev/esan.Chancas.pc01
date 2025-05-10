package dev.gersonchaev.esanchancaspc01.Presentacion.Conversor

import java.text.DecimalFormat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ConversorScreen() {
    var monto by remember { mutableStateOf("") }
    var tipoConversion by remember { mutableStateOf(ConversionType.USD_TO_PEN) }
    var resultado by remember { mutableStateOf<String?>(null) }

    val tasaFija = 3.80

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Conversor de Divisas")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto a convertir") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = tipoConversion == ConversionType.USD_TO_PEN,
                    onClick = { tipoConversion = ConversionType.USD_TO_PEN }
                )
                Text(text = "USD a PEN")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = tipoConversion == ConversionType.PEN_TO_USD,
                    onClick = { tipoConversion = ConversionType.PEN_TO_USD }
                )
                Text(text = "PEN a USD")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val montoNumerico = monto.toDoubleOrNull()
                if (montoNumerico != null) {
                    val formatter = DecimalFormat("#,##0.00")
                    resultado = when (tipoConversion) {
                        ConversionType.USD_TO_PEN -> {
                            val conversion = montoNumerico * tasaFija
                            "${formatter.format(conversion)} PEN"
                        }
                        ConversionType.PEN_TO_USD -> {
                            val conversion = montoNumerico / tasaFija
                        }
                    }
                } else {
                    resultado = "Ingrese un monto válido"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        resultado?.let {
            Text(text = "Resultado: $it")
        }
    }
}

enum class ConversionType {
    USD_TO_PEN,
    PEN_TO_USD
}
