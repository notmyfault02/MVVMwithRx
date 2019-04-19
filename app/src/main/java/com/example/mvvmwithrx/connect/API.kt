package com.example.mvvmwithrx.connect

import com.example.mvvmwithrx.model.HistoricalSite
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("main/bla")
    fun getPhoto(): Call<ArrayList<HistoricalSite>>
}