package com.example.mvvmwithrx.view

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        viewModel.setItems()
        binding.vm = viewModel
    }

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
    }

}
