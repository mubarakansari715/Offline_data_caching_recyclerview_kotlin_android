package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.di

import android.app.Application
import androidx.room.Room
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network.ApiService
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {
    @Provides
    @Singleton

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app:Application): DataDatabase =
        Room.databaseBuilder(app,DataDatabase::class.java,"data_database")
            .build()
}