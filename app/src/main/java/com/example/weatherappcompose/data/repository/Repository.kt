package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getWeather(): Flow<Resource<Weather>>
}