package com.example.weatherappcompose.di

import com.example.weatherappcompose.data.network.ApiService
import com.example.weatherappcompose.data.repository.Repository
import com.example.weatherappcompose.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api: ApiService): Repository = RepositoryImpl(api)
}