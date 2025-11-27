package com.example.funcionesextension

class Funciones {
    companion object fun contar_caracter(cadena:String, c: Char): Int{
        var cont=0
        for(a in cadena){
            if (a==c){
                cont++
            }
        }
        return cont
    }
}