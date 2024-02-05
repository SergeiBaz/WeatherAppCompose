package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.model.Weather
import com.example.weatherappcompose.data.network.ApiService
import com.example.weatherappcompose.data.network.responce.mappers.toDomain
import com.example.weatherappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RepositoryImpl(private val api: ApiService) : Repository {
    override suspend fun getWeather(): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.getWeatherList()
            emit(Resource.Success(response.toDomain()))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Не удалось подключиться к серверу, проверьте подключение к Интернету!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Упс! Что-то пошло не так!"))
        }
    }
}