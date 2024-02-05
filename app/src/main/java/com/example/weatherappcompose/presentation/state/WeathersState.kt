package com.example.weatherappcompose.presentation.state

import com.example.weatherappcompose.data.model.Weather


data class WeathersState(
    val weathers: Weather? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)