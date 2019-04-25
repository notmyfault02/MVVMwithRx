package com.example.mvvmwithrx.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvvmwithrx.BR
import com.example.mvvmwithrx.databinding.ItemMainBinding
import com.example.mvvmwithrx.model.HistoricalSite

class MainAdapter(private var model: ArrayList<HistoricalSite>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }
    override fun getItemCount(): Int = model.size


    override fun onBindViewHolder(viewHolder: MainViewHolder, p1: Int) {
        viewHolder.bind(model[p1])
    }

    inner class MainViewHolder(private val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: HistoricalSite) {
            binding.setVariable(BR.historicalSite, model)
        }

    }

    fun setItem(dataList: ArrayList<HistoricalSite>) {
        if(dataList.isEmpty())
            return

        this.model = dataList
        notifyDataSetChanged()
    }
}