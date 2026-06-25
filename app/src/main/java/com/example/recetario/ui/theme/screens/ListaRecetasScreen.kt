package com.example.recetario.ui.screens  // 👈 Asegurate que sea ui.screens, NO ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable  // 👈 Importante!
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.recetario.ui.viewmodel.RecetasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaRecetasScreen(
    navController: NavController,
    viewModel: RecetasViewModel = viewModel()
) {
    val recetas by viewModel.recetas.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("📖 Mi Recetario") }) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recetas) { receta ->
                Card(
                    onClick = {
                        viewModel.seleccionarReceta(receta.id)
                        navController.navigate("detail/${receta.id}")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = receta.nombre,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}