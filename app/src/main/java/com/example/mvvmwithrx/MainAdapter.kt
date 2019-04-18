package com.example.mvvmwithrx

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(val model: ArrayList<HistoricalSite>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainAdapter.MainViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_main, p0, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = model.size


    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) = p0.bind(model[p1])

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val location = itemView.findViewById<TextView>(R.id.tvHistoryLocation)
        val name = itemView.findViewById<TextView>(R.id.tvHistoryName)

        fun bind(model: HistoricalSite) {
            with(itemView) {
                location.text = model.location
                name.text = model.name

                Glide.with(context)
                    .load(model.imagePath)
                    .fitCenter()
                    .into(imageHistory)
            }
        }
    }
}