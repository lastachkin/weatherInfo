package com.lastachkin.weatherinfo.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class RetrofitClient {
    private val service: API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(API::class.java)
    }

    companion object {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

        private val instance = RetrofitClient()

        fun instance(): API {
            return instance.service
        }
    }
}