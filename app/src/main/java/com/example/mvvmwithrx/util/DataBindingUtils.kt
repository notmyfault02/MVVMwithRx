package com.example.mvvmwithrx.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.model.HistoricalSite

class DataBindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("app:item")
        fun setBindItem(recyclerView: RecyclerView, historicalSite: ArrayList<HistoricalSite>) {
            val adapter: MainAdapter

            if (recyclerView.adapter == null){
                adapter = MainAdapter(historicalSite)
                recyclerView.adapter = adapter
            }
            else {
                adapter = recyclerView.adapter as MainAdapter
            }

            adapter.setItem(historicalSite)

        }

        @JvmStatic
        @BindingAdapter("app:image")
        fun setImage(imageView: ImageView, imagePath: String) {
            Glide.with(imageView.context).load(imagePath).centerCrop().into(imageView)
        }
    }
}
