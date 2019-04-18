package com.example.mvvmwithrx

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val historicalSiteName = MutableLiveData<String>()
    val historicalSiteLocation = MutableLiveData<String>()


}