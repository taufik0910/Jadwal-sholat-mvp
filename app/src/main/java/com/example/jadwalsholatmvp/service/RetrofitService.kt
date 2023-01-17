package com.example.jadwalsholatmvp.service

import com.example.jadwalsholatmvp.model.Sholat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{city}.json?key=b377d060dbcec29c8076da77aa661700")
    fun getApi(@Path("city")city:String): Call<Sholat>

    companion object{
        fun created(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com/").build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}