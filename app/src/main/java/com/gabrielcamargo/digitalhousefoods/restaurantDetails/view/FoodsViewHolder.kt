package com.gabrielcamargo.digitalhousefoods.restaurantDetails.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.model.FoodModel
import com.squareup.picasso.Picasso

class FoodsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val imgView: ImageView = view.findViewById(R.id.imgFood_itemDetailsRestaurant)
    private val txtName: TextView = view.findViewById(R.id.txtFood_itemDetailsRestaurant)

    fun bind(food: FoodModel) {
        Picasso.get()
            .load(food.imgUrl)
            .fit()
            .centerCrop()
            .into(imgView)

        txtName.text = food.name
    }
}
