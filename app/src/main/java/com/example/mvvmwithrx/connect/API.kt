package com.example.mvvmwithrx.connect

import com.example.mvvmwithrx.model.HistoricalSite
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("main/bla")
    fun getPhoto(): Single<ArrayList<HistoricalSite>>

}