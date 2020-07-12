package com.lastachkin.weatherinfo.presenter

import com.lastachkin.weatherinfo.model.WeatherModel

interface MainPresenter {
    fun fetchWeather()
    fun onWeatherFetched(model: WeatherModel?)
}