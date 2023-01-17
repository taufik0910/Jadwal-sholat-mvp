package com.example.jadwalsholatmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jadwalsholatmvp.databinding.ActivityMainBinding
import com.example.jadwalsholatmvp.model.Item
import com.example.jadwalsholatmvp.presenter.ShalatPresenter
import com.example.jadwalsholatmvp.view.ISalatView

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), ISalatView {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ShalatPresenter(this).getDataFromApi("jakarta")

    }


    override fun onCompliteFromApi(salat: Item) {
        binding.tvSubuh.text = salat.fajr
        binding.tvZuhur.text = salat.dhuhr
        binding.tvAzhar.text = salat.asr
        binding.tvMagrib.text = salat.maghrib
        binding.tvIsya.text = salat.isha
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
       error("error------- > ${throwable.localizedMessage}")
        Toast.makeText(this,"Error ${throwable.localizedMessage}",Toast.LENGTH_SHORT).show()
    }
}