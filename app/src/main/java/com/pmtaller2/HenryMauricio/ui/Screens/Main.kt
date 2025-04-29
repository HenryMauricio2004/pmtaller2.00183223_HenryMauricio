package com.pmtaller2.HenryMauricio.ui.Screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pmtaller2.HenryMauricio.ui.dataClass.Restaurant
import com.pmtaller2.HenryMauricio.ui.dataClass.foodCategories
import com.pmtaller2.HenryMauricio.ui.dataClass.restaurants

@Composable
fun RestaurantCard(restaurant: Restaurant){

    Button(
        onClick = {},
        modifier = Modifier.clip(RoundedCornerShape(3.dp)).size(150.dp),

        ){
        Text(text = restaurant.name, fontWeight = FontWeight.ExtraBold, color = Color.White, textAlign = TextAlign.Center)
    }

}

@Composable
fun CategorySection(category: String){

    LazyRow {
        items(restaurants){
                restaurant ->
            if (restaurant.categories.contains(category)){
                RestaurantCard(restaurant)
            }
        }
    }

}


@Composable
fun Main(){

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
            padding ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()){
            items(foodCategories){
                    category ->
                Text(text = category, fontWeight = FontWeight.ExtraBold)
                CategorySection(category)
                Spacer(modifier = Modifier.width(10.dp))

            }

        }

    }
}

