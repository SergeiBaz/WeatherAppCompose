package com.example.weatherappcompose.data.model

data class Weather(
    val name: String,
    val timeLastUpdated: String,
    val condition: String,
    val icon: String,
    val temp: String,
    val weatherDay: List<WeatherDay>,
    val weatherHours: List<List<WeatherHour>>,
    )
