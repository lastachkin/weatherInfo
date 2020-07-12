package com.lastachkin.weatherinfo.presenter

import com.lastachkin.weatherinfo.repository.WeatherRepositoryImpl
import com.lastachkin.weatherinfo.model.WeatherModel
import com.lastachkin.weatherinfo.view.MainView

class MainPresenterImpl(private val mView: MainView) :  MainPresenter {
    private val mRepository = WeatherRepositoryImpl(this)

    override fun onWeatherFetched(model: WeatherModel?) {
       model?.let { mView.showWeather(it) }
    }

    override fun fetchWeather() {
        mRepository.getWeather()
    }
}