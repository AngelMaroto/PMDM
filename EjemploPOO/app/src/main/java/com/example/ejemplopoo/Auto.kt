package com.example.ejemplopoo

class Auto(mar: String, mod: String, an:Int, vel_max:Int,var numpuertas: Int): Vehiculo(mar,
    mod,an,vel_max) {

    override fun acelerar()="El auto $marca esta acelerando"

}