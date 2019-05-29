package com.example.mvvmwithrx.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmwithrx.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvHistory.setText(intent.getStringExtra("id"))
    }
}
