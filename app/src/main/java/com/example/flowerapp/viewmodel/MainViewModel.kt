package com.example.flowerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowerapp.domain.Flower
import com.example.flowerapp.repo.NetworkRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: NetworkRepository)  : ViewModel() {

    val flowerList = MutableLiveData<List<Flower>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFlowers() {

        val response = repository.getAllFlowers()
        response.enqueue(object : Callback<List<Flower>> {
            override fun onResponse(call: Call<List<Flower>>, response: Response<List<Flower>>) {
                flowerList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Flower>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}