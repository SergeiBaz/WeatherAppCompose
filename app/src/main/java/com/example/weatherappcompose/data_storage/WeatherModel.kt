package com.example.weatherappcompose.data_storage

data class WeatherModel(
    val name: String,
    val time: String,
    val condition: String,
    val icon: String,
    val currentTemp: String,
    val minTemp: String,
    val maxTemp: String,
    val hours: String,
)