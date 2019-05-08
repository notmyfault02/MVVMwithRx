package com.example.mvvmwithrx.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.util.Log
import com.example.mvvmwithrx.connect.Connecter
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(val app: Application): AndroidViewModel(app) {

    val items = ObservableArrayList<HistoricalSite>()

    val doShow = SingleLiveEvent<Any>()

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

    fun goDetail() = doShow.call()

}