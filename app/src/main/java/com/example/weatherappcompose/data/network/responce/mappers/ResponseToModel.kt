package com.example.weatherappcompose.data.network.responce.mappers

import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.data.model.WeatherDay
import com.example.weatherappcompose.data.model.WeatherHour
import com.example.weatherappcompose.data.network.responce.Forecastday
import com.example.weatherappcompose.data.network.responce.Hour
import com.example.weatherappcompose.data.network.responce.Respose

internal fun Respose.toDomain(): Weather {
    return Weather(
        name = location.name,
        timeLastUpdated = current.last_updated,
        condition = current.condition.text,
        icon = current.condition.icon,
        temp = current.temp_c.toInt().toString(),
        weatherDay = forecast.forecastday.map {
            it.toDomain()
        },
        weatherHours =forecast.forecastday.map { forecastday->
            forecastday.hour.map {hour->
                hour.toDomain()
            }
        }
    )
}

internal fun Hour.toDomain(): WeatherHour {
    return WeatherHour(
        time = time,
        temp = temp_c.toInt().toString(),
        icon = condition.icon,
        condition = condition.text
    )
}

internal fun Forecastday.toDomain(): WeatherDay {
    return WeatherDay(
        condition = day.condition.text,
        maxTemp = day.maxtemp_c.toInt().toString(),
        minTemp = day.mintemp_c.toInt().toString(),
        icon = day.condition.icon
    )
}