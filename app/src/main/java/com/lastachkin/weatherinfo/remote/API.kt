package com.lastachkin.weatherinfo.remote

import com.lastachkin.weatherinfo.BuildConfig
import com.lastachkin.weatherinfo.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("weather?appid=${BuildConfig.APPID}&units=metric")
    fun getCurrentWeather(@Query("q") city: String): Single<WeatherModel>
}