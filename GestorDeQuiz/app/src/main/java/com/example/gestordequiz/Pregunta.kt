package com.example.gestordequiz

enum class Dificultad {
    FACIL, MEDIA, DIFICIL
}

data class Pregunta(
    val enunciado: String,
    val respuestas: List<String>,
    val indiceRespuestaCorrecta: Int,
    val dificultad: Dificultad
)

val preguntas = mutableListOf(
    Pregunta(
        "Jugador español con mas temporadas NBA",
        listOf("Pau Gasol", "Marc Gasol", "Ricky Rubio"),
        0,
        Dificultad.DIFICIL
    ),
    Pregunta(
        "Jugador con mas anillos",
        listOf("Michael Jordan", "Kobe Bryant", "Bill Russel"),
        2,
        Dificultad.MEDIA
    ),
    Pregunta(
        "Maximo anotador historico NBA",
        listOf("Karim Abdull Jabbar", "Lebron James", "Michael Jordan"),
        1,
        Dificultad.FACIL
    ),


)
