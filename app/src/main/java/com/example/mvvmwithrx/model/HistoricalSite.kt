package com.example.mvvmwithrx.model

import com.google.gson.annotations.SerializedName

data class HistoricalSite(
    @SerializedName ("historicalSiteImagePath")
    val imagePath: String,
    @SerializedName ("historicalSiteLocation")
    val location: String,
    @SerializedName ("historicalSiteName")
    val name: String,
    @SerializedName("historicalSiteCode")
    val code: String
)