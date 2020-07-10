package com.lastachkin.weatherinfo.presenter

import com.lastachkin.weatherinfo.WeatherRepository
import com.lastachkin.weatherinfo.WeatherRepositoryImpl
import com.lastachkin.weatherinfo.model.WeatherModel
import com.lastachkin.weatherinfo.view.MainView

class MainPresenterImpl(private val mView: MainView) :  MainPresenter, WeatherRepositoryImpl.OnWeatherFetchedListener {

    private val mRepository: WeatherRepository
    private var currentWeather: WeatherModel?  = null

    init {
        mRepository = WeatherRepositoryImpl(this)
        mRepository.getWeather()
    }

    override fun showWeather(weather: WeatherModel) {
        currentWeather = weather
        mView.showWeather(currentWeather!!)
    }
}