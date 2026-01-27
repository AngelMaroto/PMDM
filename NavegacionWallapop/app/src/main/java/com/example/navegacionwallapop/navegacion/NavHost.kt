package com.example.navegacionwallapop.navegacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navegacionwallapop.ui.componentes.BottomBar
import androidx.navigation.compose.composable
import com.example.navegacionwallapop.ui.pantallas.FavScreen
import com.example.navegacionwallapop.ui.pantallas.HomeScreen
import com.example.navegacionwallapop.ui.pantallas.InboxScreen
import com.example.navegacionwallapop.ui.pantallas.ProfileScreen
import com.example.navegacionwallapop.ui.pantallas.SellScreen

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    Scaffold (bottomBar = {BottomBar(navController)}){
    padding ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(padding)
        ){
            composable<Home>{
                HomeScreen()
            }
            composable<Favorite>{
                FavScreen()
            }
            composable<Sell>{
                SellScreen()
            }
            composable<Inbox>{
                InboxScreen()
            }
            composable<Profile>{
                ProfileScreen()
            }
        }

    }
}