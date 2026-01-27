package com.example.pruebaskotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {


    private fun anagrama(cad1:String, cad2:String): Boolean{

        //cad1 es la que recorro
        // declaro una cadena resultado que inicialmente es cad2
        var cadena_resultado=cad2
        //declaro otra variable que me diga si la cadena es anagrama o no
        var es_anagrama=true
        var i=0
        if (cad1.length!=cad2.length){

            es_anagrama=false

        }
        //recorro la cad1 buscando el caracter en la cad_resul
        //si existe el caracter lo elimino de la cad_reul
        //si no existe salgo del bucle
        while (es_anagrama && i<cad1.length){

            //comprobar si el caracter de la posicion de cad1 esta en cadena_resultado
            if(cadena_resultado.contains(cad1.get(i))){

               cadena_resultado = cadena_resultado.replaceFirst(cad1.get(i).toString(),"",true)

            }else{

                es_anagrama=false

            }
            i++
        }
        return es_anagrama
    }



    override fun onCreate(savedInstanceState: Bundle?) {


        var mifuncion:(v1:Int,v2:Int)->Int={a,b->

            a+b}

        mifuncion(4,7)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun Array<String>.add(i: Int) {
    TODO("Not yet implemented")
}
