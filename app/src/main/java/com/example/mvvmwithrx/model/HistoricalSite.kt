package com.example.mvvmwithrx.model

import com.google.gson.annotations.SerializedName

data class HistoricalSite(
    var documents: ArrayList<Document>
    ) {
    data class Document(
        @SerializedName ("historicalSiteImagePath")
        val imagePath: String,
        @SerializedName ("historicalSiteLocation")
        val location: String,
        @SerializedName ("historicalSiteName")
        val name: String

    )
}