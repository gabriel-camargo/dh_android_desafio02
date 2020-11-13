package com.gabrielcamargo.digitalhousefoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.view.RestaurantDetailsFragment
import com.gabrielcamargo.digitalhousefoods.restaurants.view.RestaurantsFragment
import com.squareup.picasso.Picasso

class FoodDetailsFragment : Fragment() {
    lateinit var myView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_food_details, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgumentsRestaurantDetails()
    }
    private fun getArgumentsRestaurantDetails() {
        val txt = myView.findViewById<TextView>(R.id.txtFood_detailsFood)
        txt.text= arguments?.getString(RestaurantDetailsFragment.KEY_NOME)

        val imgView = myView.findViewById<ImageView>(R.id.imgFood_detailsFood)
        arguments?.getInt(RestaurantDetailsFragment.KEY_IMAGEM)?.let {
            Picasso.get()
                .load(it)
                .fit()
                .centerCrop()
                .into(imgView)
        }
    }

    companion object {
        fun newInstance() = FoodDetailsFragment()
    }
}