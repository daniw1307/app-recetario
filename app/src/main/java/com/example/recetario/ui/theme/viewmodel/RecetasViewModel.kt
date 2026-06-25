package com.example.recetario.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recetario.data.Receta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecetasViewModel : ViewModel() {

    private val _recetas = MutableStateFlow(listOf(
        Receta(1, "🌮 Tacos al pastor", "Tacos estilo CDMX", "Tortilla, pastor, piña, cilantro, cebolla"),
        Receta(2, "🥗 Ensalada César", "Clásica ensalada", "Lechuga, pollo, crutones, parmesano, aderezo César"),
        Receta(3, "🍝 Pasta Alfredo", "Pasta cremosa", "Fetuccini, crema, mantequilla, queso parmesano, ajo")
    ))
    val recetas: StateFlow<List<Receta>> = _recetas

    private val _recetaSeleccionadaId = MutableStateFlow<Int?>(null)
    val recetaSeleccionadaId: StateFlow<Int?> = _recetaSeleccionadaId

    fun seleccionarReceta(id: Int) {
        viewModelScope.launch {
            _recetaSeleccionadaId.emit(id)
        }
    }

    fun obtenerRecetaPorId(id: Int): Receta? {
        return _recetas.value.find { it.id == id }
    }
}