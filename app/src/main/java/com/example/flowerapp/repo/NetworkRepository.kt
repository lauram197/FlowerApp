package com.example.flowerapp.repo

import com.example.flowerapp.service.RetrofitService

class NetworkRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllFlowers() = retrofitService.getAllFlowers()
}
