package com.example.probandofold

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //creamos la funcion de altoi nivel fold
    //es una funcion de extension

    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        //declaro un lista
        var milista=listOf<Int>(1,2,3,4,5)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //defino objeto button para vincularlo con mi boton
        var miboton=findViewById<Button>(R.id.button)

        //defino escuhcado al hcaer clic

        miboton.setOnClickListener {
            //invoco a la funcion fold, con un lambda que sume los valores
            //de la lista y mostramos el resultado en el textview

           var resultado = milista.fold(3,{i:Int, j:Int->
                Log.i("Informacion","valore de i=$i y valor de y=$j")
                i+j
            })

            findViewById<TextView>(R.id.textView).text="El resultado es $resultado"

        }
    }
}