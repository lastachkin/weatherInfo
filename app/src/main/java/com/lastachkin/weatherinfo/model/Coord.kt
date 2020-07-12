package com.lastachkin.weatherinfo.model

import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lon")
    var lon: Double = 0.0

    @SerializedName("lat")
    var lat: Double = 0.0

}