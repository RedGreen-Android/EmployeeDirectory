package com.example.squaredirectorycode.data.api

import com.example.squaredirectorycode.data.model.Employee
import com.example.squaredirectorycode.data.model.Employees
import retrofit2.Response
import retrofit2.http.GET

interface DirectoryApi {

    companion object {
        const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"
    }

    @GET("employees.json")
    suspend fun getAllEmployee(): Employees
}