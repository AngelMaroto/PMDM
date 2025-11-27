package com.example.cuestionario


enum class Dificultad{BAJA,MEDIA,ALTA}
data class PreguntaTexto (val text: String, val respueta: String,val dificultad: Dificultad)
data class  PreguntaTrueFalse(val textopregunta: String, val respueta: Boolean, val dificultad: Dificultad)
data class PreguntaAritmetica(val textopregunta: String, val respueta: Int, val dificultad: Dificultad)

//clñase generica que negloba a todas las anteriores
data class Pregunta<T>(val text: String, val respueta: T,val dificultad: Dificultad)