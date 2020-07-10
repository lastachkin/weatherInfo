package com.lastachkin.weatherinfo.view

import com.lastachkin.weatherinfo.model.WeatherModel

interface MainView {
    fun showWeather(weather: WeatherModel)
}