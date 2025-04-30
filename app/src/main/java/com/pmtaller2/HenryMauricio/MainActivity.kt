package com.pmtaller2.HenryMauricio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.pmtaller2.HenryMauricio.ui.Screens.Main
import com.pmtaller2.HenryMauricio.ui.dataClass.Dish
import com.pmtaller2.HenryMauricio.ui.dataClass.Restaurant
import com.pmtaller2.HenryMauricio.ui.dataClass.foodCategories
import com.pmtaller2.HenryMauricio.ui.dataClass.restaurants
import com.pmtaller2.HenryMauricio.ui.theme.FoodSpotByAgarciaTheme
import org.intellij.lang.annotations.JdkConstants
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByAgarciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RestaurantProfile(2)
                }
            }
        }
    }
}


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

        Image(
            painter = rememberAsyncImagePainter(model = dish.imageUrl),
            contentDescription = (dish.name + " image"),
            contentScale = ContentScale.Crop
        )


        //Imagen cargada a partir de URL con libreria Coil 3.4.0
        AsyncImage(modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(8.dp)),
            model = dish.imageUrl,
            contentDescription = dish.name
        )

        Column(){
            Text(text = dish.name, fontWeight = FontWeight.Black)
            Text(text = dish.description, fontSize = 14.sp)
        }

    }
}

@Composable
fun RestaurantProfile(restaurantId: Int){

    val restaurant: Restaurant? = restaurants.find { it.id == restaurantId }

    Scaffold {
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotByAgarciaTheme {
        RestaurantProfile(2)
    }
}