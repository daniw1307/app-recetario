package com.example.recetario.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recetario.ui.screens.DetalleRecetaScreen
import com.example.recetario.ui.screens.ListaRecetasScreen
import com.example.recetario.ui.viewmodel.RecetasViewModel

@Composable
fun AppNavigation(viewModel: RecetasViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            ListaRecetasScreen(navController, viewModel)
        }

        composable(
            "detail/{recetaId}",
            arguments = listOf(navArgument("recetaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getInt("recetaId") ?: -1
            DetalleRecetaScreen(recetaId = recetaId, viewModel = viewModel)
        }
    }
}