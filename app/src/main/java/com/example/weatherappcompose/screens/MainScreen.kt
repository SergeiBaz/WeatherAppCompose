package com.example.weatherappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.Blue

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.weather_sunny),
        contentDescription = "image_fillScreen",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.6f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
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
                        text = "03 May 2023 17:00",
                        style = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/122.png",
                        contentDescription = "image_condition",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Text(
                    text = "Sosnovskyoe",
                    style = TextStyle(fontSize = 25.sp, color = Color.White)
                )
                Text(
                    text = "25°С",
                    style = TextStyle(fontSize = 60.sp, color = Color.White)
                    )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp, color = Color.White)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.im_search),
                            contentDescription = "image_search",
                            tint = Color.White,
                            )
                    }
                    Text(
                        text = "23°C/12°C",
                        style = TextStyle(fontSize = 16.sp, color = Color.White,)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
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