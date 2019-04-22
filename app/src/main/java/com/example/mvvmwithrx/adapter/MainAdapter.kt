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

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    data class ImageItem(var imagePath:String, val location:String, val name: String)

    val items: List<HistoricalSite.Document> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    val imageItemList = ArrayList<ImageItem>()

    override fun getItemCount(): Int = imageItemList.size


    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        (p0 as? MainViewHolder)?.bind(imageItemList[p1])
    }

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val location = itemView.findViewById<TextView>(R.id.tvHistoryLocation)
        val name = itemView.findViewById<TextView>(R.id.tvHistoryName)

        fun bind(model: ImageItem) {
            with(itemView) {
                location.text = model.location
                name.text = model.name

                Glide.with(context)
                    .load(model.imagePath)
                    .centerCrop()
                    .into(imageHistory)
            }
        }
    }

    fun addImageItem(imagePath: String, location: String, name: String) {
        imageItemList.add(ImageItem(imagePath, location, name))
    }

}