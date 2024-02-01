package com.example.weatherappcompose.di

import com.example.weatherappcompose.data.remote.ApiService
import com.example.weatherappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor = Interceptor{
        val request = it.request().newBuilder()
        val actualRequest = request.build()
        it.proceed(actualRequest)
    }

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}