package com.example.mvvmwithrx.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.mvvmwithrx.connect.Connecter
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(app: Application): AndroidViewModel(app) {

    val items = MutableLiveData<ArrayList<HistoricalSite>>()
    val id = MutableLiveData<String>()

    val doShow = SingleLiveEvent<Any>()

    fun setAdapterData() {

        Connecter.api.getPhoto()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                items.value = it
            }, {
               Log.d("에러", "설마")
            })

    }

    fun goDetail(index: Int) {
        id.value = items.value!![index].historicalSiteName
        doShow.call()
    }

}