package com.lastachkin.weatherinfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("speed")
    @Expose
    var speed: Int? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null
    @SerializedName("gust")
    @Expose
    var gust: Int? = null

}
