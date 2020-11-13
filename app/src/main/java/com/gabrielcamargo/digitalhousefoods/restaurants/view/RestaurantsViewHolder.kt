package com.gabrielcamargo.digitalhousefoods.restaurants.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel
import com.squareup.picasso.Picasso

class RestaurantsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imgView: ImageView = view.findViewById(R.id.img_itemFood)
        private val txtName: TextView = view.findViewById(R.id.txtNomeComida_itemFood)
        private val txtEndereco: TextView = view.findViewById(R.id.txtEndereco_itemFood)
        private val txtHora: TextView = view.findViewById(R.id.txtHoraFechar_itemFood)

    fun bind(restaurant: RestaurantModel) {
        Picasso.get()
            .load(restaurant.imageUrl)
            .into(imgView)

        txtName.text = restaurant.nome
        txtEndereco.text = restaurant.endereco
        txtHora.text = restaurant.horarioFechar
    }
}