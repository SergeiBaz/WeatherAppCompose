package com.example.weatherappcompose.screens.processing_request

import com.example.weatherappcompose.data_storage.WeatherModel
import org.json.JSONObject

fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val mainObjects = JSONObject(response)
    val city = mainObjects.getJSONObject("location").getString("name")
    val day = mainObjects.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until day.length()) {
        val item = day[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.getString("date"),
                item.getJSONObject("day").getJSONObject("condition").getString("text"),
                item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                "",
                item.getJSONObject("day").getString("mintemp_c"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONArray("hour").toString(),
            )
        )
    }
    list[0] = list[0].copy(
        currentTemp = mainObjects.getJSONObject("current").getString("temp_c"),
        time = mainObjects.getJSONObject("current").getString("last_updated")
    )
    return list
}