package com.example.weatherappcompose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.presentation.screens.uiComponent.WeathersGridScreen
import com.example.weatherappcompose.presentation.state.WeathersUiState

@Composable
fun HomeScreen(
    weathersUiState: WeathersUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
    onNewClicked: (Weather) -> Unit,
) {
    when (weathersUiState) {
        is WeathersUiState.Loading -> LoadingScreen(modifier)
        is WeathersUiState.Success -> WeathersGridScreen(
            modifier = modifier,
            onNewClicked,
            news = weathersUiState.weatherSearch
        )

        is WeathersUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}