package com.lastachkin.weatherinfo

import com.lastachkin.weatherinfo.model.WeatherModel
import com.lastachkin.weatherinfo.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepositoryImpl(private val onWeatherFetchedListener: OnWeatherFetchedListener) : WeatherRepository {
    override fun getWeather() {
        RetrofitClient.instance().getCurrentWeather("Minsk").enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                if(response.code() < 400) {
                    onWeatherFetchedListener.showWeather(response.body()!!)
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    interface OnWeatherFetchedListener {
        fun showWeather(weather: WeatherModel)
    }
}