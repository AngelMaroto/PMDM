package com.example.gestordequiz

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gestordequiz.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mostrarPregunta()
        Boton()
    }
    var indiceActual = Random.nextInt(0,preguntas.size);

    var puntuacion = 0

    val mostrarPregunta={
        val pregunta = preguntas[indiceActual]
        mibinding.pregunta.setText(pregunta.enunciado)

        mibinding.opcion1.setText(pregunta.respuestas[0])
        mibinding.opcion2.setText(pregunta.respuestas[1])
        mibinding.opcion3.setText(pregunta.respuestas[2])
        mibinding.radiogroup.clearCheck()
    }
    private fun Boton(){
        mibinding.Siguiente.setOnClickListener {
            comprobarPregunta()
            if (puntuacion==3){
                mostrarPuntuacion()
                mibinding.Siguiente.isEnabled=false
            }else{

            indiceActual = Random.nextInt(0,preguntas.size)
            mostrarPregunta()
            }
        }
    }
    val comprobarPregunta={
        var seleccionado = mibinding.radiogroup.checkedRadioButtonId
        if (seleccionado !=-1){
            val pregunta = preguntas[indiceActual]
            val indiceSeleccionado = when(seleccionado){
                mibinding.opcion1.id -> 0
                mibinding.opcion2.id -> 1
                mibinding.opcion3.id -> 2
                else -> -1
            }
            if (indiceSeleccionado == pregunta.indiceRespuestaCorrecta){
                puntuacion++
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            } else{
                puntuacion--
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        } else{
            Toast.makeText(this, "no hay nada seleccionado", Toast.LENGTH_SHORT).show()
        }
    }


    private fun mostrarPuntuacion(){
            Toast.makeText(this, "Has Ganado, Puntuacion final: $puntuacion", Toast.LENGTH_SHORT).show()
    }
}