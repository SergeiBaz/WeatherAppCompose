package com.example.weatherappcompose.data.network.responce

import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)