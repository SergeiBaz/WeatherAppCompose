package com.example.weatherappcompose.presentation.state

import com.example.weatherappcompose.data.model.Weather

sealed interface WeathersUiState {
    data class Success(val weatherSearch: Weather) : WeathersUiState
    object Error : WeathersUiState
    object Loading : WeathersUiState
}