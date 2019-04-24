package com.example.mvvmwithrx.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.model.HistoricalSite
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(val model: ArrayList<HistoricalSite>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }
    override fun getItemCount(): Int = model.size


    override fun onBindViewHolder(viewHolder: MainViewHolder, p1: Int) {
        viewHolder.bind(model[p1])
    }

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val location = itemView.findViewById<TextView>(R.id.tvHistoryLocation)
        val name = itemView.findViewById<TextView>(R.id.tvHistoryName)

        fun bind(model: HistoricalSite) {
            with(itemView){
                location.text = model.location
                name.text = model.name

                Glide.with(context)
                    .load(model.imagePath)
                    .centerCrop()
                    .into(imageHistory)
            }
        }

    }
}