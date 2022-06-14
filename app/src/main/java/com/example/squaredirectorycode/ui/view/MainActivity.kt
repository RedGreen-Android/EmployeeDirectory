package com.example.squaredirectorycode.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squaredirectorycode.data.model.EmployeeX
import com.example.squaredirectorycode.databinding.ActivityMainBinding
import com.example.squaredirectorycode.ui.adapter.EmployeeAdapter
import com.example.squaredirectorycode.ui.utils.Status
import com.example.squaredirectorycode.ui.viewmodel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : EmployeeViewModel by viewModels()
    lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupObserver()
    }

    fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        employeeAdapter = EmployeeAdapter(arrayListOf())
        binding.recyclerView.adapter = employeeAdapter
    }

    fun refreshEmployeeList (users: List<EmployeeX>){
        binding.swipeRefresh.setOnRefreshListener {
            retrieveEmployeeList(users)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    fun setupObserver() {
        viewModel.getEmployee().observe(this@MainActivity, Observer {
            it?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        it.data?.let { employee ->
                            retrieveEmployeeList(employee)
                            refreshEmployeeList(employee)
                        }
                    }
                    Status.LOADING -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.swipeRefresh.isRefreshing
                    }
                    Status.ERROR -> {
                        binding.recyclerView.visibility = View.GONE
                        binding.swipeRefresh.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveEmployeeList(users: List<EmployeeX>) {
        employeeAdapter.apply {
            addUsers(users)
//            binding.swipeRefresh.isRefreshing
            notifyDataSetChanged()
        }
    }



}