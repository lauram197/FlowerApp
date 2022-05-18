package com.example.flowerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flowerapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flowerDelivery = intent.getStringExtra("flowerDeliver")
        val flowerDescription = intent.getStringExtra("flowerDesc")
        val flowerPrice = intent.getIntExtra("flowerPrice",0)

        binding.deliver.text = getString(R.string.flower_deliver,flowerDelivery)
        binding.description.text = flowerDescription
        binding.price.text = getString(R.string.flower_price,flowerPrice)
    }
}