package com.example.mvvmwithrx.viewModel

import android.arch.lifecycle.MutableLiveData
import com.example.mvvmwithrx.util.BaseViewModel

class MainViewModel(): BaseViewModel() {

    val historicalSiteName = MutableLiveData<String>()
    val historicalSiteLocation = MutableLiveData<String>()

}