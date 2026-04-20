package com.grupo.notasapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.grupo.notasapp.screens.BienvenidaScreen
import com.grupo.notasapp.screens.LoginScreen
import com.grupo.notasapp.screens.NotasScreen
import com.grupo.notasapp.screens.ResultadoScreen

// Rutas de navegación
object Rutas {
    const val LOGIN = "login"
    const val BIENVENIDA = "bienvenida/{correo}"
    const val NOTAS = "notas/{correo}"
    const val RESULTADO = "resultado/{promedio}"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN
    ) {
        // Pantalla Login
        composable(Rutas.LOGIN) {
            LoginScreen(
                onLoginExitoso = { correo ->
                    navController.navigate("bienvenida/$correo")
                }
            )
        }

        // Pantalla Bienvenida
        composable(
            route = Rutas.BIENVENIDA,
            arguments = listOf(navArgument("correo") { type = NavType.StringType })
        ) { backStackEntry ->
            val correo = backStackEntry.arguments?.getString("correo") ?: ""
            BienvenidaScreen(
                correo = correo,
                onContinuar = {
                    navController.navigate("notas/$correo")
                }
            )
        }

        // Pantalla Notas
        composable(
            route = Rutas.NOTAS,
            arguments = listOf(navArgument("correo") { type = NavType.StringType })
        ) { backStackEntry ->
            val correo = backStackEntry.arguments?.getString("correo") ?: ""
            NotasScreen(
                correo = correo,
                onCalcular = { promedio ->
                    navController.navigate("resultado/$promedio")
                }
            )
        }

        // Pantalla Resultado
        composable(
            route = Rutas.RESULTADO,
            arguments = listOf(navArgument("promedio") { type = NavType.FloatType })
        ) { backStackEntry ->
            val promedio = backStackEntry.arguments?.getFloat("promedio") ?: 0f
            ResultadoScreen(
                promedio = promedio,
                onVolverANotas = {
                    navController.popBackStack("notas/{correo}", inclusive = false)
                },
                onCerrarSesion = {
                    navController.navigate(Rutas.LOGIN) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}