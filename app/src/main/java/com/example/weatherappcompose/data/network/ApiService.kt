package com.example.weatherappcompose.data.network

import com.example.weatherappcompose.data.network.responce.Respose
import com.example.weatherappcompose.util.Constants.API_KEY
import retrofit2.http.GET

interface ApiService {
    @GET("/forecast.json?key=${API_KEY}&q=Sosnovskoye&days=7&aqi=no&alerts=no&lang=ru")
    suspend fun getWeatherList(): List<Respose>
}