package com.example.ejemplopoo

class Motocicleta (mar: String, mod: String, an:Int, vel_max:Int,):
    Vehiculo(mar, mod,an,vel_max) {
    var esdeportiva: Boolean=false
        get() = field
        set(value) {
            if (marca in "Suzuki,Honda"){
                field = true
            }
            else
                field=false
        }
    override fun acelerar()="La moto $marca esta acelerando a toda velocidad"
}