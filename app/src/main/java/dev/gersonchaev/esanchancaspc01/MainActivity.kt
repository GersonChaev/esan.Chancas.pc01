package dev.gersonchaev.esanchancaspc01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dev.gersonchaev.esanchancaspc01.Presentacion.Calculadora.CalculadoraScreen
import dev.gersonchaev.esanchancaspc01.Presentacion.Conversor.ConversorScreen
import dev.gersonchaev.esanchancaspc01.Presentacion.Home.HomeScreen
import dev.gersonchaev.esanchancaspc01.Presentacion.Navigation.NavigationMenu
import dev.gersonchaev.esanchancaspc01.ui.theme.Esanchancaspc01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Esanchancaspc01Theme {
                ConversorScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Esanchancaspc01Theme {
        Greeting("Android")
    }
}