package com.pmtaller2.HenryMauricio.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Cart(navController: NavController){
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { navController.navigate("Search") }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { navController.navigate("Main") }) {
                        Icon(Icons.Filled.Home, contentDescription = "Main Screen")
                    }
                    IconButton(onClick = { navController.navigate("Cart") }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Shopping Cart")
                    }
                }
            }
        }
    ){
        padding ->
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(text = "PANTALLA DE CARRITO DE COMPRAS", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}