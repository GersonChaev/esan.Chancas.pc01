package dev.gersonchaev.esanchancaspc01.Presentacion.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.padding(10.dp))

        //Boton que al darle click navege a calculadora
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Calculadora")

        Button(onClick = {
            //navController.navigate("home")
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Calculadora de Edad Canina")
        }

        Button(onClick = {
            //navController.navigate("home")
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Conversor de Divisas")
        }

        Button(onClick = {
            //navController.navigate("home")
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Catálogo de Productos Tecnológicos")
        }



    }
}