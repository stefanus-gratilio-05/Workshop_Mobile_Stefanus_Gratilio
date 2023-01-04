package com.example.proyek_stefanusgratilio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Provinces(
    var name : String = "",
    var capital : String = "",
    var governor : String = "",
    var population : String = "",
    var area : String = "",
    var abstract : String = "",
    var logo : Int = 0,
) : Parcelable