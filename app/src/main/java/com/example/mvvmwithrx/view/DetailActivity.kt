package com.example.mvvmwithrx.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmwithrx.R
import com.example.mvvmwithrx.databinding.ActivityDetailBinding
import com.example.mvvmwithrx.viewModel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    val viewModel = DetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        binding.vm = viewModel
    }

}
