package com.example.weatherappcompose.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.repository.Repository
import com.example.weatherappcompose.presentation.state.WeathersState
import com.example.weatherappcompose.presentation.state.WeathersUiState
import com.example.weatherappcompose.util.Resource
import com.example.weatherappcompose.util.UiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var weathersUiState: WeathersUiState by mutableStateOf(WeathersUiState.Loading)
        private set

    private val _weathersState = mutableStateOf(WeathersState())
    val weathersState: State<WeathersState> = _weathersState

    private val _categoriesState = mutableStateOf(emptyList<String>())
    val categoriesState: State<List<String>> = _categoriesState

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow: SharedFlow<UiEvents> = _eventFlow.asSharedFlow()


    fun getListWeather() {
        viewModelScope.launch {
            repository.getWeather().collectLatest { result->
                when(result) {
                    is Resource.Success -> {
                        _weathersState.value = weathersState.value.copy(
                            weathers = result.data!!,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _weathersState.value = weathersState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _weathersState.value = weathersState.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }

            }
        }
    }
}