package com.example.weatherappcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.data_storage.WeatherModel
import com.example.weatherappcompose.presentation.viewmodel.WeatherViewModel
import com.example.weatherappcompose.processing_request.getWeatherByHours
import com.example.weatherappcompose.ui.theme.Blue
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun MainCard(currentDay: MutableState<WeatherModel>,onClickSync: () -> Unit, onClickSearch: () -> Unit) {
    val weatherViewModel = hiltViewModel<WeatherViewModel>()
    weatherViewModel.getListNews()
    Column(
        modifier = Modifier.padding(5.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Blue,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        text = currentDay.value.time,
                        style = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    AsyncImage(
                        model = "https:" + currentDay.value.icon,
                        contentDescription = "image_condition",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Text(
                    text = currentDay.value.name, style = TextStyle(fontSize = 25.sp, color = Color.White)
                )
                Text(
                    text = if(currentDay.value.currentTemp.isNotEmpty())
                        currentDay.value.currentTemp.toFloat().toInt().toString() + "°C"
                                else "${currentDay.value.maxTemp.toFloat().toInt()}°C/" +
                            "${currentDay.value.minTemp.toFloat().toInt()}°C",
                    style = TextStyle(fontSize = 60.sp, color = Color.White)
                )
                Text(
                    text = currentDay.value.condition, style = TextStyle(fontSize = 16.sp, color = Color.White)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        onClickSearch.invoke()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.im_search),
                            contentDescription = "image_search",
                            tint = Color.White,
                        )
                    }
                    Text(
                        text = "${currentDay.value.maxTemp}°C/${currentDay.value.minTemp}°C", style = TextStyle(fontSize = 16.sp, color = Color.White)
                    )
                    IconButton(onClick = {
                        onClickSync.invoke()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.im_sync),
                            contentDescription = "image_sync",
                            tint = Color.White,
                        )
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(daysList: MutableState<List<WeatherModel>>, currentDay: MutableState<WeatherModel>) {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutine = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(
                RoundedCornerShape(5.dp),
            )
    ) {
        TabRow(
            selectedTabIndex = tabIndex, indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, it)
                )
            }, backgroundColor = Blue, contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutine.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    },
                )
            }
        }
        HorizontalPager(
            count = tabList.size, state = pagerState, modifier = Modifier.weight(1.0f)
        ) { index ->
            val list = when(index){
                0 -> getWeatherByHours(currentDay.value.hours)
                1 -> daysList.value
                else -> daysList.value
            }
            MainList(list, currentDay)
        }
    }
}