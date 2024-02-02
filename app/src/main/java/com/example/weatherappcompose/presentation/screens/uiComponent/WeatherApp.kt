package com.example.weatherappcompose.presentation.screens.uiComponent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.presentation.screens.HomeScreen
import com.example.weatherappcompose.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherApp(
    modifier: Modifier = Modifier,
    onNewClicked: (Weather) -> Unit
) {
    val weatherViewModel = hiltViewModel<WeatherViewModel>()
    weatherViewModel.getListWeather()
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                weathersUiState = weatherViewModel.weathersUiState,
                retryAction = { weatherViewModel.getListWeather() },
                modifier = modifier,
                onNewClicked
            )
        }
    }
}