package com.example.enumcolor

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView
import org.w3c.dom.Text
import kotlin.toString

//defino una clase que implementa la interace que gestiona el evento
//de seleccionar un elemento en el spinner
class  EscuchadorSpinner: AdapterView.OnItemSelectedListener {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        //aqui se pone el codigo que queremos que s ejecute cuando se cambia un elemento de l spinner
        (parent?.parent as View).setBackgroundColor(((parent as Spinner).selectedItem as Colores).retornar_Color())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}


enum class Colores {ROJO,VERDE,AZUL,NEGRO;
    @RequiresApi(Build.VERSION_CODES.O)
    fun retornar_Color(): Int{
        var micolor:Int
        when(this){
            ROJO-> micolor=(Color.RED)
            AZUL-> micolor=(Color.BLUE)
            VERDE-> micolor=(Color.GREEN)
            NEGRO-> micolor=(Color.BLACK)
        }
        return micolor
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var mispinner: Spinner
    lateinit var mispinner2: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


       configurar_spinner()

        }
    private fun configurar_spinner() {
        this.mispinner=findViewById<Spinner>(R.id.spinner)
        this.mispinner2=findViewById<Spinner>(R.id.spinner2)

        var miadaptador2= ArrayAdapter<Float>(this, android.R.layout.simple_spinner_item, arrayOf(12f,18f,28f,48f))

        miadaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mispinner2.adapter=miadaptador2
        //definir el comportamiento
        mispinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                findViewById<TextView>(R.id.textView).textSize= (parent as Spinner).selectedItem as Float
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        //definir adaptador que define los datos que se muestran en el spinner y  la apariencia
        var miadaptador= ArrayAdapter<Colores>(this, android.R.layout.simple_spinner_item,
            Colores.values())
        //defino la vista que va a etener el spinner cuandos e despliega
        miadaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //asigno al spinner el adaptador
        mispinner.adapter=miadaptador

        var escuchador: EscuchadorSpinner= EscuchadorSpinner()
        //configuro el elemento de seleccionar un elemento en el spinner
        mispinner.onItemSelectedListener= escuchador
    }
}
