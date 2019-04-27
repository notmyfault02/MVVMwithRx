package com.example.mvvmwithrx.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.databinding.ActivityMainBinding
import com.example.mvvmwithrx.util.Constract
import com.example.mvvmwithrx.viewModel.MainViewModel
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), Constract {

    private val viewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        viewModel.setAdapterData()
    }

    override fun intentToDetail() = startActivity<DetailActivity>()
}