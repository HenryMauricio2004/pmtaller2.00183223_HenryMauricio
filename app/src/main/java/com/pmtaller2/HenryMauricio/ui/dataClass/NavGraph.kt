package com.pmtaller2.HenryMauricio.ui.dataClass

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmtaller2.HenryMauricio.ui.Screens.Cart
import com.pmtaller2.HenryMauricio.ui.Screens.Main
import com.pmtaller2.HenryMauricio.ui.Screens.RestaurantProfile
import com.pmtaller2.HenryMauricio.ui.Screens.Search

@Composable
fun Nav(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Main"){
        composable(route = "Main"){
            Main(navController)
        }

        composable(route = "Cart"){
            Cart(navController)
        }

        composable(route = "Search"){
            Search(navController)
        }

        composable(route = "RestaurantProfile/{id}",
            arguments = listOf(
                navArgument(name = "id"){ type = NavType.IntType}
            )
        ){
            backstackEntry ->
            RestaurantProfile(navController = navController, restaurantId = backstackEntry.arguments?.getInt("id"))
        }
    }
}