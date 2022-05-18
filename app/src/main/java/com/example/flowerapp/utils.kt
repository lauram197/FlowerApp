package com.example.flowerapp

import android.util.Log

fun logd(message: String? = "missing message", cause: Throwable? = null) {
    Log.d("FlowerApp", message, cause)
}

fun loge(message: String? = "missing message", cause: Throwable? = null) {
    Log.e("FlowerApp", message, cause)
}