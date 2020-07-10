package com.lastachkin.weatherinfo.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitClient {
    private val service: API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
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