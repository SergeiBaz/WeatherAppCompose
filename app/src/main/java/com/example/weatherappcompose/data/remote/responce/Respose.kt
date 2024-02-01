package com.example.weatherappcompose.data.remote.responce

data class Respose(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)