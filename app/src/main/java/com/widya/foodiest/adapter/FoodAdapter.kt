package com.widya.foodiest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.widya.foodiest.DetailActivity
import com.widya.foodiest.databinding.ItemFoodBinding
import com.widya.foodiest.model.Recipes

class FoodAdapter (private val listFood : ArrayList<Recipes>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        with(holder) {
            with(listFood[position]) {
                Glide.with(holder.itemView.context).load(pictures)
                    .into(binding.ivItemRecipe)
                binding.tvItemNameRecipe.text = name
                binding.tvItemMenu.text = category
                binding.tvNumberRecipe.text = number
                val mathContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val dataSend = Recipes(
                        name = listFood[position].name,
                        category = listFood[position].category,
                        description = listFood[position].description,
                        ingredients = listFood[position].ingredients,
                        instructions = listFood[position].instructions,
                        pictures = listFood[position].pictures,
                        number = listFood[position].number,
                        calories = listFood[position].calories,
                        carbo = listFood[position].carbo,
                        protein = listFood[position].protein,
                    )
                    val intentToDetail = Intent(mathContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA,dataSend)
                    mathContext.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun getItemCount(): Int = listFood.size

}


