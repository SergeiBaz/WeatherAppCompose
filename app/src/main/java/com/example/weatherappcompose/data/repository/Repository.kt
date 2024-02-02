package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.model.Weather

interface Repository {
    suspend fun getWeather(): Weather
}