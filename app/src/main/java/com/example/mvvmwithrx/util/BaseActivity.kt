package com.example.mvvmwithrx.util

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T: ViewDataBinding, R: BaseViewModel>: AppCompatActivity() {

    lateinit var binding: T

    abstract val layoutId : Int

    abstract val viewModel: R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }
}