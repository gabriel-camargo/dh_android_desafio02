package com.gabrielcamargo.digitalhousefoods.restaurantDetails.repository

import android.content.Context
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.model.FoodModel

class FoodsRepository(private val context: Context) {
    fun getFoods(callback: (foods: MutableList<FoodModel>) -> Unit) {
        callback.invoke(
            mutableListOf<FoodModel>(
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
                FoodModel(
                    "Salada com molho Gengibre",
                    R.drawable.restaurant_2
                ),
            )
        )
    }
}
