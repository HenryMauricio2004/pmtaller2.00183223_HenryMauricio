package com.pmtaller2.HenryMauricio.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmtaller2.HenryMauricio.ui.dataClass.Restaurant
import com.pmtaller2.HenryMauricio.ui.dataClass.foodCategories
import com.pmtaller2.HenryMauricio.ui.dataClass.restaurants

@Composable
fun RestaurantCard(restaurant: Restaurant, navController: NavController){

    Button(
        onClick = {
            val id = restaurant.id
            navController.navigate("RestaurantProfile/$id")
                  },
        modifier = Modifier.clip(RoundedCornerShape(3.dp)).size(150.dp),

        ){
        Text(text = restaurant.name, fontWeight = FontWeight.ExtraBold, color = Color.White, textAlign = TextAlign.Center)
    }

}

@Composable
fun CategorySection(category: String, navController: NavController){

    LazyRow (modifier = Modifier.fillMaxWidth()){
        items(restaurants){
                restaurant ->
            if (restaurant.categories.contains(category)){
                RestaurantCard(restaurant, navController = navController)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }

}


@Composable
fun Main(navController: NavController){

    Scaffold(
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
    ) {
            padding ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)){
            items(foodCategories){
                    category ->
                Text(text = category, fontWeight = FontWeight.ExtraBold)
                CategorySection(category, navController = navController)
                Spacer(modifier = Modifier.width(10.dp))

            }

        }

    }
}

