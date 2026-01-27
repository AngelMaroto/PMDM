package com.example.intentlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.intentlogin.ui.theme.IntentLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentLoginTheme {
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
    var valortexto by remember{ mutableStateOf("") }
    var password="";
    val contexto= LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {
            Text(text = "Login", modifier=modifier)
            TextField(value = valortexto, onValueChange = {valortexto=it}, label = {Text("Introduce Login")})
            Text(text = "Password", modifier = modifier)
            OutlinedTextField(
                value = password,
                onValueChange = {password=it},
                label = {Text("Contraseña")}
            )
            Text(text = "Edad:", modifier = modifier)
            Button(onClick = {
                val intent = Intent(contexto, SegundaActivity::class.java)
                intent.putExtra("login", valortexto)

            }) { Text(text = "Enviar")}

}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntentLoginTheme {
        Greeting("Android")
    }
}