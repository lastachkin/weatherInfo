package com.lastachkin.weatherinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import kotlin.math.roundToInt
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val url = "http://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=${BuildConfig.APPID}"
        val queue = Volley.newRequestQueue(this)
        val ahReq = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            val jo = JSONParser().parse(response.toString()) as JSONObject
            val mainJo = JSONParser().parse(jo["main"].toString()) as JSONObject

            val country = jo["name"]
            val temp = mainJo["temp"].toString().toDouble().roundToInt()/10

            Timber.d("Current city: $country")
            Timber.d("Current temperature: $temp")
        }, Response.ErrorListener {
                error -> Timber.e("Response: ${error.message}")
        })
        queue.add(ahReq)
    }
}
