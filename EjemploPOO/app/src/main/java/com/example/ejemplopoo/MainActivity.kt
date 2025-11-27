package com.example.ejemplopoo

import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var mispinner: Spinner
    var tipos_vehiculos=arrayOf("Camion", "Moto", "Auto")

    fun simularConduccion(v:Conducible){
        //Invocar a arrancar
        v.arrancar()
        //Si el objeto v es Vehiculo
        if (v is Vehiculo) v.acelerar()
        //Invocar a detener
        v.detener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mispinner=findViewById<Spinner>(R.id.spinner)
        findViewById<Button>(R.id.button).setOnClickListener {
            lateinit var mivehiculo: Vehiculo
            //averiguar que elemento hay seleccionmado en el spinner
            when(mispinner.selectedItem.toString()){

                "Camion"->//instancio el objeto de la clase camion
                    mivehiculo= Camion("Scania", "XT", 2010, 150, 10.0)
                "Moto" ->
                    mivehiculo= Motocicleta("Kawasaki","Ninja",2018,220)
                    "Auto"->
                        mivehiculo= Auto("Ford","Focus",2005,180,5)
            }
        //mostrar en un alertdialog todos los mensajes que se generan con la invocacion de los metodos acelerar
            //arrancar, detener
            var builderDialog= AlertDialog.Builder(this)
            builderDialog.apply {
                setTitle(mispinner.selectedItem.toString())
                setMessage("${mivehiculo.arrancar()} ${mivehiculo.acelerar()} ${mivehiculo.detener()}")
                setPositiveButton("Aceptar",{
                    d,which -> if (which== DialogInterface.BUTTON_POSITIVE)
                    d.dismiss()
                })
            }
            //muestro el alert dialog
            builderDialog.create().show()
            /* Se puede hacer asi mas facil
            builderDialog.setTitle("sadasd")
            builderDialog.setMessage("adas")*/
        }
        configurar_spinner()
    }
    private fun configurar_spinner() {
        //definir adaptador que define los datos que se muestran en el spinner y  la apariencia
        var miadaptador= ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
            tipos_vehiculos)
        //defino la vista que va a etener el spinner cuandos e despliega
        miadaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //asigno al spinner el adaptador
        mispinner.adapter=miadaptador

    }
}



