package com.example.pagina65ej2


import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Función de extensión para EditText (ya la tienes)


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)

        // Usar la función de extensión
        editText.despues_cambio_texto { texto ->
            val guiones = "_".repeat(texto.length)
            textView.text = guiones
        }
    }
}
