package com.example.weatherappcompose.presentation.viewmodel

import com.example.weatherappcompose.data.model.Weather

sealed interface WeathersUiState {
    data class Success(val weatherSearch: Weather) : WeathersUiState
    object Error : WeathersUiState
    object Loading : WeathersUiState
}