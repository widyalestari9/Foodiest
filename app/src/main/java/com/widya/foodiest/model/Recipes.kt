package com.widya.foodiest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    var name : String?,
    var category : String?,
    var description : String?,
    var ingredients: String?,
    var pictures : String?,
    var instructions : String?,
    var number : String?,
    var calories : String?,
    var carbo : String?,
    var protein : String?
) : Parcelable
