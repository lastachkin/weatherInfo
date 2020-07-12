package com.lastachkin.weatherinfo.repository

import com.lastachkin.weatherinfo.presenter.MainPresenter
import com.lastachkin.weatherinfo.remote.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(private var mainPresenter: MainPresenter) :
    WeatherRepository {
    var compositeDisposable = CompositeDisposable()
    override fun getWeather() {
        compositeDisposable.add(RetrofitClient.instance().getCurrentWeather("Minsk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { model ->
                mainPresenter.onWeatherFetched(model)
            })
    }
}