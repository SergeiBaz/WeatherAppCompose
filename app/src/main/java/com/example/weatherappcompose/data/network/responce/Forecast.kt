package com.example.weatherappcompose.data.network.responce

import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val forecastday: List<Forecastday>
)