package com.example.ejemplo_intent_explicita

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.ejemplo_intent_explicita.ui.theme.Ejemplo_Intent_ExplicitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo_Intent_ExplicitaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val contexto=LocalContext.current
    var valorTexto by remember{ mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = valorTexto,
            onValueChange = {valorTexto=it},
            label = {Text("hola klk manito tui ere loko coño y keloke con tu loquera")})
        Button(onClick = {
        val intent = Intent(contexto, SegundaActividad::class.java)
        intent.putExtra("nombre",valorTexto)
        intent.putExtra("edad",44)
            contexto.startActivity(intent)

    }, modifier = modifier.padding(top = 16.dp)){
        Text(
            text = "abrir segunda pantalla"
        )
    }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo_Intent_ExplicitaTheme {
        Greeting("Android")
    }
}