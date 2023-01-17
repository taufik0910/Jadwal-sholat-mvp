package com.example.jadwalsholatmvp.presenter

import android.content.Context
import com.example.jadwalsholatmvp.model.Item
import com.example.jadwalsholatmvp.model.Sholat
import com.example.jadwalsholatmvp.service.RetrofitService
import com.example.jadwalsholatmvp.view.ISalatView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ShalatPresenter(context: Context) {
    val salatView = context as ISalatView

    fun getDataFromApi(city: String){
        RetrofitService.created().getApi(city).enqueue(object : retrofit2.Callback<Sholat> {
            override fun onResponse(call: Call<Sholat>, response: Response<Sholat>) {
                salatView.onCompliteFromApi(response.body()?.items?.get(0) as Item)


            }

            override fun onFailure(call: Call<Sholat>, t: Throwable) {
                salatView.onDataErrorFromApi(t)
            }

        })

    }
}