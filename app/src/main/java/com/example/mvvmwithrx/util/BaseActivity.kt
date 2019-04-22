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

        initDataBinding()
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }

    //레이아웃 띄운 직후 호출, 뷰나 액티비티 속성 초기화
    abstract fun initStartView()

    //두번째로 호출, 데이터 바인딩 및 rxjava 설정
    abstract fun initDataBinding()

    //바인딩 이후 할 일 구현, 클릭 리스너 이곳에 설정
    abstract fun initAfterBinding()

}