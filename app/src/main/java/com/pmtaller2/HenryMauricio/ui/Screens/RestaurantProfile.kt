package com.pmtaller2.HenryMauricio.ui.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.pmtaller2.HenryMauricio.ui.dataClass.Dish
import com.pmtaller2.HenryMauricio.ui.dataClass.Restaurant
import com.pmtaller2.HenryMauricio.ui.dataClass.restaurants
import com.pmtaller2.HenryMauricio.ui.theme.Orange


@Composable
fun CategoryBox(category: String){
    Text(
        modifier = Modifier
            .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(25.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = category,
        fontStyle = FontStyle.Italic,
        fontSize = 12.sp)
}

@Composable
fun DishBox(dish: Dish){
    Row(){
        val context = LocalContext.current

        //Imagen cargada a partir de URL con libreria Coil 3.4.0
        AsyncImage(
            model = dish.imageUrl,
            contentDescription = dish.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Column(){
            Text(text = dish.name, fontWeight = FontWeight.Black)
            Text(text = dish.description, fontSize = 14.sp)
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White
                ),
                onClick = {
                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                }){
                Text(text = "+Agregar al carrito")}
        }

    }
}

@Composable
fun RestaurantProfile(navController: NavController, restaurantId: Int?){

    val restaurant: Restaurant? = restaurants.find { it.id == restaurantId }

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
    ) {
            padding ->

        if (restaurant != null){

            Column (
            ){
                Box(modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(color = Color.Blue)
                    .padding(start = 5.dp)){
                    Text(modifier = Modifier
                        .align(alignment = Alignment.BottomStart),
                        text = restaurant.name,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 40.sp,
                        color = Color.White)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                    text = restaurant.description)

                Spacer(modifier = Modifier.height(10.dp))

                //Despliegue de lista de categorias del restaurante
                LazyRow( modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)){

                    items (restaurant.categories) {
                            category ->
                        CategoryBox(category)
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                LazyColumn(){
                    items(restaurant.menu){
                            dish ->
                        DishBox(dish)
                    }
                }

            }


        }

    }

}