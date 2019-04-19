package com.example.mvvmwithrx.viewModel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmwithrx.model.HistoricalSite

class ItemViewModel(val history: HistoricalSite ,val context: Context, val constract: Constract): BaseObservable() {
    @BindingAdapter("historicalSiteImagePath")
    fun setImageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    fun onItemClick(v: View) {
        constract.goDetail()
    }
}