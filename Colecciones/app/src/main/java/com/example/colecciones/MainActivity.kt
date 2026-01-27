package com.example.colecciones

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

data class Persona (var nombre:String, var edad:Int)

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

        //defino una lista inmutbale
        val milista=listOf(Persona("Juan",21), Persona("Messi",21))

        milista.forEach {
            Log.i("listas","$it")
        }

        //defino una lista mutablke
        val milistamutable: MutableList<Persona> = milista as MutableList<Persona>

        //añadir un elemento a la lista mutbale
        milistamutable.add(Persona("Si",4))

        for (a in milistamutable){}

    }
}