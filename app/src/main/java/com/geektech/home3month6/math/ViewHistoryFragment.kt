package com.geektech.home3month6.math

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geektech.home3month6.R
import com.geektech.home3month6.databinding.FragmentViewHistoryBinding
import com.geektech.home3month6.databinding.FragmentViewPointsBinding
import com.geektech.home3month6.viewmodel.MathViewModel

class ViewHistoryFragment : Fragment() {
    lateinit var binding: FragmentViewHistoryBinding
    lateinit var  viewModel: MathViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MathViewModel::class.java]
        initView()
    }

    private fun initView() {
        viewModel.historyLive.observe(viewLifecycleOwner, Observer {
            binding.historyTv.text = it.toString()
        })
    }

}