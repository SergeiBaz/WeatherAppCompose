package com.example.weatherappcompose.presentation.screens.uiComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.data_storage.WeatherModel
import com.example.weatherappcompose.ui.theme.Blue

@Composable
fun ListItem(
    item: WeatherModel,
    currentDay: MutableState<WeatherModel>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .clickable {
                if (item.hours.isEmpty()) return@clickable
                currentDay.value = item
            },
        backgroundColor = Blue
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.padding(3.dp)) {
                Text(
                    text = item.time,
                    style = TextStyle(color = Color.DarkGray)
                )
                Text(
                    text = item.condition,
                    style = TextStyle(color = Color.White)
                )
            }
            Text(
                text = if (item.currentTemp.isEmpty()) "${item.maxTemp.toFloat().toInt()}°C" +
                        "/${item.minTemp.toFloat().toInt()}°C"
                else "${
                    item.currentTemp.toFloat().toInt().toString()
                }°C",
                style = TextStyle(fontSize = 25.sp, color = Color.White)
            )
            AsyncImage(
                model = "https:${item.icon}",
                contentDescription = "image_condition_item",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}