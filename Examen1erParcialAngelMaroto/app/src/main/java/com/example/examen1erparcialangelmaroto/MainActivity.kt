package com.example.examen1erparcialangelmaroto

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.examen1erparcialangelmaroto.TipoProducto.*
import com.example.examen1erparcialangelmaroto.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var mibinding: ActivityMainBinding

    //defino un mutablelist de Lista_Compra para poder almacenar todas las lsitas de la compra
    val mis_listas_compra=mutableListOf<Lista_Compra>()
    var mi_lista_compra_actual: Lista_Compra?=null

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
        inicializarComponentes()
        configurar_spinner()


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title="LISTA DE LA COMPRA"
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white, theme))
        setSupportActionBar(toolbar)

        var milista_comprea= Lista_Compra(Calendar.getInstance().time)


    }
    private fun inicializarComponentes(){
        mibinding.editFecha.setOnClickListener {
            datePicker()

            SimpleDateFormat("dd-mm-yyyy").parse()
            mis_listas_compra.find { it.fecha==mibinding.editFecha.text}
        }

        mibinding.editFecha.addTextChangedListener{
            habilitarbotonañadir()
        }

        mibinding.editImporte.addTextChangedListener{
            habilitarbotonañadir()
        }

        mibinding.editNombre.addTextChangedListener{
            habilitarbotonañadir()
        }




    }
    private fun habilitarbotonañadir(){
        if ((!mibinding.editNombre.text.isEmpty())&&!mibinding.editFecha.text.isEmpty()
            &&!mibinding.editImporte.text.isEmpty())
        {
            mibinding.btnAnadir.isEnabled=true

        }else{
            mibinding.btnAnadir.isEnabled=false

        }
    }
   /* private fun comprobarCampos(){
        var fecha = mibinding.editFecha.text
        var nombre = mibinding.editNombre.text
        var importe = mibinding.editImporte.text
        if (fecha.isEmpty() || nombre.isEmpty() ||importe.isEmpty()){
            Toast.makeText(this, "El boton añadir no se activa hasta que no rellenes los campos", Toast.LENGTH_SHORT).show()
            mibinding.btnAnadir.isEnabled=false
        }
        else{
            mibinding.btnAnadir.isEnabled=true
        }
    }*/


    private fun configurar_spinner(){
        this.spinner=findViewById<Spinner>(R.id.spinner)
        var adaptador = ArrayAdapter<TipoProducto>(this, android.R.layout.simple_spinner_item,
            TipoProducto.values())

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mibinding.spinner.adapter=adaptador
    }
    private fun datePicker(){
        // Valores por defecto del DatePicker
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val month = Calendar.getInstance().get(Calendar.MONTH)
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view, year1, monthOfYear, dayOfMonth ->
                //val dateChoice = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year1)
                mibinding.editFecha.setText("$dayOfMonth-$monthOfYear-$year1")
                //temp = dateChoice
            }, year, month, day
        )
        datePickerDialog.show()
    }
}