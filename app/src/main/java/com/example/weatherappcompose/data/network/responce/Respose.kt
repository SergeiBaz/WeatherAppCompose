package com.example.weatherappcompose.data.network.responce

import kotlinx.serialization.Serializable

@Serializable
data class Respose(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)