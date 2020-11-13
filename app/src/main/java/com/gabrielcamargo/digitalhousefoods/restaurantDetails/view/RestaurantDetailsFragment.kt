package com.gabrielcamargo.digitalhousefoods.restaurantDetails.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.model.FoodModel
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.repository.FoodsRepository
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.viewmodel.RestaurantDetailsViewModel
import com.gabrielcamargo.digitalhousefoods.restaurants.view.RestaurantsFragment
import com.squareup.picasso.Picasso

class RestaurantDetailsFragment : Fragment() {
    lateinit var myView: View
    lateinit var viewModel: RestaurantDetailsViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_restaurant_details, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgumentsRestaurant()

        viewModel = ViewModelProvider(
            this,
            RestaurantDetailsViewModel.RestaurantDetailsViewModelFactory(FoodsRepository(view.context))
        ).get(RestaurantDetailsViewModel::class.java)

        viewModel.foods.observe(viewLifecycleOwner, Observer {
            createList(it)
        })

        viewModel.getFoods()
    }

    private fun getArgumentsRestaurant() {
        val txt = myView.findViewById<TextView>(R.id.txtNameRestaurante_detailsRestaurant)
        txt.text= arguments?.getString(RestaurantsFragment.KEY_NOME)

        val imgView = myView.findViewById<ImageView>(R.id.imgRestaurant_detailsRestaurant)
        arguments?.getInt(RestaurantsFragment.KEY_IMAGEM)?.let {
            Picasso.get()
                .load(it)
                .fit()
                .centerCrop()
                .into(imgView)
        }
    }

    private fun createList(foods: List<FoodModel>) {
        navController = Navigation.findNavController(myView)

        val viewManager = GridLayoutManager(myView.context,2)
        val recyclerView = myView.findViewById<RecyclerView>(R.id.cardList_detailsRestaurant)

        val viewAdapter = FoodsAdapter(foods) {
            val bundle = bundleOf(KEY_NOME to it.name, KEY_IMAGEM to it.imgUrl)

            navController.navigate(R.id.foodDetailsFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    companion object {
        fun newInstance() = RestaurantDetailsFragment()

        val KEY_NOME = "NOME"
        val KEY_IMAGEM = "IMAGEM"
    }

}