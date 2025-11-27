package com.example.ejerciciopoo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciopoo.databinding.ActivityMainBinding
import java.sql.Date
import java.time.LocalDate

class Usuario (var login: String, var password:String, var fechaNac: Date = Date.valueOf("02/02/2002"), var email: String= "holas@gm.com"){

    constructor():this("Invitado", " ")


}
class MainActivity : AppCompatActivity() {

    lateinit var mibinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class Primario(var Login: String, var Password: String, var fechaNac: Date, )
    }
}