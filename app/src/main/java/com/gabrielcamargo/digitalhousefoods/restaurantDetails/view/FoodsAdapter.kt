package com.gabrielcamargo.digitalhousefoods.restaurantDetails.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.digitalhousefoods.R
import com.gabrielcamargo.digitalhousefoods.restaurantDetails.model.FoodModel

class FoodsAdapter (
    private val dataset: List<FoodModel>,
    private val clickListener: (FoodModel) -> Unit
): RecyclerView.Adapter<FoodsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_restaurant_detail, parent, false)

        return FoodsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodsViewHolder, position: Int) {
        holder.bind(dataset[position])
        holder.itemView.setOnClickListener{clickListener(dataset[position])}
    }

    override fun getItemCount() = dataset.size
}