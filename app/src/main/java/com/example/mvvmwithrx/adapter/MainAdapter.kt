package com.example.mvvmwithrx.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvvmwithrx.databinding.ItemMainBinding
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.viewModel.MainViewModel

class MainAdapter(val viewModel: MainViewModel): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var item = arrayListOf<HistoricalSite>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }
    override fun getItemCount(): Int = item.size


    override fun onBindViewHolder(viewHolder: MainViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class MainViewHolder(private val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.vm=viewModel
            binding.index = adapterPosition
            binding.historicalSite = item[adapterPosition]
        }
    }
}