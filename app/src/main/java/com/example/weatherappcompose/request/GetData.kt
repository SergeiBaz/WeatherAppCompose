package com.example.weatherappcompose.request

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherappcompose.data_storage.WeatherModel
import com.example.weatherappcompose.processing_request.getWeatherByDays

const val API_KEY = "e682f29b015d4c35b31163416232404"
fun getData(
    city: String,
    context: Context,
    daysList: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>
) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "7" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val list = getWeatherByDays(response)
            daysList.value = list
            currentDay.value = list[0]
        },
        {
            error ->
            Log.d("MyLog", "Response: $error")
        }
    )
    queue.add(sRequest)
}