package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.holamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //creo el objeto binding
    private lateinit var mibinding: ActivityMainBinding

    //con binding no es necesario declarar lo siguiente
    private lateinit var miboton: Button
    private lateinit var edit_text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        //Invocacion metodo clase padre
        super.onCreate(savedInstanceState)
        //asignar valor al objeto m ibinding
        mibinding= ActivityMainBinding.inflate(layoutInflater)
        //extiende mi aplicacion a toda la pantalla
        enableEdgeToEdge()


        //establecer que interfaz visual (layout) tiene esta actividad
        setContentView(mibinding.root)//R.layout.activity_main


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inicializarComponentes()
    }

    private fun inicializarComponentes() {
       //en esta funcion/metodo inicializo los componentes visuales
        //Vinculo mi boton con el boyon del layout
        this.miboton=findViewById<Button>(R.id.button)
        //vinculo mi edittext
        this.edit_text=findViewById<EditText>(R.id.editTextText)

        //definir codigo al boton

        this.miboton.setOnClickListener {

            var mitoast:Toast

            mitoast = Toast.makeText(this, edit_text.text, Toast.LENGTH_SHORT)

            mitoast.show()
        }
        //con binding
        mibinding.button.setOnClickListener {

            Toast.makeText(this, mibinding.editTextText.text, Toast.LENGTH_SHORT).show()
        }
    }
}