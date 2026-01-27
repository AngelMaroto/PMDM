package com.example.ejemplopoo

abstract class Vehiculo(var marca: String, var modelo: String, var anno:Int,
                        var velocidad_max:Int): Conducible {

    override fun arrancar()= "El vehiculo $marca ha arrancado"


    override fun detener()= "el vehiculo $marca se ha detenido"

    abstract fun acelerar(): String
}