package com.example.mvvmwithrx.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.model.HistoricalSite

class DataBindingUtils {
    @BindingAdapter("bind_items")
    fun setBindItems(view: RecyclerView, items: List<HistoricalSite.Document>) {
        val adapter = view.adapter as? MainAdapter?: MainAdapter().apply { view.adapter = this }
    }
}