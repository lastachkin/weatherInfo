package com.lastachkin.weatherinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        Log.d("TAG", "Method getData")
        val url = "http://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=f23a688b6a836d64356cd73489f341b3"
        val queue = Volley.newRequestQueue(this)
        val ahReq = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            val jo = JSONParser().parse(response.toString()) as JSONObject
            val mainJo = JSONParser().parse(jo["main"].toString()) as JSONObject

            val country = jo["name"]
            val temp = mainJo["temp"].toString().toDouble().roundToInt()/10

            Log.d("TAG", "Current city: $country")
            Log.d("TAG", "Current temperature: $temp")
        }, Response.ErrorListener {
                error -> Log.d("TAG","response: ${error.message}")
        })
        queue.add(ahReq)
    }
}
