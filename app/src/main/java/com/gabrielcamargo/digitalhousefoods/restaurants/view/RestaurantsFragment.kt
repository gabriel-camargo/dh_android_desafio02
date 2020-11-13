package com.gabrielcamargo.digitalhousefoods.restaurants.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel
import com.gabrielcamargo.digitalhousefoods.restaurants.repository.RestaurantRepository
import com.gabrielcamargo.digitalhousefoods.restaurants.viewmodel.RestaurantViewModel

class RestaurantsFragment : Fragment() {
    lateinit var myView: View
    lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_restaurant, container, false)

        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            RestaurantViewModel.RestaurantViewModelFactory(RestaurantRepository(view.context))
        ).get(RestaurantViewModel::class.java)

        viewModel.restaurants.observe(viewLifecycleOwner, Observer {
            createList(it)
        })

        viewModel.getRestaurants()
    }

    fun createList(restaurants: List<RestaurantModel>) {
        val viewManager = LinearLayoutManager(myView.context)
        val recyclerView = myView.findViewById<RecyclerView>(R.id.cardList_fragmentRestaurant)
        val viewAdapter = RestaurantsAdapter(restaurants)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    companion object {
        fun newInstance() = RestaurantsFragment()
    }
}