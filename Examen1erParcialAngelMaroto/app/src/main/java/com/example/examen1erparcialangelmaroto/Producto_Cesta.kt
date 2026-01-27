package com.example.examen1erparcialangelmaroto

data class Producto_Cesta(
    val nombre: String,
    val tipo: TipoProducto,
    val precio: Double
)

enum class TipoProducto{
     COMIDA, BEBIDA, LIMPIEZA, HIGIENE, OTROS
}
