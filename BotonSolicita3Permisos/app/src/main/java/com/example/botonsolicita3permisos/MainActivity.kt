package com.example.botonsolicita3permisos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.botonsolicita3permisos.ui.theme.BotonSolicita3PermisosTheme
import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotonSolicita3PermisosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RequestMultiplePermissionsExample(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun RequestMultiplePermissionsExample(name: String, modifier: Modifier) {
    val context = LocalContext.current

    val multiplePermissionsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) {
        permissionsMap ->
        permissionsMap.forEach { (permission, isGranted)->
            if (isGranted){
                println("permiso concedido: $permission")
            }else {
                println("permiso denegado: $permission")
            }
        }

        val allGranted = permissionsMap.values.all{it}
        if (allGranted){
            Toast.makeText(context, "Todo aceptado", Toast.LENGTH_SHORT).show()
        }
    }

    val permissionsToRequest = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.CALL_PHONE

    )
    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {
            multiplePermissionsLauncher.launch(permissionsToRequest)
        }) {
            Text("Solicitar Permisos")
        }
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotonSolicita3PermisosTheme {
        Greeting("Android")
    }
}