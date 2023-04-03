package com.geektech.home3month6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.geektech.home3month6.databinding.ActivityMainBinding
import com.geektech.home3month6.viewmodel.MathViewModel
import com.geektech.tasks.ui.onBoarding.adapter.MathAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MathAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
adapter = MathAdapter(this)
binding.mathVP.adapter = adapter
        binding.indicator.setViewPager(binding.mathVP)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }


}