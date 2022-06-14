package com.example.squaredirectorycode.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.squaredirectorycode.data.model.Employee
import com.example.squaredirectorycode.data.model.EmployeeX
import com.example.squaredirectorycode.data.model.Employees
import com.example.squaredirectorycode.data.repository.EmployeeRepository
import com.example.squaredirectorycode.ui.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val repository: EmployeeRepository)
    :ViewModel(){

    private val _employee = MutableLiveData<List<EmployeeX>>()

    fun getEmployee() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getEmployee()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Sorry, looks like something maybe broke, try again later!"))
        }
    }

}