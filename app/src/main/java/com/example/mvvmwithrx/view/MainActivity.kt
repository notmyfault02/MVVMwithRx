package com.example.mvvmwithrx.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.adapter.MainAdapter
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.model.HistoricalSite
import com.example.mvvmwithrx.util.BaseActivity
import com.example.mvvmwithrx.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

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
        //setContentView(R.layout.activity_main)
        val vm = ViewModelProviders.of(this) [MainViewModel::class.java]
        binding.setLifecycleOwner(this)
        binding.vm = vm

        mRecyclerView = findViewById(R.id.mainRv)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        mArrayList = ArrayList()

        viewModel.setAdapterData()
    }

    override fun initStartView() {
        mainRv.run {
            adapter = mAdapter
            layoutManager = mLayoutManager
        }
    }

    override fun initDataBinding() {
        viewModel.historicalSite.observe(this, Observer {
            it!!.documents.forEach {
                mAdapter.addImageItem(it.imagePath, it.location, it.name)
            }
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun initAfterBinding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun goDetail() {
        startActivity<DetailActivity>()
    }
}
