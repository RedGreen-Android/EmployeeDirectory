package com.example.squaredirectorycode.data.repository

import com.example.squaredirectorycode.data.api.DirectoryApi
import javax.inject.Inject

class EmployeeRepository @Inject constructor(private val api:DirectoryApi){

    suspend fun getEmployee() = api.getAllEmployee().employees
}