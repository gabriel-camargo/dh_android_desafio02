package com.gabrielcamargo.digitalhousefoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gabrielcamargo.digitalhousefoods.restaurants.view.RestaurantsFragment
import com.squareup.picasso.Picasso

class RestaurantDetailsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<TextView>(R.id.txtNameRestaurante_detailsRestaurant)
        txt.text= arguments?.getString(RestaurantsFragment.KEY_NOME)

        val imgView = view.findViewById<ImageView>(R.id.imgRestaurant_detailsRestaurant)

        arguments?.getInt(RestaurantsFragment.KEY_IMAGEM)?.let {
            Picasso.get()
                .load(it)
                .fit()
                .centerCrop()
                .into(imgView)
        }
    }

    companion object {
        fun newInstance() = RestaurantDetailsFragment()
    }

}