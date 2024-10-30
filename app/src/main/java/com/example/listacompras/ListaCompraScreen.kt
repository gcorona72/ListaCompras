package com.example.listacompras

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ListaCompraScreen(viewModel: ListaCompraViewModel) {
    var nombre by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Inputs para el nombre, cantidad y precio
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio Aproximado") },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal)
        )

        // Botón para agregar el producto
        Button(
            onClick = {
                viewModel.agregarProducto(
                    nombre,
                    cantidad.toIntOrNull(),
                    precio.toDoubleOrNull()
                )
                nombre = ""
                cantidad = ""
                precio = ""
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Agregar Producto")
        }

        // Mostrar total de productos y precio acumulado
        Text(
            text = "Total de productos: ${viewModel.totalProductos}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Precio total: $${viewModel.precioTotal}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Lista de productos
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(viewModel.productos) { producto ->
                Text(text = "${producto.nombre} - Cantidad: ${producto.cantidad} - Precio: $${producto.precio}")
            }
        }
    }
}
