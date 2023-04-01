package com.geektech.home3month6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.geektech.home3month6.databinding.ActivityMainBinding
import com.geektech.home3month6.viewmodel.MathViewModel
import com.geektech.tasks.ui.onBoarding.adapter.MathAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var viewModel: MathViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVP()
    }

    private fun setVP() {
        var counter: Int? = 0
        var history: String? = ""
        viewModel?.pointsLive?.observe(this) {
            var counter = it
        }
        viewModel?.historyLive?.observe(this) {
            history = it.toString()
        }
        val adapter = MathAdapter(counter!!, history!!, this::onPlusClick, this::onMinusClick)
binding.mathVP.adapter =adapter
        binding.indicator.setViewPager(binding.mathVP)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }



    private fun onMinusClick() {
        viewModel?.minus()
        setVP()
    }

    private fun onPlusClick() {
        viewModel?.plus()
        setVP()
    }
}