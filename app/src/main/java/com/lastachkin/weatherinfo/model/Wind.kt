package com.lastachkin.weatherinfo.model

import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("speed")
    var speed: Int = 0

    @SerializedName("deg")
    var deg: Int = 0

    @SerializedName("gust")
    var gust: Int = 0

}
