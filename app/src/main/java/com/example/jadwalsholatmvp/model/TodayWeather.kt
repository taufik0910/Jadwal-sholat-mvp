package com.example.jadwalsholatmvp.model


import com.google.gson.annotations.SerializedName

class TodayWeather(
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("temperature")
    val temperature: String
)