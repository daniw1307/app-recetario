package com.example.recetario.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recetario.ui.viewmodel.RecetasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleRecetaScreen(
    recetaId: Int,
    viewModel: RecetasViewModel
) {
    val receta = viewModel.obtenerRecetaPorId(recetaId)

    Scaffold(
        topBar = { TopAppBar(title = { Text("🍽️ Detalle de Receta") }) }
    ) { paddingValues ->
        if (receta != null) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = receta.nombre,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "📝 Descripción:",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = receta.descripcion)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🥕 Ingredientes:",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = receta.ingredientes)
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = "❌ Receta no encontrada",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}