package com.example.jadwalsholatmvp.view

import com.example.jadwalsholatmvp.model.Item

interface ISalatView {

    fun onCompliteFromApi(salat:Item)
    fun onDataErrorFromApi(throwable: Throwable)
}