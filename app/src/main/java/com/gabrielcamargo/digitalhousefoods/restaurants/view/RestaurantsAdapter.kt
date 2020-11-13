package com.gabrielcamargo.digitalhousefoods.restaurants.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurants.model.RestaurantModel

class RestaurantsAdapter(
    private val dataSet: List<RestaurantModel>
): RecyclerView.Adapter<RestaurantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_food,parent,false)

        return RestaurantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.bind(dataSet[position])
//        holder.itemView.setOnClickListener{clickListener(dataSet[position])}
    }

    override fun getItemCount() = dataSet.size
}