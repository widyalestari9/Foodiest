package com.widya.foodiest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.widya.foodiest.R
import com.widya.foodiest.adapter.FoodAdapter
import com.widya.foodiest.databinding.FragmentBreakfestBinding
import com.widya.foodiest.model.DataRecipes
import com.widya.foodiest.model.Recipes

class BreakfestFragment : Fragment() {

    private lateinit var breakfastBinding: FragmentBreakfestBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        breakfastBinding = FragmentBreakfestBinding.inflate(inflater, container,false)

        return breakfastBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreaksfast.apply{
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }


}