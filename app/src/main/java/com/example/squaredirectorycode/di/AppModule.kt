package com.example.squaredirectorycode.di

import com.example.squaredirectorycode.data.api.DirectoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitApi(retrofit: Retrofit) : DirectoryApi{
        return retrofit.create(DirectoryApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(DirectoryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}