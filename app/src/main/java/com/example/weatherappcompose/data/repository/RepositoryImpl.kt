package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.data.network.ApiService
import com.example.weatherappcompose.data.network.responce.mappers.toDomain

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getWeather(): Weather = api.getWeatherList().toDomain()
    /*.map{items->
        Weather(
            name = items.location.name,
            timeLastUpdated = items.current.last_updated,
            condition = items.current.condition.text,
            icon = items.current.condition.icon,
            temp = items.current.temp_c.toInt().toString(),
            weatherDay = items.forecast.forecastday.map { forecastday->
                WeatherDay(
                    condition = forecastday.day.condition.text,
                    maxTemp = forecastday.day.maxtemp_c.toInt().toString(),
                    minTemp = forecastday.day.mintemp_c.toInt().toString(),
                    icon = forecastday.day.condition.icon
                )
            },
            weatherHours = items.forecast.forecastday.map { forecastday->
                forecastday.hour.map {hour->
                    WeatherHour(
                        time = hour.time,
                        temp = hour.temp_c.toInt().toString(),
                        icon = hour.condition.icon,
                        condition = hour.condition.text
                    )
                }
            }
        )
    }*/
}