package com.example.mvvmwithrx.connect

import com.example.mvvmwithrx.HistoricalSite
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("main/usu")
    fun getPhoto(): Call<ArrayList<HistoricalSite>>
}