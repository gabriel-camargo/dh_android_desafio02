package com.gabrielcamargo.digitalhousefoods.restaurantDetails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.model.FoodModel
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.repository.FoodsRepository

class RestaurantDetailsViewModel(
    private val repository: FoodsRepository
) : ViewModel() {
    val foods = MutableLiveData<MutableList<FoodModel>>()

    fun getFoods() {
        repository.getFoods {
            foods.value = it
        }
    }

    @Suppress("UNCHECKED_CAST")
    class RestaurantDetailsViewModelFactory(
        private val repository: FoodsRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantDetailsViewModel(repository) as T
        }
    }
}