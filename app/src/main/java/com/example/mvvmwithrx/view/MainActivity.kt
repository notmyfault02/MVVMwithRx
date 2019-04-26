package com.example.mvvmwithrx.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        viewModel.setAdapterData()
    }

}
