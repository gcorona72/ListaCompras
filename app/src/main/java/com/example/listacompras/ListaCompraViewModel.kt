package com.example.listacompras

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ListaCompraViewModel : ViewModel() {
    val productos = mutableStateListOf<Producto>()

    // Agrega un producto a la lista
    fun agregarProducto(nombre: String, cantidad: Int?, precio: Double?) {
        if (nombre.isNotBlank()) {
            productos.add(Producto(nombre, cantidad ?: 1, precio ?: 0.0))
        }
    }

    // Calcular total de productos y precio total
    val totalProductos: Int
        get() = productos.size

    val precioTotal: Double
        get() = productos.sumOf { it.precio * it.cantidad }
}
