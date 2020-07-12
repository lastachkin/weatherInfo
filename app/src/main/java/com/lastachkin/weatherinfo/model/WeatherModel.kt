package com.lastachkin.weatherinfo.model

import com.google.gson.annotations.SerializedName

class WeatherModel {

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("weather")
    var weather: List<Weather>? = null

    @SerializedName("base")
    var base: String = ""

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("visibility")
    var visibility: Int = 0

    @SerializedName("wind")
    var wind: Wind? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("dt")
    var dt: Int = 0

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("timezone")
    var timezone: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("cod")
    var cod: Int = 0

}