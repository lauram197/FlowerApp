package com.example.flowerapp.domain

data class Flower(
    val id: Int,
    val imageUrl: String,
    val price: Int,
    val deliver_to: String,
    val status: String,
    val desc: String
)
