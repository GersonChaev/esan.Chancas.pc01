package dev.gersonchaev.esanchancaspc01.Presentacion.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.gersonchaev.esanchancaspc01.Presentacion.Home.HomeScreen

@Composable
fun NavigationMenu() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }

    }
}