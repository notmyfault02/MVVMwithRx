package com.example.mvvmwithrx.util

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.model.HistoricalSite

@BindingAdapter("item")
fun RecyclerView.setBindItem(historicalSite: LiveData<ArrayList<HistoricalSite>>) {
    val adapter: MainAdapter = adapter as MainAdapter
    historicalSite.value?.let { adapter.item = it }

}

@BindingAdapter("app:image")
fun setImage(imageView: ImageView, imagePath: String?) {
    Glide.with(imageView.context).load(imagePath).centerCrop().into(imageView)
    Log.d("imageView", imagePath)
}