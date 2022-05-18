package com.example.flowerapp

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.flowerapp.databinding.ActivityMainBinding
import com.example.flowerapp.repo.NetworkRepository
import com.example.flowerapp.service.RetrofitService
import com.example.flowerapp.viewmodel.MainAdapter
import com.example.flowerapp.viewmodel.MainViewModel
import com.example.flowerapp.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()

        val viewModel =
            ViewModelProvider(this, MyViewModelFactory(NetworkRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        val adapter = MainAdapter(this)

        binding.recyclerview.adapter = adapter

        viewModel.flowerList.observe(this, Observer {
            logd("onCreate: $it")
            adapter.setFlowerList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            loge("Error while getting the flowers: $it")
        })
        viewModel.getAllFlowers()
    }
}