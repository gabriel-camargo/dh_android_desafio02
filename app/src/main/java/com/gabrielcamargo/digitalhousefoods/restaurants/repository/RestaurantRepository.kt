package com.gabrielcamargo.digitalhousefoods.restaurants.repository

import android.content.Context
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel

class RestaurantRepository(private val context: Context) {
    fun getRestaurants(callback: (restaurants: MutableList<RestaurantModel>) -> Unit) {
        callback.invoke(
            mutableListOf<RestaurantModel>(
                RestaurantModel("Nome 1", "Endereco 1", "Horario 1", "Img"),
                RestaurantModel("Nome 2", "Endereco 2", "Horario 2", "Img"),
                RestaurantModel("Nome 3", "Endereco 3", "Horario 3", "Img"),
                RestaurantModel("Nome 4", "Endereco 4", "Horario 4", "Img")
            )
        )
    }
}