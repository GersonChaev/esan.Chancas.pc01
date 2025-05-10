package dev.gersonchaev.esanchancaspc01.Presentacion.Calculadora

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraScreen() {
    var edadHumana by remember { mutableStateOf("") }
    var tamanoPerro by remember { mutableStateOf("Pequeño") }
    var edadPerro by remember { mutableStateOf<Int?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Pantalla 1: Calculadora de Edad Canina", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = edadHumana,
            onValueChange = { edadHumana = it },
            label = { Text("Edad del perro (en años humanos)") },
            //keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number)
        )

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text("Tamaño: $tamanoPerro")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Pequeño") },
                    onClick = {
                        tamanoPerro = "Pequeño"
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Mediano") },
                    onClick = {
                        tamanoPerro = "Mediano"
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Grande") },
                    onClick = {
                        tamanoPerro = "Grande"
                        expanded = false
                    }
                )
            }
        }

        Button(onClick = {
            val edadInt = edadHumana.toIntOrNull()
            if (edadInt != null && edadInt > 0) {
                edadPerro = when (tamanoPerro) {
                    "Pequeño" -> edadInt * 5
                    "Mediano" -> edadInt * 6
                    "Grande" -> edadInt * 7
                    else -> null
                }
                errorMessage = null
            } else {
                errorMessage = "Por favor, ingresa una edad válida (número positivo)."
                edadPerro = null
            }
        }) {
            Text("Calcular Edad Canina")
        }

        if (edadPerro != null) {
            Text("¡Tu perro tiene ${edadPerro} años en años perro! ¡Qué energía!")
        }

        if (errorMessage != null) {
            Text(errorMessage!!, color = MaterialTheme.colorScheme.error)
        }
    }
}