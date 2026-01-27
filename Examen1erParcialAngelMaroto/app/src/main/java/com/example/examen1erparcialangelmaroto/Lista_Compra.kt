package com.example.examen1erparcialangelmaroto

import java.util.Date

class Lista_Compra(var fecha: Date): Calculable{



    private val productos_cesta = mutableListOf(
        Producto_Cesta(
            "Pan",
            TipoProducto.COMIDA,
            0.75
        ),
        Producto_Cesta(
            "Gel de ducha",
            TipoProducto.HIGIENE,
            2.75
        ),
        Producto_Cesta(
            "CocaCola",
            TipoProducto.BEBIDA,
            1.25
        ),
        Producto_Cesta(
            "Lejia",
            TipoProducto.LIMPIEZA,
            1.0
        ),
        Producto_Cesta(
            "Sarten",
            TipoProducto.OTROS,
            17.95
        ),
    )


    fun filtrar_productos_bis(filtro:(p:Producto_Cesta)-> Boolean)= productos_cesta.filter { filtro(it) }




    fun filtrar_productos(filtro:(p:Producto_Cesta)-> Boolean): List<Producto_Cesta>{


        var listaresultado=mutableListOf<Producto_Cesta>()

        productos_cesta.filter { filtro(it) }

        //lo mismo pero con foreach
        /*productos_cesta.forEach {
            if (filtro(it))
                listaresultado.add(it)
        }*/

        for (elemento in productos_cesta){
            if (filtro(elemento))
                listaresultado.add(elemento)
        }

        return listaresultado.toList()
    }




    fun Agregar_Producto (prod: Producto_Cesta) {
        productos_cesta.add(prod)
    }

    fun obtener_Productos(): MutableList<Producto_Cesta> {
        return productos_cesta
    }

    //utilizamos .tolist para hacer que la lista que devuelve no sea mutable
    fun obtenerProductoscesta()=productos_cesta.toList()

    //fun caclularTotal_bis(): Double=productos_cesta.sumOf { it.precio }

    override fun calcularTotal(): Double {
        var importe_total=0.0

       // importe_total=productos_cesta.sumOf { it.precio }

        productos_cesta.forEach {producto-> importe_total+=producto.precio }

        //for(i in productos_cesta)
        //{
       //     importe_total+=i.precio
        //}

        return importe_total
    }
}