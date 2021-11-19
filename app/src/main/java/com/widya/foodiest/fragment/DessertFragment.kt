package com.widya.foodiest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.widya.foodiest.R
import com.widya.foodiest.adapter.FoodAdapter
import com.widya.foodiest.databinding.FragmentDessertBinding
import com.widya.foodiest.model.DataRecipes
import com.widya.foodiest.model.Recipes

class DessertFragment : Fragment() {
    private lateinit var dessertBinding: FragmentDessertBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dessertBinding = FragmentDessertBinding.inflate(inflater,container,false)
        return dessertBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataDessert)
        dessertBinding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }

}