package com.example.weatherappcompose.processing_request

import com.example.weatherappcompose.data_storage.WeatherModel
import org.json.JSONArray
import org.json.JSONObject

fun getWeatherByHours(hours: String): List<WeatherModel> {
    if (hours.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val hoursArray = JSONArray(hours)

    for (i in 0 until hoursArray.length()){
        val item = hoursArray[i] as JSONObject
        list.add(
            WeatherModel(
                "",
                item.getString("time"),
                item.getJSONObject("condition").getString("text"),
                item.getJSONObject("condition").getString("icon"),
                item.getString("temp_c"),
                "",
                "",
                "",
            )
        )
    }
    return list
}