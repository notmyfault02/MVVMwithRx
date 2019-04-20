package com.example.mvvmwithrx.viewModel

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmwithrx.model.HistoricalSite

class ItemViewModel(val historicalSite: HistoricalSite): BaseObservable() {

    val historicalSiteName = MutableLiveData<String>()
    val historicalSiteLocation = MutableLiveData<String>()

    @BindingAdapter("historicalSiteImagePath")
    fun setImageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    fun onItemClick(v: View) {

    }
}