package com.geektech.home3month6.math

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.geektech.home3month6.R
import com.geektech.home3month6.databinding.FragmentPointBinding
import com.geektech.home3month6.viewmodel.MathViewModel

class PointFragment : Fragment() {
    private lateinit var binding: FragmentPointBinding
    private lateinit var viewModel: MathViewModel
 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentPointBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity())[MathViewModel::class.java]
    initClicker()
    }

    private fun initClicker() {
        with(binding){
            minusBtn.setOnClickListener { viewModel.minus() }
            plusBtn.setOnClickListener { viewModel.plus() }
        }
    }
}