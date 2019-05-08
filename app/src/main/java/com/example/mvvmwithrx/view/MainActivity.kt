package com.example.mvvmwithrx.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.util.DataBindingActivity
import com.example.mvvmwithrx.viewModel.MainViewModel
import org.jetbrains.anko.startActivity

class MainActivity : DataBindingActivity<ActivityMainBinding>(){

    override val layoutId: Int
        get() = R.layout.activity_main

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel
        viewModel.setAdapterData()
        viewModel.doShow.observe(this, Observer { startActivity<DetailActivity>() })

    }



}