package com.example.weatherappcompose.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var weathersUiState: WeathersUiState by mutableStateOf(WeathersUiState.Loading)
        private set


    fun getListWeather() {
        viewModelScope.launch {
            weathersUiState = WeathersUiState.Loading
            weathersUiState =
                try {
                    WeathersUiState.Success(repository.getWeather())
                } catch (e: java.io.IOException) {
                    WeathersUiState.Error
                }
        }
    }
}