package com.example.weatherappcompose.list_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.weatherappcompose.data_storage.WeatherModel
@Composable
fun dayState(): MutableState<List<WeatherModel>> {
    val daysList = remember{
        mutableStateOf(listOf<WeatherModel>())
    }
    return daysList

}
@Composable
fun currentDay(): MutableState<WeatherModel>{
    val currentDayList = remember{
        mutableStateOf(
            WeatherModel(
            "",
                "",
                "",
                "",
                "0.0",
                "0.0",
                "0.0",
                ""
        )
        )
    }
    return currentDayList
}

