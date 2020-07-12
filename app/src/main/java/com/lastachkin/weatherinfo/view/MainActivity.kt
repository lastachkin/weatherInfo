package com.lastachkin.weatherinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lastachkin.weatherinfo.R
import com.lastachkin.weatherinfo.model.WeatherModel
import com.lastachkin.weatherinfo.presenter.MainPresenter
import com.lastachkin.weatherinfo.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var mPresenter = MainPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.fetchWeather()
    }

    override fun showWeather(weather: WeatherModel) {
        city.text = weather.name
        temp.text = weather.main?.temp.toString()
    }
}
