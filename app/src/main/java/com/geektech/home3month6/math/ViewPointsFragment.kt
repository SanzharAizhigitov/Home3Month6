package com.geektech.home3month6.math

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geektech.home3month6.R
import com.geektech.home3month6.databinding.FragmentViewPointsBinding
import com.geektech.home3month6.viewmodel.MathViewModel

class ViewPointsFragment : Fragment() {
    lateinit var binding: FragmentViewPointsBinding
    lateinit var  viewModel: MathViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPointsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MathViewModel::class.java]
    initView()
    }

    private fun initView() {
        viewModel.pointsLive.observe(viewLifecycleOwner, Observer {
            binding.pointsTv.text = it.toString()
        })
    }

}