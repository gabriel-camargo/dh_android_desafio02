package com.gabrielcamargo.digitalhousefoods.restaurants.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel
import com.gabrielcamargo.digitalhousefoods.restaurants.repository.RestaurantRepository

class RestaurantViewModel(
    private val repository: RestaurantRepository
): ViewModel() {
    val restaurants = MutableLiveData<MutableList<RestaurantModel>>()

    fun getRestaurants() {
        repository.getRestaurants {
            restaurants.value = it
        }
    }

    @Suppress("UNCHECKED_CAST")
    class RestaurantViewModelFactory(
        private val repository: RestaurantRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantViewModel(repository) as T
        }
    }
}