package com.example.mvvmwithrx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.mvvmwithrx.connect.Connecter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mArrayList: ArrayList<HistoricalSite>
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: MainAdapter
    lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        val vm = ViewModelProviders.of(this) [MainViewModel::class.java]
//        binding.setLifecycleOwner(this)
//        binding.vm = vm

        mRecyclerView = findViewById(R.id.mainRv)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        mArrayList = ArrayList()

        setAdapterData()
    }

    fun setAdapterData(): ArrayList<HistoricalSite> {
        var data = ArrayList<HistoricalSite>()
        Connecter.api.getPhoto().enqueue(object: Callback<ArrayList<HistoricalSite>> {
            override fun onResponse(call: Call<ArrayList<HistoricalSite>>, response: Response<ArrayList<HistoricalSite>>) {
                mArrayList = response!!.body()!!
                mAdapter = MainAdapter(mArrayList)
                mRecyclerView.adapter = mAdapter

                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ArrayList<HistoricalSite>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "에러", Toast.LENGTH_SHORT).show()
            }
        })
        return data
    }

}
