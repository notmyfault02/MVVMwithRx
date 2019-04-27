package com.example.mvvmwithrx.viewModel

import android.databinding.ObservableArrayList
import android.util.Log
import com.example.mvvmwithrx.connect.Connecter
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.util.Constract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(val constract: Constract) {

    val items = ObservableArrayList<HistoricalSite>()

    fun setAdapterData(): ArrayList<HistoricalSite> {
        var data = ArrayList<HistoricalSite>()

        Connecter.api.getPhoto()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                data = it
                for (i in data) {
                    items.add(i)
                }
            }, {
               Log.d("에러", "설마")
            })
        return data
    }

    fun goDetail() {
        Log.d("고", "디테일")
        constract.intentToDetail()
    }


}