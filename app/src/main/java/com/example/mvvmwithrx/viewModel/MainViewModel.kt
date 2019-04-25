package com.example.mvvmwithrx.viewModel

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.widget.Toast
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.connect.Connecter
import com.example.mvvmwithrx.model.HistoricalSite
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel {

    val items = ObservableArrayList<HistoricalSite>()

    fun setItems(){
        items.add(HistoricalSite("A", "A", "A"))
        items.add(HistoricalSite("A", "A", "B"))
        items.add(HistoricalSite("A", "A", "C"))
        items.add(HistoricalSite("A", "A", "D"))
    }

    fun setAdapterData(): ArrayList<HistoricalSite> {
        var data = ArrayList<HistoricalSite>()

        Connecter.api.getPhoto()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                mArrayList = it
                mAdapter = MainAdapter(mArrayList)
                mRecyclerView.adapter = mAdapter

                mAdapter.notifyDataSetChanged()
            }, {
                Toast.makeText(this@MainActivity, "에러", Toast.LENGTH_SHORT).show()
            })

        return data
    }

}