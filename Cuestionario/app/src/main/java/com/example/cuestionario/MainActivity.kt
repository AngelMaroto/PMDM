package com.example.cuestionario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //instancio unas cuantas pregunas
        //Pregunta con respuesta string
        var mipreguntaString = Pregunta<String>("¿que se celebra el 1 de Noviembre?","nose", Dificultad.BAJA)

        //pregunta tipo boolean
        var mipreguntaBoolean = Pregunta<Boolean>("¿El 7 es numero primo?",true, Dificultad.BAJA)

        //pregunta tipo aritmetico

        var mipreguntaAritmetica = Pregunta<Int>("cuanto es 2 + 3",5, Dificultad.ALTA)
    }
}