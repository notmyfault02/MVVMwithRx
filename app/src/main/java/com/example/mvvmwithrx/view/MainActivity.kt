package com.example.mvvmwithrx.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.connect.Connecter
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.util.BaseActivity
import com.example.mvvmwithrx.viewModel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){

    lateinit var mArrayList: ArrayList<HistoricalSite>
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: MainAdapter
    lateinit var mLayoutManager: LinearLayoutManager

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        val vm = ViewModelProviders.of(this) [MainViewModel::class.java]
        binding.setLifecycleOwner(this)
        binding.vm = vm

        mRecyclerView = findViewById(R.id.mainRv)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        mArrayList = ArrayList()

        setAdapterData()
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
