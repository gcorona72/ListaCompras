package com.example.listacompras

data class Producto(
    val nombre: String,
    val cantidad: Int = 1,
    val precio: Double = 0.0
)
