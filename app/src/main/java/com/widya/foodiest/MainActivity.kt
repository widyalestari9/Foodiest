package com.widya.foodiest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.widya.foodiest.databinding.ActivityMainBinding
import com.widya.foodiest.fragment.BreakfestFragment
import com.widya.foodiest.fragment.DessertFragment
import com.widya.foodiest.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {


    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        setCurrentFragment(BreakfestFragment())
        mainBinding.navBottomMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_breakfast -> setCurrentFragment(BreakfestFragment())
                R.id.ic_vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_dessert -> setCurrentFragment(DessertFragment())
            }
            true
        }

    }
    private fun setCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_main, fragment)
        commit()

    }
}