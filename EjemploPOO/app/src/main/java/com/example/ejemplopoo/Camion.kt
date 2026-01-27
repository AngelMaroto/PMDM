package com.example.ejemplopoo

class Camion (mar: String, mod: String, an:Int, vel_max:Int, var capacidadCarga: Double): Vehiculo(mar,
    mod,an,vel_max) {

    //constructor secundario para inicializar capacidad de carga
    constructor(capCarga: Double):this("","",0,0,capCarga){

    }
    override fun acelerar()="El auto $marca esta acelerando"+
            "con una carga de $capacidadCarga"
}