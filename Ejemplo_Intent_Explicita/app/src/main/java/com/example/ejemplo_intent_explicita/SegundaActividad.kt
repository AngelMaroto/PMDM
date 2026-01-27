package com.example.ejemplo_intent_explicita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejemplo_intent_explicita.ui.theme.Ejemplo_Intent_ExplicitaTheme

class SegundaActividad : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //obtengo la intent que abre esta seguna actividad
        val intent = intent

        val nombre = intent.getStringExtra("nombre")
        val edad=intent.getIntExtra("edad",0)
        setContent {
            Ejemplo_Intent_ExplicitaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "$nombre","$edad",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, edad:String ,modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
    Text(
        text = "Hello $name! tienes $edad",
        modifier = modifier
    )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Ejemplo_Intent_ExplicitaTheme {
        Greeting2("Android",22.toString())
    }
}