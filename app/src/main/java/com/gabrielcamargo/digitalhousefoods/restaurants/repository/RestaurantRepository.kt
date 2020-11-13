package com.gabrielcamargo.digitalhousefoods.restaurants.repository

import android.content.Context
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel

class RestaurantRepository(private val context: Context) {
    fun getRestaurants(callback: (restaurants: MutableList<RestaurantModel>) -> Unit) {
        callback.invoke(
            mutableListOf<RestaurantModel>(
                RestaurantModel(
                    "Tony Roma's",
                    "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                    "Fecha às 22:00",
                    R.drawable.restaurant_1
                ),
                RestaurantModel(
                    "Aoyama - Moema",
                    "Alameda dos Arapanés, 523 - Moema",
                    "Fecha às 00:00",
                    R.drawable.restaurant_2
                ),
                RestaurantModel(
                    "Outback - Moema",
                    "Av. Moaci, 187, 187 - Moema, São Paulo",
                    "Fecha às 00:00",
                    R.drawable.restaurant_1
                ),
                RestaurantModel(
                    "Sí Señor!",
                    "Alameda Jauaperi, 626 - Moema",
                    "Fecha às 01:00",
                    R.drawable.restaurant_2
                )
            )
        )
    }
}